package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.M_2g_8_3_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * ����ȷ�� 8.3 �ۺ�ָ��� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_2g_8_3_service {
	
	private static Logger log = Logger.getLogger(M_2g_8_3_service.class);
	
	public boolean precheck(String time){
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_2g_8_3_sql.PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_2g_8_3_sql.PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_2g_8_3_sql.PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_03;
		boolean flag3 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 && flag3;
		if(flag)
			log.warn(" 8.3 �ۺ�ָ��� REPORT.P_ZB_ZH_M_ZH_06 [��]������������!");
		else
			log.warn(" 8.3 �ۺ�ָ��� REPORT.P_ZB_ZH_M_ZH_06 [��]������������!");
		
		return flag;
	}
}
