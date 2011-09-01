package cd.precheck.sql;

/**
 * 用于确认 8.3 综合指标二 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_2g_8_3_sql {

	/**
	 * 下面的校验针对8.3 综合指标二 的所有存储过程.
	 * MID.MID_M_USE_BILLS
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 * MID.MID_M_BUSI_MOBILEUSER
	 * 
	 */
	//MID.MID_M_USE_BILLS
	public static final String PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USE_BILLS' AND LOGDATE=?";
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USER_CHARGE_SECOND_HOR' AND LOGDATE=?";
	//MID.MID_M_BUSI_MOBILEUSER
	public static final String PRECHECK_REPORT_P_ZB_ZH_M_ZH_06_03 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_BUSI_MOBILEUSER' AND LOGDATE=?";

}
