package cd.precheck.sql;

/**
 * 用于确认 8.2 综合指标一 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_2g_8_2_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String headDWD = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String headDM = "SELECT * FROM DM.DM_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * 下面的校验针对8.2 综合指标一 的所有存储过程.
	 * 
	 * DWD.DWD_M_CALL_INFO_MONTH
	 * MID.MID_M_F_DEV_USER_3G
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 * MID.MID_M_USER_CHARGE
	 * DM.DM_M_REPORT_USER_INFO
	 * MID.MID_M_USE_BILLS
	 * 
	 */
	public static final String M_2g_8_2_01_PRE_SERVICENAME = "2G 8.2 综合指标一";
	//MID.MID_M_F_DEV_USER_3G
	public static final String M_2g_8_2_01_PRE_PROCNAME  = "MID.P_MID_M_F_DEV_USER_3G";
	public static final String M_2g_8_2_01_PRE = headMID + "MID.P_MID_M_F_DEV_USER_3G" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_2g_8_2_02_PRE_PROCNAME  = "MID.P_MID_M_USER_CHARGE_SECOND_HOR";
	public static final String M_2g_8_2_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	//MID.MID_M_USER_CHARGE
	public static final String M_2g_8_2_03_PRE_PROCNAME  = "MID.MID_M_USER_CHARGE";
	public static final String M_2g_8_2_03_PRE = headMID + "MID.MID_M_USER_CHARGE" + tail;
	//MID.MID_M_USE_BILLS
	public static final String M_2g_8_2_04_PRE_PROCNAME  = "MID.P_MID_M_USE_BILLS";
	public static final String M_2g_8_2_04_PRE = headMID + "MID.P_MID_M_USE_BILLS" + tail;
	//DWD.DWD_M_CALL_INFO_MONTH
	public static final String M_2g_8_2_05_PRE_PROCNAME  = "DWD.P_DWD_M_CALL_INFO_MONTH";
	public static final String M_2g_8_2_05_PRE = headDWD + "DWD.P_DWD_M_CALL_INFO_MONTH" + tail;
	//DM.DM_M_REPORT_USER_INFO
	public static final String M_2g_8_2_06_PRE_PROCNAME  = "P_DM_M_REPORT_USER_INFO";
	public static final String M_2g_8_2_06_PRE = headDM + "P_DM_M_REPORT_USER_INFO" + tail;
	
}
