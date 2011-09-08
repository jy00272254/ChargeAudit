package cd.check.sql;

public class M_3g_7_3_1_5_sql {
	
	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	//7.3.1.5 定制专用无线上网卡业务量月报
	public static final String M_3g_7_3_1_5_PROCNAME = "P_ZB_USE_M_3G_WIRLESS_05_02";
	public static final String M_3g_7_3_1_5 = headREPORT + "P_ZB_USE_M_3G_WIRLESS_05_02" + tail;

}
