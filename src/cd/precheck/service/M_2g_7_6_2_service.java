package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.M_2g_7_6_2_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * ����ȷ�� 7.6.2 �������ۺ�ͳ�� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_2g_7_6_2_service {
	
	private static Logger log = Logger.getLogger(M_2g_7_6_2_service.class);
	
	public boolean precheck(String time){
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_2g_7_6_2_sql.PRECHECK_REPORT_P_ZB_DEV_M_CHANNEL_XX_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_2g_7_6_2_sql.PRECHECK_REPORT_P_ZB_DEV_M_CHANNEL_XX_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2;
		if(flag)
			log.warn(" 7.6.2 �������ۺ�ͳ�� REPORT.P_ZB_DEV_M_CHANNEL_02/03/04/05 [��]������������!");
		else
			log.warn(" 7.6.2 �������ۺ�ͳ�� REPORT.P_ZB_DEV_M_CHANNEL_02/03/04/05 [��]������������!");
		
		return flag;
	}
}
