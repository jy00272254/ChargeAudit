package cd.precheck.service;

import org.apache.log4j.Logger;

import cd.precheck.sql.M_3g_7_4_1_4_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 用于确认 7.4.1.4 无线上网卡收入 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_4_1_4_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_4_1_4_service.class);
	
	public boolean precheck(String time){
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_4_1_4_sql.PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_01;
		boolean flag1 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_4_1_4_sql.PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_02;
		boolean flag2 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_4_1_4_sql.PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_03;
		boolean flag3 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "通过" : "未通过")	+" -- " + sql);
		
		boolean flag = flag1 && flag2 && flag3;
		if(flag)
			log.warn(" 7.4.1.4 无线上网卡收入 REPORT.P_ZB_INCO_M_3G_04_03/08 [已]满足运行条件!");
		else
			log.warn(" 7.4.1.4 无线上网卡收入 REPORT.P_ZB_INCO_M_3G_04_03/08 [不]满足运行条件!");
		
		return flag;
	}
}
