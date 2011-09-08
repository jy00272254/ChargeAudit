package cd.check.sql;

public class M_3g_7_5_1_4_sql {

	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";

	// 7.5.1.4 渠道数量类月报
	public static final String M_3g_7_5_1_4_02_PROCNAME = "P_ZB_M_3G_CHANNEL_02";
	public static final String M_3g_7_5_1_4_03_PROCNAME = "P_ZB_M_3G_CHANNEL_03";
	public static final String M_3g_7_5_1_4_04_PROCNAME = "P_ZB_M_3G_CHANNEL_04";
	public static final String M_3g_7_5_1_4_05_PROCNAME = "P_ZB_M_3G_CHANNEL_05";
	public static final String M_3g_7_5_1_4_02 = headREPORT	+ "P_ZB_M_3G_CHANNEL_02" + tail;
	public static final String M_3g_7_5_1_4_03 = headREPORT	+ "P_ZB_M_3G_CHANNEL_03" + tail;
	public static final String M_3g_7_5_1_4_04 = headREPORT	+ "P_ZB_M_3G_CHANNEL_04" + tail;
	public static final String M_3g_7_5_1_4_05 = headREPORT	+ "P_ZB_M_3G_CHANNEL_05" + tail;
}
