package cd.check.sql;

/**
 * 用于确认 存储过程 运行状态 失败/运行中/未运行/运行成功
 * 
 * @author Administrator
 *
 */
public class Check {

	private static final String head = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	//7.6.2 渠道类综合统计
	public static final String M_2g_7_6_2_02 = head + "P_ZB_DEV_M_CHANNEL_02" + tail;
	public static final String M_2g_7_6_2_03 = head + "P_ZB_DEV_M_CHANNEL_03" + tail;
	public static final String M_2g_7_6_2_04 = head + "P_ZB_DEV_M_CHANNEL_04" + tail;
	public static final String M_2g_7_6_2_05 = head + "P_ZB_DEV_M_CHANNEL_05" + tail;
	//2g 8.2 综合指标一
	public static final String M_2g_8_2 = head + "REPORT.P_ZB_M_ZH_02" + tail;
	//2g 8.3 综合指标二 
	public static final String M_2g_8_3 = head + "REPORT.P_ZB_ZH_M_ZH_06" + tail;
	//7.2.1.5 无线上网卡业务
	public static final String M_3g_7_2_1_5_02 = head + "REPORT.P_ZB_DEV_M_3G_05_02" + tail;
	public static final String M_3g_7_2_1_5_03 = head + "REPORT.P_ZB_DEV_M_3G_05_03" + tail;
	public static final String M_3g_7_2_1_5_05 = head + "REPORT.P_ZB_DEV_M_3G_05_05" + tail;
	public static final String M_3g_7_2_1_5_06 = head + "REPORT.P_ZB_DEV_M_3G_05_06" + tail;
	public static final String M_3g_7_2_1_5_09 = head + "REPORT.P_ZB_DEV_M_3G_05_09" + tail;
	public static final String M_3g_7_2_1_5_11 = head + "REPORT.P_ZB_DEV_M_3G_05_11" + tail;
	public static final String M_3g_7_2_1_5_13 = head + "REPORT.P_ZB_DEV_M_3G_05_13" + tail;
	public static final String M_3g_7_2_1_5_15 = head + "REPORT.P_ZB_DEV_M_3G_05_15" + tail;
	// 7.2.1.6 定制专用无线上网卡发展月报
	public static final String M_3g_7_2_1_6 = head + "REPORT.P_ZB_DEV_M_3G_14_02" + tail;
	//7.2.3.1 渠道发展类统计
	public static final String M_3g_7_2_3_1_02 = head + "REPORT.P_ZB_DEV_M_3G_09_02" + tail;
	public static final String M_3g_7_2_3_1_03 = head + "REPORT.P_ZB_DEV_M_3G_09_03" + tail;
	public static final String M_3g_7_2_3_1_04 = head + "REPORT.P_ZB_DEV_M_3G_09_04" + tail;
	// 7.3.1.4 无线上网卡业务量月报
	public static final String M_3g_7_3_1_4_02 = head + "REPORT.P_ZB_USE_M_3G_04_02" + tail;
	public static final String M_3g_7_3_1_4_03 = head + "REPORT.P_ZB_USE_M_3G_04_03" + tail;
	public static final String M_3g_7_3_1_4_07 = head + "REPORT.P_ZB_USE_M_3G_04_07" + tail;
	//7.3.1.5 定制专用无线上网卡业务量月报
	public static final String M_3g_7_3_1_5 = head + "P_ZB_USE_M_3G_WIRLESS_05_02" + tail;
	//7.4.1.4 无线上网卡收入
	public static final String M_3g_7_4_1_4_03 = head + "REPORT.P_ZB_INCO_M_3G_04_03" + tail;
	public static final String M_3g_7_4_1_4_08 = head + "REPORT.P_ZB_INCO_M_3G_04_08" + tail;
	//7.5.1.3 渠道类综合月报
	public static final String M_3g_7_5_1_3 = head + "REPORT.P_ZB_M_3G_CHANNEL_ZH" + tail;
	//7.5.1.4 渠道数量类月报
	public static final String M_3g_7_5_1_4_02 = head + "P_ZB_M_3G_CHANNEL_02" + tail;
	public static final String M_3g_7_5_1_4_03 = head + "P_ZB_M_3G_CHANNEL_03" + tail;
	public static final String M_3g_7_5_1_4_04 = head + "P_ZB_M_3G_CHANNEL_04" + tail;
	public static final String M_3g_7_5_1_4_05 = head + "P_ZB_M_3G_CHANNEL_05" + tail;
	//7.5.1.5 渠道终端类月报
	public static final String M_3g_7_5_1_5 = head + "REPORT.P_ZB_CHANNEL_M_3G_05_02" + tail;
	//7.5.1.6 渠道佣金类月报
	public static final String M_3g_7_5_1_6 = head + "REPORT.P_ZB_CHANNEL_M_3G_06_02" + tail;
	// 3g 8.2 综合指标快报一
	public static final String M_3g_8_2_02 = head + "REPORT.P_ZB_M_ZH_3G_02" + tail;
	public static final String M_3g_8_2_03 = head + "REPORT.P_ZB_M_ZH_3G_03" + tail;
	
}
