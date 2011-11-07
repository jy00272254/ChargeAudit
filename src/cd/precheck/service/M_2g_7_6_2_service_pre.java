package cd.precheck.service;

import org.apache.log4j.Logger;
import cd.util.check.ReflectCheck;

/**
 * ����ȷ�� 7.6.2 �������ۺ�ͳ�� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_2g_7_6_2_service_pre {
	
	private static Logger log = Logger.getLogger(M_2g_7_6_2_service_pre.class);
	
	public boolean precheck(String time){

		boolean flag = false;

		ReflectCheck rc = new ReflectCheck();
		//��⵱ǰ�洢�����Ƿ�������
		flag =rc.check("cd.precheck.sql.M_2g_7_6_2_sql_pre", time, "ǰ������:");
		//ֻ����ʾ��ǰ�洢���̵�ִ��״̬
		rc.check("cd.check.sql.M_2g_7_6_2_sql", time, "��ǰ״̬:");

		return flag;
	}
	
	public static void main(String[] args) {
		String time = "201110";
		boolean result = false;

		M_2g_7_6_2_service_pre _2g762 = new M_2g_7_6_2_service_pre();
		result = _2g762.precheck(time);
		log.warn(result);
	}
}
