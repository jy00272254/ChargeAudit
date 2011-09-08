package cd.check.sql;

public class M_3g_8_2_sql {

	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";

	// 3g 8.2 综合指标快报一
	public static final String M_3g_8_2_02_PROCNAME = "REPORT.P_ZB_M_ZH_3G_02";
	public static final String M_3g_8_2_03_PROCNAME = "REPORT.P_ZB_M_ZH_3G_03";
	public static final String M_3g_8_2_02 = headREPORT + "REPORT.P_ZB_M_ZH_3G_02" + tail;
	public static final String M_3g_8_2_03 = headREPORT + "REPORT.P_ZB_M_ZH_3G_03" + tail;

}
