package cd.util.check;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

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
		log.warn(tab+note);
		LogCheck pm = new LogCheck();
		try {
			Map<String, String> procnames = new HashMap<String, String>();
			Map<String, String> sqls = new HashMap<String, String>();

			Field[] sqlsFields = Class.forName(className).getFields();
			for (Field sqlsField : sqlsFields) {
				String sql = (String) sqlsField.get(Class.forName(className).newInstance());
				if (sqlsField.getName().endsWith("_PROCNAME")) {
					procnames.put(sqlsField.getName(), sql);
				} else {
					sqls.put(sqlsField.getName(), sql);
				}
			}
			Set<String> keys = sqls.keySet();
			for (String key : keys) {
				int preFlag = pm.check(time, sqls.get(key));
				log.warn(tab+tab+procnames.get(key + "_PROCNAME") + tab+ tab + LogCheck.getStatus(preFlag));
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
