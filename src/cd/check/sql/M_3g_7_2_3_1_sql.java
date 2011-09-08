package cd.check.sql;

public class M_3g_7_2_3_1_sql {
	
	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	//7.2.3.1 渠道发展类统计
	public static final String M_3g_7_2_3_1_02_PROCNAME = "REPORT.P_ZB_DEV_M_3G_09_02";
	public static final String M_3g_7_2_3_1_03_PROCNAME = "REPORT.P_ZB_DEV_M_3G_09_03";
	public static final String M_3g_7_2_3_1_04_PROCNAME = "REPORT.P_ZB_DEV_M_3G_09_04";

	public static final String M_3g_7_2_3_1_02 = headREPORT + "REPORT.P_ZB_DEV_M_3G_09_02" + tail;
	public static final String M_3g_7_2_3_1_03 = headREPORT + "REPORT.P_ZB_DEV_M_3G_09_03" + tail;
	public static final String M_3g_7_2_3_1_04 = headREPORT + "REPORT.P_ZB_DEV_M_3G_09_04" + tail;

}
