package cd.check.sql;

public class M_3g_7_5_1_5_sql {

	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";

	//7.5.1.5 渠道终端类月报
	public static final String M_3g_7_5_1_5_PROCNAME = "REPORT.P_ZB_CHANNEL_M_3G_05_02";
	public static final String M_3g_7_5_1_5 = headREPORT + "REPORT.P_ZB_CHANNEL_M_3G_05_02" + tail;

}
