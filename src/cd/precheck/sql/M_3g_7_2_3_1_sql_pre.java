package cd.precheck.sql;

/**
 * ����ȷ�� 7.2.3.1 ������չ��ͳ�� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_3_1_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * �����У�����7.2.3.1 �����д洢����.
	 * 
	 * MID.MID_M_3G_USER
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * MID.MID_M_F_DEV_USER_3G
	 * DIM.DIM_INFO_OFFICE_TRUE
	 * DIM.DIM_WORK_OFFICETRUE_OFFICE
	 */
	public static final String M_3g_7_2_3_1_PRE_SERVICENAME = "3G 7.2.3.1 ������չ��ͳ��";
	//MID.MID_M_3G_USER
	public static final String M_3g_7_2_3_1_01_PRE_PROCNAME =  "MID.P_MID_M_3G_USER";
	public static final String M_3g_7_2_3_1_01_PRE =  headMID + "MID.P_MID_M_3G_USER" + tail;
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String M_3g_7_2_3_1_02_PRE_PROCNAME =  "MID.P_MID_M_INCO_CHARGE_MONTH";
	public static final String M_3g_7_2_3_1_02_PRE =  headMID + "MID.P_MID_M_INCO_CHARGE_MONTH" + tail;
	//MID.MID_M_F_DEV_USER_3G
	public static final String M_3g_7_2_3_1_03_PRE_PROCNAME =  "MID.P_MID_M_F_DEV_USER_3G";
	public static final String M_3g_7_2_3_1_03_PRE =  headMID + "MID.P_MID_M_F_DEV_USER_3G" + tail;

}
