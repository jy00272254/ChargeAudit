package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.M_3g_7_5_1_3_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * ����ȷ�� 7.5.1.3 �������ۺ��±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_3_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_5_1_3_service.class);
	
	public boolean precheck(String time){
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_5_1_3_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_ZH_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_3_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_ZH_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 ;
		if(flag)
			log.warn(" 7.5.1.3 �������ۺ��±� REPORT.P_ZB_M_3G_CHANNEL_ZH [��]������������!");
		else
			log.warn(" 7.5.1.3 �������ۺ��±� REPORT.P_ZB_M_3G_CHANNEL_ZH [��]������������!");
		
		return flag;
	}
}
