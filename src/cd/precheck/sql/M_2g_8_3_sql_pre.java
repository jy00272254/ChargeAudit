package cd.precheck.sql;

/**
 * 用于确认 8.3 综合指标二 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_2g_8_3_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * 下面的校验针对8.3 综合指标二 的所有存储过程.
	 * MID.MID_M_USE_BILLS
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 * MID.MID_M_BUSI_MOBILEUSER
	 * 
	 */
	//MID.MID_M_USE_BILLS
	public static final String M_2g_8_3_01_PRE_PROCNAME  = "MID.P_MID_M_USE_BILLS";
	public static final String M_2g_8_3_01_PRE = headMID + "MID.P_MID_M_USE_BILLS" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_2g_8_3_02_PRE_PROCNAME  = "MID.P_MID_M_USER_CHARGE_SECOND_HOR";
	public static final String M_2g_8_3_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	//MID.MID_M_BUSI_MOBILEUSER
	public static final String M_2g_8_3_03_PRE_PROCNAME  = "MID.P_MID_M_BUSI_MOBILEUSER";
	public static final String M_2g_8_3_03_PRE = headMID + "MID.P_MID_M_BUSI_MOBILEUSER" + tail;

}
