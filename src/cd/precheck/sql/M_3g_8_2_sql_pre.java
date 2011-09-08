package cd.precheck.sql;

/**
 * 用于确认 8.2 综合指标快报一 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_8_2_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String headDWD = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * 下面的校验针对8.2 综合指标快报一 的所有存储过程.
	 * 
	 * MID.MID_M_F_DEV_USER_3G
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * MID.MID_M_3G_USER
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 * MID.MID_M_3G_NETWORK_CARD
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 * 
	 */
	//MID.MID_M_F_DEV_USER_3G
	public static final String M_3g_8_2_01_PRE_PROCNAME = "MID.P_MID_M_F_DEV_USER_3G";
	public static final String M_3g_8_2_01_PRE = headMID + "MID.P_MID_M_F_DEV_USER_3G" + tail;
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String M_3g_8_2_02_PRE_PROCNAME = "MID.P_MID_M_INCO_CHARGE_MONTH";
	public static final String M_3g_8_2_02_PRE = headMID + "MID.P_MID_M_INCO_CHARGE_MONTH" + tail;
	//MID.MID_M_3G_USER
	public static final String M_3g_8_2_03_PRE_PROCNAME = "MID.P_MID_M_3G_USER";
	public static final String M_3g_8_2_03_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_8_2_04_PRE_PROCNAME = "MID.P_MID_M_USER_CHARGE_SECOND_HOR";
	public static final String M_3g_8_2_04_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	//MID.MID_M_3G_NETWORK_CARD
	public static final String M_3g_8_2_05_PRE_PROCNAME = "MID.P_MID_M_3G_NETWORK_CARD";
	public static final String M_3g_8_2_05_PRE = headMID + "MID.P_MID_M_3G_NETWORK_CARD" + tail;
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//这个验证日期是日 注意
	public static final String M_3g_8_2_06_PRE_PROCNAME = "DWD.P_DWD_D_USER_GPRS_STREAM";
	public static final String M_3g_8_2_06_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;
	
}
