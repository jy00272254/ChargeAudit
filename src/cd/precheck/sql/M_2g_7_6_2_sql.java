package cd.precheck.sql;

/**
 * 用于确认 7.6.2 渠道类综合统计 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_2g_7_6_2_sql {

	/**
	 * 下面的校验针对7.6.2 渠道类综合统计 的所有存储过程.
	 * 
	 * MID.MID_M_F_DEV_USER_3G
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * 
	 */
	//MID.MID_M_F_DEV_USER_3G
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_CHANNEL_XX_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_F_DEV_USER_3G' AND LOGDATE=?";
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_CHANNEL_XX_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_INCO_CHARGE_MONTH' AND LOGDATE=?";
}
