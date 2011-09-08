package cd.check.sql;

public class M_3g_7_3_1_4_sql {
	
	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	// 7.3.1.4 无线上网卡业务量月报
	public static final String M_3g_7_3_1_4_02_PROCNAME = "REPORT.P_ZB_USE_M_3G_04_02";
	public static final String M_3g_7_3_1_4_03_PROCNAME = "REPORT.P_ZB_USE_M_3G_04_03";
	public static final String M_3g_7_3_1_4_07_PROCNAME = "REPORT.P_ZB_USE_M_3G_04_07";
	// 7.3.1.4 无线上网卡业务量月报
	public static final String M_3g_7_3_1_4_02 = headREPORT + "REPORT.P_ZB_USE_M_3G_04_02" + tail;
	public static final String M_3g_7_3_1_4_03 = headREPORT + "REPORT.P_ZB_USE_M_3G_04_03" + tail;
	public static final String M_3g_7_3_1_4_07 = headREPORT + "REPORT.P_ZB_USE_M_3G_04_07" + tail;

}
