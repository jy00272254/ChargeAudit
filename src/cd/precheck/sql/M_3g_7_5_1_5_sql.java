package cd.precheck.sql;

/**
 * У��ù�������Ϊ�ù������к�������� 7.5.1.6 ����.���Ǳ���ù��̲���Ҫ�Ҹ���.
 * ����ȷ�� 7.5.1.5 �����ն����±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_5_sql {

	/**
	 * У��ù�������Ϊ�ù������к�������� 7.5.1.6 ����.���Ǳ���ù��̲���Ҫ�Ҹ���.
	 * �����У�����7.5.1.5 �����ն����±� �����д洢����.
	 * 
	 * MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	 * MID.MID_M_3G_USER
	 */
	//MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	public static final String PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_05_02_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD' AND LOGDATE=?";
	//MID.MID_M_3G_USER
	public static final String PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_05_02_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER' AND LOGDATE=?";
	
}
