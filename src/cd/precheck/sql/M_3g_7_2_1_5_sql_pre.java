package cd.precheck.sql;

/**
 * ����ȷ�� 7.2.1.5 ����������ҵ�� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_1_5_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	/**
	 * �����У�����7.2.1.5 �����д洢����.
	 * 
	 * ����:
	 * 		������������ _PROCNAME ����
	 * 		SQL������_PRE ����
	 */
	public static final String M_3g_7_2_1_5_01_PRE_PROCNAME = "MID.P_MID_M_3G_WIRELESS_INDEX";
	public static final String M_3g_7_2_1_5_01_PRE = headMID + "MID.P_MID_M_3G_WIRELESS_INDEX" + tail;
	public static final String M_3g_7_2_1_5_02_PRE_PROCNAME = "MID.P_MID_M_REPORT_CALL_3G";
	public static final String M_3g_7_2_1_5_02_PRE = headMID + "P_MID_M_REPORT_CALL_3G" + tail;
	public static final String M_3g_7_2_1_5_03_PRE_PROCNAME = "MID.P_MID_M_3G_NETWORK_CARD";
	public static final String M_3g_7_2_1_5_03_PRE = headMID + "MID.P_MID_M_3G_NETWORK_CARD" + tail;
	public static final String M_3g_7_2_1_5_04_PRE_PROCNAME = "MID.P_MID_M_3G_USER";
	public static final String M_3g_7_2_1_5_04_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;
	public static final String M_3g_7_2_1_5_05_PRE_PROCNAME = "MID.P_MID_M_3G_WIRELESS_INDEX";
	public static final String M_3g_7_2_1_5_05_PRE = headMID + "MID.P_MID_M_3G_WIRELESS_INDEX" + tail;

	
}
