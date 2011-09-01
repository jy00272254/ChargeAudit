package cd.precheck.sql;

/**
 * 校验该过程是因为该过程运行后才能运行 7.5.1.6 过程.但是本身该过程不需要我负责.
 * 用于确认 7.5.1.5 渠道终端类月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_5_sql {

	/**
	 * 校验该过程是因为该过程运行后才能运行 7.5.1.6 过程.但是本身该过程不需要我负责.
	 * 下面的校验针对7.5.1.5 渠道终端类月报 的所有存储过程.
	 * 
	 * MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	 * MID.MID_M_3G_USER
	 */
	//MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	public static final String PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_05_02_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD' AND LOGDATE=?";
	//MID.MID_M_3G_USER
	public static final String PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_05_02_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER' AND LOGDATE=?";
	
}
