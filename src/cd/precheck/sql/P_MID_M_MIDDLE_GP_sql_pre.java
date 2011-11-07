package cd.precheck.sql;

public class P_MID_M_MIDDLE_GP_sql_pre {
	
	private static final String headDWD = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	/**
	 * 需要先运行下面的存储过程,先对它进行运行前检测. DWD.P_DWD_D_USER_GPRS_STREAM
	 */
	public static final String P_MID_M_3G_WIRELESS_INDEX_03_PRE_SERVICENAME = "3G 前置过程,需要手动跑";
	//这个是日报数据,日志日期需要设置为日
	public static final String P_MID_M_3G_WIRELESS_INDEX_01_PRE_PROCNAME = "DWD.P_DWD_D_USER_GPRS_STREAM";
	public static final String P_MID_M_3G_WIRELESS_INDEX_01_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;

}
