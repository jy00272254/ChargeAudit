package cd.precheck.sql;

/**
 * 用于确认 8.2 综合指标一 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_2g_8_2_sql {

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
	//MID.MID_M_F_DEV_USER_3G
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_02_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_F_DEV_USER_3G' AND LOGDATE=?";
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_02_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USER_CHARGE_SECOND_HOR' AND LOGDATE=?";
	//MID.MID_M_USER_CHARGE
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_02_03 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.MID_M_USER_CHARGE' AND LOGDATE=?";
	//MID.MID_M_USE_BILLS
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_02_04 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USE_BILLS' AND LOGDATE=?";
	//DWD.DWD_M_CALL_INFO_MONTH
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_02_05 = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(procname) = 'DWD.P_DWD_M_CALL_INFO_MONTH' AND LOGDATE=?";
	//DM.DM_M_REPORT_USER_INFO
	public static final String PRECHECK_REPORT_P_ZB_M_ZH_02_06 = "SELECT * FROM DM.DM_T_LOG WHERE UPPER(procname) = 'P_DM_M_REPORT_USER_INFO' AND LOGDATE=?";

}
