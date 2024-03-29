package cd.util.check;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import cd.util.time.TimeFormat;

public class ReflectCheck {

	private Logger log = Logger.getLogger(ReflectCheck.class);
	
	/**
	 * 用于稽核传入的类中所定义的SQL语句
	 * 传入 类名(要带完整包名), 稽核时间, 提示信息
	 * @param className
	 * @param time
	 * @param note
	 * @return
	 */
	public boolean check(String className, String time, String note){
		boolean preResult = true;
		String tab = "	";
		LogCheck pm = new LogCheck();
		try {
			Map<String, String> procnames = new HashMap<String, String>();
			Map<String, String> sqls = new HashMap<String, String>();

			Field[] sqlsFields = Class.forName(className).getFields();
			for (Field sqlsField : sqlsFields) {
				String sql = (String) sqlsField.get(Class.forName(className).newInstance());
				if (sqlsField.getName().endsWith("_PROCNAME")) {
					//以 _PROCNAME 结尾表示存储过程名
					procnames.put(sqlsField.getName(), sql);
				} else if(sqlsField.getName().endsWith("_SERVICENAME")){
					//以_SERVICENAME 结尾表示文件接口名
					log.warn(tab+"业务名称:");
					log.warn(tab+tab+sql);
				} else {
					// 否则表示查询语句
					sqls.put(sqlsField.getName(), sql);
				}
			}
			
			log.warn(tab+note);
			Set<String> keys = sqls.keySet();
			for (String key : keys) {
				int preFlag = 0;
				int avgDuration = 0;
				String begin_time = null;
				String end_time = null;
				String timeFormat = null;
				//首先判断是不是日表,根据公司定义的规则,如果是日表那么必定会出现这个字段 "_D_"
				// 通过正则表达式匹配.如果包含则转为日验证
				if(procnames.get(key + "_PROCNAME").matches(".*?_D_.*?")){
					timeFormat = TimeFormat.DAY;
				}else{
					timeFormat = TimeFormat.MONTH;
				}
				// 获取运行结果
				preFlag = pm.check(timeFormat, time, sqls.get(key));
				// 获取运行平均时间
				avgDuration = pm.avgDuration(timeFormat, time, sqls.get(key));
				// 获取开始时间
				begin_time = pm.begin_time(timeFormat, time, sqls.get(key));
				// 获取结束时间
				end_time = pm.end_time(timeFormat, time, sqls.get(key));
				
				switch(preFlag){
				//执行成功
				case 1:
					log.warn(tab+tab+
							procnames.get(key + "_PROCNAME") + tab+ tab + 
							LogCheck.getStatus(preFlag) + tab + 
							avgDuration + tab +
							begin_time + tab +
							end_time);
					break;
				//正在执行中
				case 2:
					log.warn(tab+tab+
							procnames.get(key + "_PROCNAME") + tab+ tab + 
							LogCheck.getStatus(preFlag) + tab + 
							avgDuration + tab +
							begin_time);
					break;
				// 其他情况
				default:
					log.warn(tab+tab+
							procnames.get(key + "_PROCNAME") + tab+ tab + 
							LogCheck.getStatus(preFlag) + tab + 
							avgDuration);
					break;
				}
				
				preResult = preResult && preFlag == 1;
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return preResult;
	}
}
