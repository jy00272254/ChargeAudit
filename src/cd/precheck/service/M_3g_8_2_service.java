package cd.precheck.service;

import org.apache.log4j.Logger;

import cd.precheck.sql.M_3g_8_2_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 用于确认 8.2 综合指标快报一 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_8_2_service {
	
	private static Logger log = Logger.getLogger(M_3g_8_2_service.class);
	
	public boolean precheck(String time){
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_01;
		boolean flag1 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_02;
		boolean flag2 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_03;
		boolean flag3 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_04;
		boolean flag4 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag4 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_05;
		boolean flag5 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag5 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_8_2_sql.PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_06;
		boolean flag6 = pm.check_success( TimeFormat.DAY, null, sql);
		log.info((flag6 ? "通过" : "未通过")	+" -- " + sql);
		
		boolean flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6;
		if(flag)
			log.warn(" 8.2 综合指标快报一 REPORT.P_ZB_M_ZH_3G_02/03 [已]满足运行条件!");
		else
			log.warn(" 8.2 综合指标快报一 REPORT.P_ZB_M_ZH_3G_02/03 [不]满足运行条件!");
		
		return flag;
	}
}
