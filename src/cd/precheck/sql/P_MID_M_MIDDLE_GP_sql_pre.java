package cd.precheck.sql;

public class P_MID_M_MIDDLE_GP_sql_pre {
	
	private static final String headDWD = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * ��Ҫ����������Ĵ洢����,�ȶ�����������ǰ���. DWD.P_DWD_D_USER_GPRS_STREAM
	 */
	public static final String P_MID_M_3G_WIRELESS_INDEX_03_PRE_SERVICENAME = "3G ǰ�ù���,��Ҫ�ֶ���";
	//������ձ�����,��־������Ҫ����Ϊ��
	public static final String P_MID_M_3G_WIRELESS_INDEX_01_PRE_PROCNAME = "DWD.P_DWD_D_USER_GPRS_STREAM";
	public static final String P_MID_M_3G_WIRELESS_INDEX_01_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;

}
