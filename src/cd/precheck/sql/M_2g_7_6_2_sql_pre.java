package cd.precheck.sql;

/**
 * 用于确认 7.6.2 渠道类综合统计 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_2g_7_6_2_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * 下面的校验针对7.6.2 渠道类综合统计 的所有存储过程.
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
