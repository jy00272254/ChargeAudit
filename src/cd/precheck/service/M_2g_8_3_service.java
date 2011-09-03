package cd.precheck.service;

import org.apache.log4j.Logger;

import cd.precheck.sql.M_2g_8_3_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 用于确认 8.3 综合指标二 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_2g_8_3_service {
	
	private static Logger log = Logger.getLogger(M_2g_8_3_service.class);
	
	public boolean precheck(String time){
		
		LogCheck pm = new LogCheck();
		
		String sql = M_2g_8_3_sql.PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_01;
		boolean flag1 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_2g_8_3_sql.PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_02;
		boolean flag2 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_2g_8_3_sql.PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_03;
		boolean flag3 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "通过" : "未通过")	+" -- " + sql);
		
		boolean flag = flag1 && flag2 && flag3;
		if(flag)
			log.warn(" 8.3 综合指标二 REPORT.P_ZB_ZH_M_ZH_06 [已]满足运行条件!");
		else
			log.warn(" 8.3 综合指标二 REPORT.P_ZB_ZH_M_ZH_06 [不]满足运行条件!");
		
		return flag;
	}
}
