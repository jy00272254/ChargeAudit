package cd.precheck.sql;

/**
 * 用于确认 7.5.1.3 渠道类综合月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_3_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	/**
	 * 下面的校验针对7.5.1.3 渠道类综合月报 的所有存储过程.
	 * 
	 * MID.MID_M_3G_USER_PROPERTY
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER_PROPERTY
	public static final String M_3g_7_5_1_3_01_PRE_PROCNAME = "MID.P_MID_M_3G_USER_PROPERTY";
	public static final String M_3g_7_5_1_3_01_PRE = headMID + "MID.P_MID_M_3G_USER_PROPERTY" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_7_5_1_3_02_PRE_PROCNAME = "MID.P_MID_M_USER_CHARGE_SECOND_HOR";
	public static final String M_3g_7_5_1_3_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	
}
