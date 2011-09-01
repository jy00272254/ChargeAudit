package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.M_3g_7_5_1_5_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 
 * 校验该过程是因为该过程运行后才能运行 7.5.1.6 过程.但是本身该过程不需要我负责.
 * 用于确认 7.5.1.5 渠道终端类月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_5_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_5_1_5_service.class);
	
	public boolean precheck(String time){
		
		boolean flag3 = false;
		//该过程必须前置过程 7.5.1.3 运行后才能运行
		M_3g_7_5_1_3_service _7513 = new M_3g_7_5_1_3_service();
		flag3 = _7513.precheck(time);
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_5_1_5_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_05_02_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "通过" : "未通过")	+" -- " + sql);
		
		sql = M_3g_7_5_1_5_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_05_02_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "通过" : "未通过")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 && flag3;
		if(flag)
			log.warn(" 7.5.1.5 渠道终端类月报 REPORT.P_ZB_CHANNEL_M_3G_05_02 [已]满足运行条件!");
		else
			log.warn(" 7.5.1.5 渠道终端类月报 REPORT.P_ZB_CHANNEL_M_3G_05_02 [不]满足运行条件!");
		
		return flag;
	}
}
