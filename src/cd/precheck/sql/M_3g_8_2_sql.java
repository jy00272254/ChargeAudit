package cd.precheck.sql;

/**
 * ����ȷ�� 8.2 �ۺ�ָ��챨һ �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_8_2_sql {

	/**
	 * �����У�����8.2 �ۺ�ָ��챨һ �����д洢����.
	 * 
	 * MID.MID_M_F_DEV_USER_3G
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * MID.MID_M_3G_USER
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 * MID.MID_M_3G_NETWORK_CARD
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 * 
	 */
	//MID.MID_M_F_DEV_USER_3G
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_F_DEV_USER_3G' AND LOGDATE=?";
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_INCO_CHARGE_MONTH' AND LOGDATE=?";
	//MID.MID_M_3G_USER
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_03 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER' AND LOGDATE=?";
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_04 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USER_CHARGE_SECOND_HOR' AND LOGDATE=?";
	//MID.MID_M_3G_NETWORK_CARD
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_05 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_NETWORK_CARD' AND LOGDATE=?";
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//�����֤�������� ע��
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_3G_XX_06 = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(procname) = 'DWD.P_DWD_D_USER_GPRS_STREAM' AND LOGDATE=?";
	
}
