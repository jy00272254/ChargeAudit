package cd.precheck.sql;

/**
 * 用于确认 存储过程 运行状态 失败/运行中/未运行/运行成功
 * 
 * @author Administrator
 *
 */
public class PreCheck {
	
//	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String headDWD = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String headDM = "SELECT * FROM DM.DM_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";

	
	/**
	 * 下面的校验针对7.6.2 渠道类综合统计 的所有存储过程.
	 * 
	 * MID.MID_M_F_DEV_USER_3G
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * 
	 */
	//MID.MID_M_F_DEV_USER_3G
	public static final String M_2g_7_6_2_01_PRE  = headMID + "MID.P_MID_M_F_DEV_USER_3G" + tail;
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String M_2g_7_6_2_02_PRE = headMID + "MID.P_MID_M_INCO_CHARGE_MONTH" + tail;

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
	public static final String M_2g_8_2_01_PRE = headMID + "MID.P_MID_M_F_DEV_USER_3G" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_2g_8_2_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	//MID.MID_M_USER_CHARGE
	public static final String M_2g_8_2_03_PRE = headMID + "MID.MID_M_USER_CHARGE" + tail;
	//MID.MID_M_USE_BILLS
	public static final String M_2g_8_2_04_PRE = headMID + "MID.P_MID_M_USE_BILLS" + tail;
	//DWD.DWD_M_CALL_INFO_MONTH
	public static final String M_2g_8_2_05_PRE = headDWD + "DWD.P_DWD_M_CALL_INFO_MONTH" + tail;
	//DM.DM_M_REPORT_USER_INFO
	public static final String M_2g_8_2_06_PRE = headDM + "P_DM_M_REPORT_USER_INFO" + tail;

	
	/**
	 * 下面的校验针对8.3 综合指标二 的所有存储过程.
	 * MID.MID_M_USE_BILLS
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 * MID.MID_M_BUSI_MOBILEUSER
	 * 
	 */
	//MID.MID_M_USE_BILLS
	public static final String M_2g_8_3_01_PRE = headMID + "MID.P_MID_M_USE_BILLS" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_2g_8_3_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	//MID.MID_M_BUSI_MOBILEUSER
	public static final String M_2g_8_3_03_PRE = headMID + "MID.P_MID_M_BUSI_MOBILEUSER" + tail;

	
	/**
	 * 下面的校验针对7.2.1.5 的所有存储过程.
	 */
	public static final String M_3g_7_2_1_5_01_PRE = headMID + "MID.P_MID_M_3G_WIRELESS_INDEX" + tail;
	public static final String M_3g_7_2_1_5_02_PRE = headMID + "P_MID_M_REPORT_CALL_3G" + tail;
	public static final String M_3g_7_2_1_5_03_PRE = headMID + "MID.P_MID_M_3G_NETWORK_CARD" + tail;
	public static final String M_3g_7_2_1_5_04_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;
	
	/**
	 * 下面的校验针对7.2.1.6 的所有存储过程. 
	 * 
	 * MID.MID_M_3G_USER_PROPERTY
	 */
	public static final String M_3g_7_2_1_6_PRE  = headMID + "MID.P_MID_M_3G_USER_PROPERTY" + tail;

	
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
	public static final String M_3g_7_2_3_1_01_PRE =  headMID + "MID.P_MID_M_3G_USER" + tail;
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String M_3g_7_2_3_1_02_PRE =  headMID + "MID.P_MID_M_INCO_CHARGE_MONTH" + tail;
	//MID.MID_M_F_DEV_USER_3G
	public static final String M_3g_7_2_3_1_03_PRE =  headMID + "MID.P_MID_M_F_DEV_USER_3G" + tail;

