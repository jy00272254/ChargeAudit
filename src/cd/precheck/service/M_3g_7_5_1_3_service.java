package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.M_3g_7_5_1_3_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 用于确认 7.5.1.3 渠道类综合月报 存储过程是否可以运行.
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
		log.info((flag1 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_5_1_3_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_ZH_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "通过" : "未通过")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 ;
		if(flag)
			log.warn(" 7.5.1.3 渠道类综合月报 REPORT.P_ZB_M_3G_CHANNEL_ZH [已]满足运行条件!");
		else
			log.warn(" 7.5.1.3 渠道类综合月报 REPORT.P_ZB_M_3G_CHANNEL_ZH [不]满足运行条件!");
		
		return flag;
	}
}
