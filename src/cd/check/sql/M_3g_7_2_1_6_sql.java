package cd.check.sql;

public class M_3g_7_2_1_6_sql {
	
	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	// 7.2.1.6 定制专用无线上网卡发展月报
	public static final String M_3g_7_2_1_6_PROCNAME = "REPORT.P_ZB_DEV_M_3G_14_02";
	public static final String M_3g_7_2_1_6 = headREPORT + "REPORT.P_ZB_DEV_M_3G_14_02" + tail;
	
}
