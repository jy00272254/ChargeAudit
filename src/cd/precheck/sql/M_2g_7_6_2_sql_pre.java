package cd.precheck.sql;

/**
 * ����ȷ�� 7.6.2 �������ۺ�ͳ�� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_2g_7_6_2_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * �����У�����7.6.2 �������ۺ�ͳ�� �����д洢����.
	 * 
	 * MID.MID_M_F_DEV_USER_3G
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * 
	 */
	//MID.MID_M_F_DEV_USER_3G
	public static final String M_2g_7_6_2_01_PRE_PROCNAME  = "MID.P_MID_M_F_DEV_USER_3G";
	public static final String M_2g_7_6_2_01_PRE  = headMID + "MID.P_MID_M_F_DEV_USER_3G" + tail;
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String M_2g_7_6_2_02_PRE_PROCNAME  = "MID.P_MID_M_INCO_CHARGE_MONTH";
	public static final String M_2g_7_6_2_02_PRE = headMID + "MID.P_MID_M_INCO_CHARGE_MONTH" + tail;
}
