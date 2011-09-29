package cd.precheck.sql;

public class P_MID_M_3G_WIRELESS_INDEX_sql_pre {
	
	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String headDWD = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * 需要先运行下面的存储过程,先对它进行运行前检测. MID.P_MID_M_3G_WIRELESS_INDEX
	 */
	public static final String P_MID_M_3G_WIRELESS_INDEX_03_PRE_SERVICENAME = "3G 前置过程,需要手动跑";
	public static final String P_MID_M_3G_WIRELESS_INDEX_01_PRE_PROCNAME = "MID.P_MID_M_3G_USER_PROPERTY";
	public static final String P_MID_M_3G_WIRELESS_INDEX_01_PRE = headMID + "MID.P_MID_M_3G_USER_PROPERTY" + tail;
	public static final String P_MID_M_3G_WIRELESS_INDEX_02_PRE_PROCNAME = "MID.P_MID_M_USER_CHARGE_SECOND_HOR";
	public static final String P_MID_M_3G_WIRELESS_INDEX_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	public static final String P_MID_M_3G_WIRELESS_INDEX_03_PRE_PROCNAME = "P_MID_M_USER_SMS_GPRS_3G";
	public static final String P_MID_M_3G_WIRELESS_INDEX_03_PRE = headMID + "P_MID_M_USER_SMS_GPRS_3G" + tail;
	//这个是日报数据,日志日期需要设置为日
	public static final String P_MID_M_3G_WIRELESS_INDEX_04_PRE_PROCNAME = "DWD.P_DWD_D_USER_GPRS_STREAM";
	public static final String P_MID_M_3G_WIRELESS_INDEX_04_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;

}
