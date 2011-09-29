package cd.precheck.sql;

/**
 * 用于确认 7.5.1.6 渠道佣金类月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_6_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * 下面的校验针对7.5.1.6 渠道佣金类月报 的所有存储过程.
	 * 
	 * MID.MID_M_BUSI_MOBILEUSER
	 * MID.MID_M_INTELLIGENTUSER_PPS
	 * MID.MID_M_COMMISION_LIST_EXT
	 * MID.MID_M_USER_OWE_BILL
	 * MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 * 
	 */
	public static final String M_3g_7_5_1_6_01_PRE_SERVICENAME = "3G 7.5.1.6 渠道佣金类月报";
	//MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	public static final String M_3g_7_5_1_6_01_PRE_PROCNAME = "MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD";
	public static final String M_3g_7_5_1_6_01_PRE = headMID + "MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_7_5_1_6_02_PRE_PROCNAME = "MID.P_MID_M_USER_CHARGE_SECOND_HOR";
	public static final String M_3g_7_5_1_6_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	//MID.MID_M_BUSI_MOBILEUSER
	public static final String M_3g_7_5_1_6_03_PRE_PROCNAME = "MID.P_MID_M_BUSI_MOBILEUSER";
	public static final String M_3g_7_5_1_6_03_PRE = headMID + "MID.P_MID_M_BUSI_MOBILEUSER" + tail;
	//MID.MID_M_INTELLIGENTUSER_PPS
	public static final String M_3g_7_5_1_6_04_PRE_PROCNAME = "MID.P_MID_M_INTELLIGENTUSER_PPS";
	public static final String M_3g_7_5_1_6_04_PRE = headMID + "MID.P_MID_M_INTELLIGENTUSER_PPS" + tail;
	//MID.MID_M_COMMISION_LIST_EXT
	public static final String M_3g_7_5_1_6_05_PRE_PROCNAME = "MID.P_MID_M_COMMISION_LIST_EXT";
	public static final String M_3g_7_5_1_6_05_PRE = headMID + "MID.P_MID_M_COMMISION_LIST_EXT" + tail;
	//MID.MID_M_USER_OWE_BILL
	public static final String M_3g_7_5_1_6_06_PRE_PROCNAME = "MID.P_MID_M_USER_OWE_BILL";
	public static final String M_3g_7_5_1_6_06_PRE = headMID + "MID.P_MID_M_USER_OWE_BILL" + tail;
	
}
