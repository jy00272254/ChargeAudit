package cd.precheck.sql;

/**
 * ����ȷ�� 7.5.1.3 �������ۺ��±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_3_sql {

	/**
	 * �����У�����7.5.1.3 �������ۺ��±� �����д洢����.
	 * 
	 * MID.MID_M_3G_USER_PROPERTY
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER_PROPERTY
	public static final String PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_ZH_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER_PROPERTY' AND LOGDATE=?";
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_ZH_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USER_CHARGE_SECOND_HOR' AND LOGDATE=?";
	
}
