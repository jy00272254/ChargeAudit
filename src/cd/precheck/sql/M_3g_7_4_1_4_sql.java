package cd.precheck.sql;

/**
 * ����ȷ�� 7.4.1.4 �������������� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_4_1_4_sql {

	/**
	 * �����У�����7.4.1.4 �������������� �����д洢����.
	 * 
	 * MID.MID_M_3G_USER
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER
	public static final String PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER' AND LOGDATE=?";
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_02 =  "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_INCO_CHARGE_MONTH' AND LOGDATE=?";
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_03 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USER_CHARGE_SECOND_HOR' AND LOGDATE=?";
	
}
