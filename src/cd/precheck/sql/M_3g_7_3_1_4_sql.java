package cd.precheck.sql;

/**
 * ����ȷ�� 7.3.1.4 ����������ҵ�����±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_3_1_4_sql {

	/**
	 * �����У����� 7.3.1.4 ����������ҵ�����±� �����д洢����.
	 * 
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 * MID.MID_M_3G_USER
	 * MID.MID_M_USER_SMS_GPRS_3G
	 */
	
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//�����֤�������� ע��
	public static final String PRECHECK_REPORT_P_ZB_USE_M_3G_04_XX_01 = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(procname) = 'DWD.P_DWD_D_USER_GPRS_STREAM' AND LOGDATE=?";
	//MID.MID_M_3G_USER
	public static final String PRECHECK_REPORT_P_ZB_USE_M_3G_04_XX_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER' AND LOGDATE=?";
	//MID.MID_M_USER_SMS_GPRS_3G
	public static final String PRECHECK_REPORT_P_ZB_USE_M_3G_04_XX_03 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'P_MID_M_USER_SMS_GPRS_3G' AND LOGDATE=?";
	
}
