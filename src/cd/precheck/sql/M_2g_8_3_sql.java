package cd.precheck.sql;

/**
 * ����ȷ�� 8.3 �ۺ�ָ��� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_2g_8_3_sql {

	/**
	 * �����У�����8.3 �ۺ�ָ��� �����д洢����.
	 * MID.MID_M_USE_BILLS
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 * MID.MID_M_BUSI_MOBILEUSER
	 * 
	 */
	//MID.MID_M_USE_BILLS
	public static final String PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USE_BILLS' AND LOGDATE=?";
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USER_CHARGE_SECOND_HOR' AND LOGDATE=?";
	//MID.MID_M_BUSI_MOBILEUSER
	public static final String PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_03 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_BUSI_MOBILEUSER' AND LOGDATE=?";

}
