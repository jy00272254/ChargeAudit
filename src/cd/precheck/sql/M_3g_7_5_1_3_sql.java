package cd.precheck.sql;

/**
 * 用于确认 7.5.1.3 渠道类综合月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_3_sql {

	/**
	 * 下面的校验针对7.5.1.3 渠道类综合月报 的所有存储过程.
	 * 
	 * MID.MID_M_3G_USER_PROPERTY
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER_PROPERTY
	public static final String PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_ZH_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER_PROPERTY' AND LOGDATE=?";
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_ZH_02 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USER_CHARGE_SECOND_HOR' AND LOGDATE=?";
	
}
