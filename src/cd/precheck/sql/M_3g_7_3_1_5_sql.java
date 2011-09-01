package cd.precheck.sql;

/**
 * 用于确认 7.3.1.5 定制专用无线上网卡业务量月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_3_1_5_sql {

	/**
	 * 下面的校验针对7.3.1.5 定制专用无线上网卡业务量月报 的所有存储过程.
	 * 
	 * MID.MID_M_3G_USER
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER
	public static final String PRECHECK_REPORT_P_ZB_USE_M_3G_WIRLESS_05_02_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER' AND LOGDATE=?";
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//这个验证日期是日 注意
	public static final String PRECHECK_REPORT_P_ZB_USE_M_3G_WIRLESS_05_02_02 =  "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(procname) = 'DWD.P_DWD_D_USER_GPRS_STREAM' AND LOGDATE=?";
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String PRECHECK_REPORT_P_ZB_USE_M_3G_WIRLESS_05_02_03 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_USER_CHARGE_SECOND_HOR' AND LOGDATE=?";
	
}
