package cd.precheck.sql;

/**
 * ����ȷ�� 7.3.1.5 ����ר������������ҵ�����±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_3_1_5_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String headDWD = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	/**
	 * �����У�����7.3.1.5 ����ר������������ҵ�����±� �����д洢����.
	 * 
	 * MID.MID_M_3G_USER
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER
	public static final String M_3g_7_3_1_5_01_PRE_PROCNAME =  "MID.P_MID_M_3G_USER";
	public static final String M_3g_7_3_1_5_01_PRE =  headMID + "MID.P_MID_M_3G_USER" + tail;
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//�����֤�������� ע��
	public static final String M_3g_7_3_1_5_02_PRE_PROCNAME =  "DWD.P_DWD_D_USER_GPRS_STREAM";
	public static final String M_3g_7_3_1_5_02_PRE =  headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_7_3_1_5_03_PRE_PROCNAME =  "MID.P_MID_M_USER_CHARGE_SECOND_HOR";
	public static final String M_3g_7_3_1_5_03_PRE =  headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	
}
