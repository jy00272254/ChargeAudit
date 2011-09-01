package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.M_2g_8_2_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * ����ȷ�� 8.2 �ۺ�ָ��һ �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_2g_8_2_service {
	
	private static Logger log = Logger.getLogger(M_2g_8_2_service.class);
	
	public boolean precheck(String time){
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_2g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_02_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_2g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_02_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_2g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_02_03;
		boolean flag3 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_2g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_02_04;
		boolean flag4 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag4 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_2g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_02_05;
		boolean flag5 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag5 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_2g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_02_06;
		boolean flag6 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag6 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6;
		if(flag)
			log.warn(" 8.2 �ۺ�ָ��һ REPORT.P_ZB_M_ZH_02 [��]������������!");
		else
			log.warn(" 8.2 �ۺ�ָ��һ REPORT.P_ZB_M_ZH_02 [��]������������!");
		
		return flag;
	}
}
