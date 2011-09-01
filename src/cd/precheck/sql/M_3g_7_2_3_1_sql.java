package cd.precheck.sql;

/**
 * 用于确认 7.2.3.1 渠道发展类统计 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_3_1_sql {

	/**
	 * 下面的校验针对7.2.3.1 的所有存储过程.
	 * 
	 * MID.MID_M_3G_USER
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * MID.MID_M_F_DEV_USER_3G
	 * DIM.DIM_INFO_OFFICE_TRUE
	 * DIM.DIM_WORK_OFFICETRUE_OFFICE
	 */
	
	//MID.MID_M_3G_USER
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_09_XX_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER' AND LOGDATE=?";
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_09_XX_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_INCO_CHARGE_MONTH' AND LOGDATE=?";
	//MID.MID_M_F_DEV_USER_3G
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_09_XX_03 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_F_DEV_USER_3G' AND LOGDATE=?";

}
