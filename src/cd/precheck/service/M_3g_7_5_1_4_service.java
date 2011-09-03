package cd.precheck.service;

import org.apache.log4j.Logger;

import cd.precheck.sql.M_3g_7_5_1_4_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 用于确认 7.5.1.4 渠道数量类月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_4_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_5_1_4_service.class);
	
	public boolean precheck(String time){
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_01;
		boolean flag1 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_02;
		boolean flag2 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_03;
		boolean flag3 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_04;
		boolean flag4 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag4 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_05;
		boolean flag5 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag5 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_06;
		boolean flag6 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag6 ? "通过" : "未通过")	+" -- " + sql);
		
		boolean flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6;
		
		if(flag)
			log.warn(" 7.5.1.4 渠道数量类月报 REPORT.P_ZB_M_3G_CHANNEL_02/03/04/05 [已]满足运行条件!");
		else
			log.warn(" 7.5.1.4 渠道数量类月报 REPORT.P_ZB_M_3G_CHANNEL_02/03/04/05 [不]满足运行条件!");
		
		return flag;
	}
}
