package cd.precheck.sql;

/**
 * 用于确认 7.2.1.5 无线上网卡业务 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_1_5_sql {

	/**
	 * 下面的校验针对7.2.1.5 的所有存储过程.
	 */
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_WIRELESS_INDEX' AND LOGDATE=?";
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'P_MID_M_REPORT_CALL_3G' AND LOGDATE=?";
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_03 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_NETWORK_CARD' AND LOGDATE=?";
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_04 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER' AND LOGDATE=?";
	
}
