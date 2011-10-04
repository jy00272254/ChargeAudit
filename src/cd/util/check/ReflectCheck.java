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
	 * ���ڻ��˴���������������SQL���
	 * ���� ����(Ҫ����������), ����ʱ��, ��ʾ��Ϣ
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
					//�� _PROCNAME ��β��ʾ�洢������
					procnames.put(sqlsField.getName(), sql);
				} else if(sqlsField.getName().endsWith("_SERVICENAME")){
					//��_SERVICENAME ��β��ʾ�ļ��ӿ���
					log.warn(tab+"ҵ������:");
					log.warn(tab+tab+sql);
				} else {
					// �����ʾ��ѯ���
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
				//�����ж��ǲ����ձ�,���ݹ�˾����Ĺ���,������ձ���ô�ض����������ֶ� "_D_"
				// ͨ��������ʽƥ��.���������תΪ����֤
				if(procnames.get(key + "_PROCNAME").matches(".*?_D_.*?")){
					timeFormat = TimeFormat.DAY;
				}else{
					timeFormat = TimeFormat.MONTH;
				}
				// ��ȡ���н��
				preFlag = pm.check(timeFormat, time, sqls.get(key));
				// ��ȡ����ƽ��ʱ��
				avgDuration = pm.avgDuration(timeFormat, time, sqls.get(key));
				// ��ȡ��ʼʱ��
				begin_time = pm.begin_time(timeFormat, time, sqls.get(key));
				// ��ȡ����ʱ��
				end_time = pm.end_time(timeFormat, time, sqls.get(key));
				
				switch(preFlag){
				//ִ�гɹ�
				case 1:
					log.warn(tab+tab+
							procnames.get(key + "_PROCNAME") + tab+ tab + 
							LogCheck.getStatus(preFlag) + tab + 
							avgDuration + tab +
							begin_time + tab +
							end_time);
					break;
				//����ִ����
				case 2:
					log.warn(tab+tab+
							procnames.get(key + "_PROCNAME") + tab+ tab + 
							LogCheck.getStatus(preFlag) + tab + 
							avgDuration + tab +
							begin_time);
					break;
				// �������
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
