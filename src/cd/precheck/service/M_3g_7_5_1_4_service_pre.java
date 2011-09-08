package cd.precheck.service;

import org.apache.log4j.Logger;
import cd.util.check.ReflectCheck;

/**
 * ����ȷ�� 7.5.1.4 �����������±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_4_service_pre {
	
	private static Logger log = Logger.getLogger(M_3g_7_5_1_4_service_pre.class);
	
	public boolean precheck(String time){

		boolean flag = false;

		ReflectCheck rc = new ReflectCheck();
		//��⵱ǰ�洢�����Ƿ�������
		flag =rc.check("cd.precheck.sql.M_3g_7_5_1_4_sql_pre", time, "ǰ������:");
		//ֻ����ʾ��ǰ�洢���̵�ִ��״̬
		rc.check("cd.check.sql.M_3g_7_5_1_4_sql", time, "��ǰ״̬:");

		return flag;
	}
	
	public static void main(String[] args) {
		M_3g_7_5_1_4_service_pre _7514 = new M_3g_7_5_1_4_service_pre();
		boolean result = _7514.precheck("201108");
		log.warn(result);
	}
}
