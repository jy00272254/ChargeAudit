package cd.check.sql;

public class M_3g_7_5_1_6_sql {

	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";

	//7.5.1.6 渠道佣金类月报
	public static final String M_3g_7_5_1_6_PROCNAME = "REPORT.P_ZB_CHANNEL_M_3G_06_02";
	public static final String M_3g_7_5_1_6 = headREPORT + "REPORT.P_ZB_CHANNEL_M_3G_06_02" + tail;

}
