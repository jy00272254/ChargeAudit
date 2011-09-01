package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.M_3g_7_2_1_6_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 用于确认 7.2.1.6 定制专用无线上网卡发展月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_1_6_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_2_1_6_service.class);
	
	public boolean precheck(String time){
	
		// 7.2.1.6 必须先运行 P_MID_M_3G_WIRELESS_INDEX
		P_MID_M_3G_WIRELESS_INDEX_service p = new P_MID_M_3G_WIRELESS_INDEX_service();
		if(!p.precheck(time)){
			return false;
		}
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_2_1_6_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_14_02_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "通过" : "未通过")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1;
		if(flag)
			log.warn(" 7.2.1.6 定制专用无线上网卡发展月报 REPORT.P_ZB_DEV_M_3G_14_02 [已]满足运行条件!");
		else
			log.warn(" 7.2.1.6 定制专用无线上网卡发展月报 REPORT.P_ZB_DEV_M_3G_14_02 [不]满足运行条件!");
		
		return flag;
	}
}
