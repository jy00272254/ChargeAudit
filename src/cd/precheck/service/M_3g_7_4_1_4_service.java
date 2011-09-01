package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.M_3g_7_4_1_4_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * ����ȷ�� 7.4.1.4 �������������� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_4_1_4_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_4_1_4_service.class);
	
	public boolean precheck(String time){
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_4_1_4_sql.PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_4_1_4_sql.PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_4_1_4_sql.PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_03;
		boolean flag3 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 && flag3;
		if(flag)
			log.warn(" 7.4.1.4 �������������� REPORT.P_ZB_INCO_M_3G_04_03/08 [��]������������!");
		else
			log.warn(" 7.4.1.4 �������������� REPORT.P_ZB_INCO_M_3G_04_03/08 [��]������������!");
		
		return flag;
	}
}
