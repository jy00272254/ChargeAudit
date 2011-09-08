package cd.check.sql;

public class M_3g_7_4_1_4_sql {
	
	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	//7.4.1.4 无线上网卡收入
	public static final String M_3g_7_4_1_4_03_PROCNAME = "REPORT.P_ZB_INCO_M_3G_04_03";
	public static final String M_3g_7_4_1_4_08_PROCNAME = "REPORT.P_ZB_INCO_M_3G_04_08";
	public static final String M_3g_7_4_1_4_03 = headREPORT + "REPORT.P_ZB_INCO_M_3G_04_03" + tail;
	public static final String M_3g_7_4_1_4_08 = headREPORT + "REPORT.P_ZB_INCO_M_3G_04_08" + tail;

}
