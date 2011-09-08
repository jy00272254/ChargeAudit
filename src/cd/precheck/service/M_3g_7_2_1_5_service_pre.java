package cd.precheck.service;

import org.apache.log4j.Logger;
import cd.util.check.ReflectCheck;

/**
 * ����ȷ�� 7.2.1.5 ����������ҵ�� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_1_5_service_pre {

	private static Logger log = Logger.getLogger(M_3g_7_2_1_5_service_pre.class);

	public boolean precheck(String time) {

		boolean flag = false;

		ReflectCheck rc = new ReflectCheck();
		//��⵱ǰ�洢�����Ƿ�������
		flag =rc.check("cd.precheck.sql.M_3g_7_2_1_5_sql_pre", time, "ǰ������:");
		//ֻ����ʾ��ǰ�洢���̵�ִ��״̬
		rc.check("cd.check.sql.M_3g_7_2_1_5_sql", time, "��ǰ״̬:");

		return flag;
	}

	public static void main(String[] args) {
		String time = "201108";
		boolean result = false;

		M_3g_7_2_1_5_service_pre _7215 = new M_3g_7_2_1_5_service_pre();
		result = _7215.precheck(time);
		log.warn(result);
	}
}
