package cd.precheck.sql;

/**
 * 用于确认 7.4.1.4 无线上网卡收入 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_4_1_4_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	/**
	 * 下面的校验针对7.4.1.4 无线上网卡收入 的所有存储过程.
	 * 
	 * MID.MID_M_3G_USER
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER
	public static final String M_3g_7_4_1_4_01_PRE_PROCNAME = "MID.P_MID_M_3G_USER"; 
	public static final String M_3g_7_4_1_4_01_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String M_3g_7_4_1_4_02_PRE_PROCNAME = "MID.P_MID_M_INCO_CHARGE_MONTH"; 
	public static final String M_3g_7_4_1_4_02_PRE =  headMID + "MID.P_MID_M_INCO_CHARGE_MONTH" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_7_4_1_4_03_PRE_PROCNAME = "MID.P_MID_M_USER_CHARGE_SECOND_HOR"; 
	public static final String M_3g_7_4_1_4_03_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	
}
