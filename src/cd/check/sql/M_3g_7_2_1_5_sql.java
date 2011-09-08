package cd.check.sql;

public class M_3g_7_2_1_5_sql {
	
	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	//7.2.1.5 无线上网卡业务
	public static final String M_3g_7_2_1_5_02_PROCNAME = "REPORT.P_ZB_DEV_M_3G_05_02";
	public static final String M_3g_7_2_1_5_02 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_02" + tail;
	public static final String M_3g_7_2_1_5_03_PROCNAME = "REPORT.P_ZB_DEV_M_3G_05_03";
	public static final String M_3g_7_2_1_5_03 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_03" + tail;
	public static final String M_3g_7_2_1_5_05_PROCNAME = "REPORT.P_ZB_DEV_M_3G_05_05";
	public static final String M_3g_7_2_1_5_05 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_05" + tail;
	public static final String M_3g_7_2_1_5_06_PROCNAME = "REPORT.P_ZB_DEV_M_3G_05_06";
	public static final String M_3g_7_2_1_5_06 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_06" + tail;
	public static final String M_3g_7_2_1_5_09_PROCNAME = "REPORT.P_ZB_DEV_M_3G_05_09";
	public static final String M_3g_7_2_1_5_09 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_09" + tail;
	public static final String M_3g_7_2_1_5_11_PROCNAME = "REPORT.P_ZB_DEV_M_3G_05_11";
	public static final String M_3g_7_2_1_5_11 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_11" + tail;
	public static final String M_3g_7_2_1_5_13_PROCNAME = "REPORT.P_ZB_DEV_M_3G_05_13";
	public static final String M_3g_7_2_1_5_13 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_13" + tail;
	public static final String M_3g_7_2_1_5_15_PROCNAME = "REPORT.P_ZB_DEV_M_3G_05_15";
	public static final String M_3g_7_2_1_5_15 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_15" + tail;
	
}
