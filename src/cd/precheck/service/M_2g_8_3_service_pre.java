package cd.precheck.service;

import org.apache.log4j.Logger;
import cd.util.check.ReflectCheck;

/**
 * ����ȷ�� 8.3 �ۺ�ָ��� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_2g_8_3_service_pre {
	
	private static Logger log = Logger.getLogger(M_2g_8_3_service_pre.class);
	
	public boolean precheck(String time){

		boolean flag = false;

		ReflectCheck rc = new ReflectCheck();
		//��⵱ǰ�洢�����Ƿ�������
		flag =rc.check("cd.precheck.sql.M_2g_8_3_sql_pre", time, "ǰ������:");
		//ֻ����ʾ��ǰ�洢���̵�ִ��״̬
		rc.check("cd.check.sql.M_2g_8_3_sql", time, "��ǰ״̬:");

		return flag;
	}
	
	public static void main(String[] args) {
		String time = "201108";
		boolean result = false;

		M_2g_8_3_service_pre _2g83 = new M_2g_8_3_service_pre();
		result = _2g83.precheck(time);
		log.warn(result);
	}
}
