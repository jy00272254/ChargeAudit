package cd.precheck.sql;

/**
 * У��ù�������Ϊ�ù������к�������� 7.5.1.6 ����.���Ǳ���ù��̲���Ҫ�Ҹ���.
 * ����ȷ�� 7.5.1.5 �����ն����±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_5_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * У��ù�������Ϊ�ù������к�������� 7.5.1.6 ����.���Ǳ���ù��̲���Ҫ�Ҹ���.
	 * �����У�����7.5.1.5 �����ն����±� �����д洢����.
	 * 
	 * MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	 * MID.MID_M_3G_USER
	 */
	public static final String M_3g_7_5_1_5_01_PRE_SERVICENAME = "3G 7.5.1.5 �����ն����±�"; 
	//MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	public static final String M_3g_7_5_1_5_01_PRE_PROCNAME = "MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD";
	public static final String M_3g_7_5_1_5_01_PRE = headMID + "MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD" + tail;
	//MID.MID_M_3G_USER
	public static final String M_3g_7_5_1_5_02_PRE_PROCNAME = "MID.P_MID_M_3G_USER";
	public static final String M_3g_7_5_1_5_02_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;

}
