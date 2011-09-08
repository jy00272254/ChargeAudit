package cd.check.sql;

public class M_2g_7_6_2_sql {
	
	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	//7.6.2 渠道类综合统计
	public static final String M_2g_7_6_2_02_PROCNAME = "P_ZB_DEV_M_CHANNEL_02";
	public static final String M_2g_7_6_2_02 = headREPORT + "P_ZB_DEV_M_CHANNEL_02" + tail;
	public static final String M_2g_7_6_2_03_PROCNAME = "P_ZB_DEV_M_CHANNEL_03";
	public static final String M_2g_7_6_2_03 = headREPORT + "P_ZB_DEV_M_CHANNEL_03" + tail;
	public static final String M_2g_7_6_2_04_PROCNAME = "P_ZB_DEV_M_CHANNEL_04";
	public static final String M_2g_7_6_2_04 = headREPORT + "P_ZB_DEV_M_CHANNEL_04" + tail;
	public static final String M_2g_7_6_2_05_PROCNAME = "P_ZB_DEV_M_CHANNEL_05";
	public static final String M_2g_7_6_2_05 = headREPORT + "P_ZB_DEV_M_CHANNEL_05" + tail;
	
}
