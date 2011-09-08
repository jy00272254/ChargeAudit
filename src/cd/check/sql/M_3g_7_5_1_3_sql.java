package cd.check.sql;

public class M_3g_7_5_1_3_sql {
	
	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	//7.5.1.3 渠道类综合月报
	public static final String M_3g_7_5_1_3_PROCNAME = "REPORT.P_ZB_M_3G_CHANNEL_ZH";
	public static final String M_3g_7_5_1_3 = headREPORT + "REPORT.P_ZB_M_3G_CHANNEL_ZH" + tail;

}
