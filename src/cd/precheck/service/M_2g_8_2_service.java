package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.M_2g_8_2_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 用于确认 8.2 综合指标一 存储过程是否可以运行.
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
		log.info((flag1 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_2g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_02_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_2g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_02_03;
		boolean flag3 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_2g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_02_04;
		boolean flag4 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag4 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_2g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_02_05;
		boolean flag5 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag5 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_2g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_02_06;
		boolean flag6 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag6 ? "通过" : "未通过")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6;
		if(flag)
			log.warn(" 8.2 综合指标一 REPORT.P_ZB_M_ZH_02 [已]满足运行条件!");
		else
			log.warn(" 8.2 综合指标一 REPORT.P_ZB_M_ZH_02 [不]满足运行条件!");
		
		return flag;
	}
}
