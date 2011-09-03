package cd.precheck.service;

import org.apache.log4j.Logger;

import cd.precheck.sql.M_3g_7_3_1_5_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 用于确认 7.3.1.5 定制专用无线上网卡业务量月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_3_1_5_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_3_1_5_service.class);
	
	public boolean precheck(String time){
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_3_1_5_sql.PRECHECK_REPORT_P_ZB_USE_M_3G_WIRLESS_05_02_01;
		boolean flag1 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_3_1_5_sql.PRECHECK_REPORT_P_ZB_USE_M_3G_WIRLESS_05_02_02;
		boolean flag2 = pm.check_success( TimeFormat.DAY, null, sql);
		log.info((flag2 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_3_1_5_sql.PRECHECK_REPORT_P_ZB_USE_M_3G_WIRLESS_05_02_03;
		boolean flag3 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "通过" : "未通过")	+" -- " + sql);
		
		boolean flag = flag1 && flag2 && flag3;
		if(flag)
			log.warn(" 7.3.1.5 定制专用无线上网卡业务量月报 REPROT.P_ZB_USE_M_3G_WIRLESS_05_02 [已]满足运行条件!");
		else
			log.warn(" 7.3.1.5 定制专用无线上网卡业务量月报 REPROT.P_ZB_USE_M_3G_WIRLESS_05_02 [不]满足运行条件!");
		
		return flag;
	}
}
