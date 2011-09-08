package cd.precheck.sql;

/**
 * ����ȷ�� 7.3.1.4 ����������ҵ�����±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_3_1_4_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String headDWD = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	/**
	 * �����У����� 7.3.1.4 ����������ҵ�����±� �����д洢����.
	 * 
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 * MID.MID_M_3G_USER
	 * MID.MID_M_USER_SMS_GPRS_3G
	 */
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//�����֤�������� ע��
	public static final String M_3g_7_3_1_4_01_PRE_PROCNAME = "DWD.P_DWD_D_USER_GPRS_STREAM";
	public static final String M_3g_7_3_1_4_01_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;
	//MID.MID_M_3G_USER
	public static final String M_3g_7_3_1_4_02_PRE_PROCNAME = "MID.P_MID_M_3G_USER";
	public static final String M_3g_7_3_1_4_02_PRE =  headMID + "MID.P_MID_M_3G_USER" + tail;
	//MID.MID_M_USER_SMS_GPRS_3G
	public static final String M_3g_7_3_1_4_03_PRE_PROCNAME = "P_MID_M_USER_SMS_GPRS_3G";
	public static final String M_3g_7_3_1_4_03_PRE =  headMID + "P_MID_M_USER_SMS_GPRS_3G" + tail;
	
}
