package cd.precheck.sql;

/**
 * 用于确认 7.4.1.4 无线上网卡收入 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_4_1_4_sql {

	/**
	 * 下面的校验针对7.4.1.4 无线上网卡收入 的所有存储过程.
	 * 
	 * MID.MID_M_3G_USER
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER
	public static final String PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER' AND LOGDATE=?";
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_02 =  "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_INCO_CHARGE_MONTH' AND LOGDATE=?";
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String PRECHECK_REPORT_P_ZB_INCO_M_3G_04_XX_03 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USER_CHARGE_SECOND_HOR' AND LOGDATE=?";
	
}
