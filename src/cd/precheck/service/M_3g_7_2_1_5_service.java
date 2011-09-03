package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.check.service.Check_Service;
import cd.check.service.ProcId;
import cd.db2.DB2Factory;
import cd.precheck.sql.M_3g_7_2_1_5_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 用于确认 7.2.1.5 无线上网卡业务 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_1_5_service {

	private static Logger log = Logger.getLogger(M_3g_7_2_1_5_service.class);

	public boolean precheck(String time) {

		boolean flag = false;
		
		// 过程前置依赖条件
		// 7.2.1.5 必须先运行 P_MID_M_3G_WIRELESS_INDEX
		Check_Service cs = new Check_Service();
		int statusId = cs.checkSingle(ProcId.P_MID_M_3G_WIRELESS_INDEX,
				TimeFormat.MONTH, time);
		if (statusId != 1) {
			log.warn(" 7.2.1.5 无线上网卡业务 REPORT.P_ZB_DEV_M_3G_05_02/03/05/06/09/11/13/15 [不]满足运行条件!");
			log.warn("		原因:MID.P_MID_M_3G_WIRELESS_INDEX "	+ LogCheck.getStatus(statusId));
		} else {

			// 过程前置依赖条件
			Connection conn = DB2Factory.getConn();
			if (conn == null)
				return false;

			LogCheck pm = new LogCheck();

			String sql = M_3g_7_2_1_5_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_01;
			boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
			log.info((flag1 ? "通过" : "未通过") + " -- " + sql);

			sql = M_3g_7_2_1_5_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_02;
			boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
			log.info((flag2 ? "通过" : "未通过") + " -- " + sql);

			sql = M_3g_7_2_1_5_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_03;
			boolean flag3 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
			log.info((flag3 ? "通过" : "未通过") + " -- " + sql);

			sql = M_3g_7_2_1_5_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_04;
			boolean flag4 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
			log.info((flag4 ? "通过" : "未通过") + " -- " + sql);

			DB2Factory.closeConn(conn);

			flag = flag1 && flag2 && flag3 && flag4;
			if (flag)
				log.warn(" 7.2.1.5 无线上网卡业务 REPORT.P_ZB_DEV_M_3G_05_02/03/05/06/09/11/13/15 [已]满足运行条件!");
			else
				log.warn(" 7.2.1.5 无线上网卡业务 REPORT.P_ZB_DEV_M_3G_05_02/03/05/06/09/11/13/15 [不]满足运行条件!");
		}
		
		// 判断过程当前运行状态
		log.warn("		当前状态:");
		statusId = cs.checkSingle(ProcId.M_3g_7_2_1_5_02, TimeFormat.MONTH, time);
		log.warn("				REPORT.P_ZB_DEV_M_3G_05_02 "	+ LogCheck.getStatus(statusId));
		statusId = cs.checkSingle(ProcId.M_3g_7_2_1_5_03, TimeFormat.MONTH, time);
		log.warn("				REPORT.P_ZB_DEV_M_3G_05_03 "	+ LogCheck.getStatus(statusId));
		statusId = cs.checkSingle(ProcId.M_3g_7_2_1_5_05, TimeFormat.MONTH, time);
		log.warn("				REPORT.P_ZB_DEV_M_3G_05_05 "	+ LogCheck.getStatus(statusId));
		statusId = cs.checkSingle(ProcId.M_3g_7_2_1_5_06, TimeFormat.MONTH, time);
		log.warn("				REPORT.P_ZB_DEV_M_3G_05_06 "	+ LogCheck.getStatus(statusId));
		statusId = cs.checkSingle(ProcId.M_3g_7_2_1_5_09, TimeFormat.MONTH, time);
		log.warn("				REPORT.P_ZB_DEV_M_3G_05_09 "	+ LogCheck.getStatus(statusId));
		statusId = cs.checkSingle(ProcId.M_3g_7_2_1_5_11, TimeFormat.MONTH, time);
		log.warn("				REPORT.P_ZB_DEV_M_3G_05_11 "	+ LogCheck.getStatus(statusId));
		statusId = cs.checkSingle(ProcId.M_3g_7_2_1_5_13, TimeFormat.MONTH, time);
		log.warn("				REPORT.P_ZB_DEV_M_3G_05_13 "	+ LogCheck.getStatus(statusId));
		statusId = cs.checkSingle(ProcId.M_3g_7_2_1_5_15, TimeFormat.MONTH, time);
		log.warn("				REPORT.P_ZB_DEV_M_3G_05_15 "	+ LogCheck.getStatus(statusId));
		
		return flag;
	}
	
	public static void main(String[] args) {
		String time = "201108";
		boolean result = false;
		
		M_3g_7_2_1_5_service _7215 = new M_3g_7_2_1_5_service();
		result = _7215.precheck(time);
		log.warn(result);
	}
}
