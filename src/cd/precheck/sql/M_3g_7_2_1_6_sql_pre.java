package cd.precheck.sql;

/**
 * 用于确认 7.2.1.6 定制专用无线上网卡发展月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_1_6_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * 下面的校验针对7.2.1.6 的所有存储过程. 
	 * 
	 * MID.MID_M_3G_USER_PROPERTY
	 */
	public static final String M_3g_7_2_1_6_PRE_PROCNAME  = "MID.P_MID_M_3G_USER_PROPERTY";
	public static final String M_3g_7_2_1_6_PRE  = headMID + "MID.P_MID_M_3G_USER_PROPERTY" + tail;

}
