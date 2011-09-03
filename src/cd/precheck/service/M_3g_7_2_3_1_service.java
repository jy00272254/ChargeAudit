package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.check.service.Check_Service;
import cd.check.service.ProcId;
import cd.db2.DB2Factory;
import cd.precheck.sql.M_3g_7_2_3_1_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 用于确认 7.2.3.1 渠道发展类统计 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_3_1_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_2_3_1_service.class);
	
	public boolean precheck(String time){
	
		// 7.2.3.1  必须先运行 P_MID_M_3G_WIRELESS_INDEX
		Check_Service cs = new Check_Service();
		int statusId = cs.checkSingle(ProcId.P_MID_M_3G_WIRELESS_INDEX, TimeFormat.MONTH, time);
		if(statusId != 1){
			log.warn(" 7.2.3.1 渠道发展类统计 REPORT.ZB_DEV_M_3G_09_XX [不]满足运行条件!");
			log.warn("		原因:MID.P_MID_M_3G_WIRELESS_INDEX " + LogCheck.getStatus(statusId));
			return false;
		}
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_2_3_1_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_09_XX_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_2_3_1_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_09_XX_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_2_3_1_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_09_XX_03;
		boolean flag3 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "通过" : "未通过")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 && flag3 ;
		if(flag)
			log.warn(" 7.2.3.1 渠道发展类统计 REPORT.ZB_DEV_M_3G_09_XX [已]满足运行条件!");
		else
			log.warn(" 7.2.3.1 渠道发展类统计 REPORT.ZB_DEV_M_3G_09_XX [不]满足运行条件!");
		
		return flag;
	}
	
	public static void main(String[] args) {
		M_3g_7_2_3_1_service _7231 = new M_3g_7_2_3_1_service();
		boolean result = _7231.precheck("201108");
		log.warn(result);
	}
}
