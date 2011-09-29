package cd.precheck.sql;

/**
 * 校验该过程是因为该过程运行后才能运行 7.5.1.6 过程.但是本身该过程不需要我负责.
 * 用于确认 7.5.1.5 渠道终端类月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_5_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * 校验该过程是因为该过程运行后才能运行 7.5.1.6 过程.但是本身该过程不需要我负责.
	 * 下面的校验针对7.5.1.5 渠道终端类月报 的所有存储过程.
	 * 
	 * MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	 * MID.MID_M_3G_USER
	 */
	public static final String M_3g_7_5_1_5_01_PRE_SERVICENAME = "3G 7.5.1.5 渠道终端类月报"; 
	//MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	public static final String M_3g_7_5_1_5_01_PRE_PROCNAME = "MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD";
	public static final String M_3g_7_5_1_5_01_PRE = headMID + "MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD" + tail;
	//MID.MID_M_3G_USER
	public static final String M_3g_7_5_1_5_02_PRE_PROCNAME = "MID.P_MID_M_3G_USER";
	public static final String M_3g_7_5_1_5_02_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;

}
