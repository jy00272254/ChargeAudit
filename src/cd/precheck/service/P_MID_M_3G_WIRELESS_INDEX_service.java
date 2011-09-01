package cd.precheck.service;

import java.sql.Connection;

import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.P_MID_M_3G_WIRELESS_INDEX_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

public class P_MID_M_3G_WIRELESS_INDEX_service {
	
	private static Logger log = Logger.getLogger(P_MID_M_3G_WIRELESS_INDEX_service.class);
	
	public boolean precheck(String time){
	
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = P_MID_M_3G_WIRELESS_INDEX_sql.PRECHECK_MID_P_MID_M_3G_WIRELESS_INDEX_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "通过" : "未通过")	+" -- " + sql);

		sql = P_MID_M_3G_WIRELESS_INDEX_sql.PRECHECK_MID_P_MID_M_3G_WIRELESS_INDEX_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = P_MID_M_3G_WIRELESS_INDEX_sql.PRECHECK_MID_P_MID_M_3G_WIRELESS_INDEX_03;
		boolean flag3 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = P_MID_M_3G_WIRELESS_INDEX_sql.PRECHECK_MID_P_MID_M_3G_WIRELESS_INDEX_04;
		boolean flag4 = pm.check_success(conn, TimeFormat.DAY, null, sql);
		log.info((flag4 ? "通过" : "未通过")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 && flag3 && flag4;
		if(flag)
			log.warn("MID.P_MID_M_3G_WIRELESS_INDEX [已]满足运行条件!");
		else
			log.warn("MID.P_MID_M_3G_WIRELESS_INDEX [不]满足运行条件!");
		
		return flag;
	}
}