	/**
	 * 下面的校验针对 7.3.1.4 无线上网卡业务量月报 的所有存储过程.
	 * 
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 * MID.MID_M_3G_USER
	 * MID.MID_M_USER_SMS_GPRS_3G
	 */
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//这个验证日期是日 注意
	public static final String M_3g_7_3_1_4_01_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;
	//MID.MID_M_3G_USER
	public static final String M_3g_7_3_1_4_02_PRE =  headMID + "MID.P_MID_M_3G_USER" + tail;
	//MID.MID_M_USER_SMS_GPRS_3G
	public static final String M_3g_7_3_1_4_03_PRE =  headMID + "P_MID_M_USER_SMS_GPRS_3G" + tail;
	
	
	/**
	 * 下面的校验针对7.3.1.5 定制专用无线上网卡业务量月报 的所有存储过程.
	 * 
	 * MID.MID_M_3G_USER
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER
	public static final String M_3g_7_3_1_5_01_PRE =  headMID + "MID.P_MID_M_3G_USER" + tail;
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//这个验证日期是日 注意
	public static final String M_3g_7_3_1_5_02_PRE =  headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_7_3_1_5_03_PRE =  headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	
	/**
	 * 下面的校验针对7.4.1.4 无线上网卡收入 的所有存储过程.
	 * 
	 * MID.MID_M_3G_USER
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER
	public static final String M_3g_7_4_1_4_01_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String M_3g_7_4_1_4_02_PRE =  headMID + "MID.P_MID_M_INCO_CHARGE_MONTH" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_7_4_1_4_03_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;

	
	/**
	 * 下面的校验针对7.5.1.3 渠道类综合月报 的所有存储过程.
	 * 
	 * MID.MID_M_3G_USER_PROPERTY
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER_PROPERTY
	public static final String M_3g_7_5_1_3_01_PRE = headMID + "MID.P_MID_M_3G_USER_PROPERTY" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_7_5_1_3_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	
	/**
	 * 下面的校验针对7.5.1.4 渠道数量类月报 的所有存储过程.
	 * 
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * MID.MID_M_F_DEV_USER_3G
	 * MID.MID_M_3G_USER
	 * MID.MID_M_COMMISION_LIST_EXT
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 * MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	 * 
	 */
	//MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	public static final String M_3g_7_5_1_4_01_PRE = headMID + "MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_7_5_1_4_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	//MID.MID_M_COMMISION_LIST_EXT
	public static final String M_3g_7_5_1_4_03_PRE = headMID + "MID.P_MID_M_COMMISION_LIST_EXT" + tail;
	//MID.MID_M_3G_USER
	public static final String M_3g_7_5_1_4_04_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;
	//MID.MID_M_F_DEV_USER_3G
	public static final String M_3g_7_5_1_4_05_PRE = headMID + "MID.P_MID_M_F_DEV_USER_3G" + tail;
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String M_3g_7_5_1_4_06_PRE = headMID + "MID.P_MID_M_INCO_CHARGE_MONTH" + tail;

	
	
	/**
	 * 校验该过程是因为该过程运行后才能运行 7.5.1.6 过程.但是本身该过程不需要我负责.
	 * 下面的校验针对7.5.1.5 渠道终端类月报 的所有存储过程.
	 * 
	 * MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	 * MID.MID_M_3G_USER
	 */
	//MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	public static final String M_3g_7_5_1_5_01_PRE = headMID + "MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD" + tail;
	//MID.MID_M_3G_USER
	public static final String M_3g_7_5_1_5_02_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;

	
	/**
	 * 下面的校验针对7.5.1.6 渠道佣金类月报 的所有存储过程.
	 * 
	 * MID.MID_M_BUSI_MOBILEUSER
	 * MID.MID_M_INTELLIGENTUSER_PPS
	 * MID.MID_M_COMMISION_LIST_EXT
	 * MID.MID_M_USER_OWE_BILL
	 * MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 * 
	 */
	//MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	public static final String M_3g_7_5_1_6_01_PRE = headMID + "MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_7_5_1_6_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	//MID.MID_M_BUSI_MOBILEUSER
	public static final String M_3g_7_5_1_6_03_PRE = headMID + "MID.P_MID_M_BUSI_MOBILEUSER" + tail;
	//MID.MID_M_INTELLIGENTUSER_PPS
	public static final String M_3g_7_5_1_6_04_PRE = headMID + "MID.P_MID_M_INTELLIGENTUSER_PPS" + tail;
	//MID.MID_M_COMMISION_LIST_EXT
	public static final String M_3g_7_5_1_6_05_PRE = headMID + "MID.P_MID_M_COMMISION_LIST_EXT" + tail;
	//MID.MID_M_USER_OWE_BILL
	public static final String M_3g_7_5_1_6_06_PRE = headMID + "MID.P_MID_M_USER_OWE_BILL" + tail;
	
	
	
	/**
	 * 下面的校验针对8.2 综合指标快报一 的所有存储过程.
	 * 
	 * MID.MID_M_F_DEV_USER_3G
	 * MID.MID_M_INCO_CHARGE_MONTH
	 * MID.MID_M_3G_USER
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 * MID.MID_M_3G_NETWORK_CARD
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 * 
	 */
	//MID.MID_M_F_DEV_USER_3G
	public static final String M_3g_8_2_01_PRE = headMID + "MID.P_MID_M_F_DEV_USER_3G" + tail;
	//MID.MID_M_INCO_CHARGE_MONTH
	public static final String M_3g_8_2_02_PRE = headMID + "MID.P_MID_M_INCO_CHARGE_MONTH" + tail;
	//MID.MID_M_3G_USER
	public static final String M_3g_8_2_03_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_8_2_04_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	//MID.MID_M_3G_NETWORK_CARD
	public static final String M_3g_8_2_05_PRE = headMID + "MID.P_MID_M_3G_NETWORK_CARD" + tail;
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//这个验证日期是日 注意
	public static final String M_3g_8_2_06_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;
	
	
	/**
	 * 需要先运行下面的存储过程,先对它进行运行前检测. MID.P_MID_M_3G_WIRELESS_INDEX
	 */
	public static final String P_MID_M_3G_WIRELESS_INDEX_01_PRE = headMID + "MID.P_MID_M_3G_USER_PROPERTY" + tail;
	public static final String P_MID_M_3G_WIRELESS_INDEX_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	public static final String P_MID_M_3G_WIRELESS_INDEX_03_PRE = headMID + "P_MID_M_USER_SMS_GPRS_3G" + tail;
	//这个是日报数据,日志日期需要设置为日
	public static final String P_MID_M_3G_WIRELESS_INDEX_04_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;

}
