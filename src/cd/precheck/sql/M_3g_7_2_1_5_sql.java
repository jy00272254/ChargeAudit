package cd.precheck.sql;

/**
 * ����ȷ�� 7.2.1.5 ����������ҵ�� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_1_5_sql {

	/**
	 * �����У�����7.2.1.5 �����д洢����.
	 */
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_WIRELESS_INDEX' AND LOGDATE=?";
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'P_MID_M_REPORT_CALL_3G' AND LOGDATE=?";
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_03 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_NETWORK_CARD' AND LOGDATE=?";
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_04 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER' AND LOGDATE=?";
	
}
