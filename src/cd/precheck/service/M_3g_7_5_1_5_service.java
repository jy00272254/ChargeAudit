package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.check.service.Check_Service;
import cd.check.service.ProcId;
import cd.db2.DB2Factory;
import cd.precheck.sql.M_3g_7_5_1_5_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 
 * У��ù�������Ϊ�ù������к�������� 7.5.1.6 ����.���Ǳ���ù��̲���Ҫ�Ҹ���.
 * ����ȷ�� 7.5.1.5 �����ն����±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_5_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_5_1_5_service.class);
	
	public boolean precheck(String time){
		
		//�ù��̱���ǰ�ù��� 7.5.1.3 ���к��������
		Check_Service cs = new Check_Service();
		int statusId = cs.checkSingle(ProcId.M_3g_7_5_1_3, TimeFormat.MONTH, time);
		if(statusId != 1){
			log.warn(" 7.5.1.5 �����ն����±� REPORT.P_ZB_CHANNEL_M_3G_05_02 [��]������������!");
			log.warn("		ԭ��:7.5.1.3 REPORT.P_ZB_M_3G_CHANNEL_ZH " + LogCheck.getStatus(statusId));
			return false;
		}
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_5_1_5_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_05_02_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_5_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_05_02_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2;
		if(flag)
			log.warn(" 7.5.1.5 �����ն����±� REPORT.P_ZB_CHANNEL_M_3G_05_02 [��]������������!");
		else
			log.warn(" 7.5.1.5 �����ն����±� REPORT.P_ZB_CHANNEL_M_3G_05_02 [��]������������!");
		
		return flag;
	}
}
