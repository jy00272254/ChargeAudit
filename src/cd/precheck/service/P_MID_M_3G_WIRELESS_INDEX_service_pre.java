package cd.precheck.service;

import org.apache.log4j.Logger;
import cd.util.check.ReflectCheck;

public class P_MID_M_3G_WIRELESS_INDEX_service_pre {
	
	private static Logger log = Logger.getLogger(P_MID_M_3G_WIRELESS_INDEX_service_pre.class);
	
	public boolean precheck(String time){

		boolean flag = false;

		ReflectCheck rc = new ReflectCheck();
		//��⵱ǰ�洢�����Ƿ�������
		flag =rc.check("cd.precheck.sql.P_MID_M_3G_WIRELESS_INDEX_pre", time, "ǰ������:");
		//ֻ����ʾ��ǰ�洢���̵�ִ��״̬
		rc.check("cd.check.sql.P_MID_M_3G_WIRELESS_INDEX_sql", time, "��ǰ״̬:");

		return flag;
	}
	
	public static void main(String[] args) {
		P_MID_M_3G_WIRELESS_INDEX_service_pre _3g82 = new P_MID_M_3G_WIRELESS_INDEX_service_pre();
		boolean result = _3g82.precheck("201108");
		log.warn(result);
	}
}
