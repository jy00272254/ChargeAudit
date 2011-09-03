package cd.check.sql;

/**
 * 用于确认 存储过程 运行状态 失败/运行中/未运行/运行成功
 * 
 * @author Administrator
 *
 */
public class Check {

	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(PROCNAME) = '";
//	private static final String headDWD = "SELECT * FROM DWD.DWD_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	public static final String P_MID_M_3G_WIRELESS_INDEX = headMID + "MID.P_MID_M_3G_WIRELESS_INDEX" + tail;
	
	// 2g 指标上传
	//7.6.2 渠道类综合统计
	public static final String M_2g_7_6_2_02 = headREPORT + "P_ZB_DEV_M_CHANNEL_02" + tail;
	public static final String M_2g_7_6_2_03 = headREPORT + "P_ZB_DEV_M_CHANNEL_03" + tail;
	public static final String M_2g_7_6_2_04 = headREPORT + "P_ZB_DEV_M_CHANNEL_04" + tail;
	public static final String M_2g_7_6_2_05 = headREPORT + "P_ZB_DEV_M_CHANNEL_05" + tail;
	//2g 8.2 综合指标一
	public static final String M_2g_8_2 = headREPORT + "REPORT.P_ZB_M_ZH_02" + tail;
	//2g 8.3 综合指标二 
	public static final String M_2g_8_3 = headREPORT + "REPORT.P_ZB_ZH_M_ZH_06" + tail;
	
	//3g 指标上传
	//7.2.1.5 无线上网卡业务
	public static final String M_3g_7_2_1_5_02 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_02" + tail;
	public static final String M_3g_7_2_1_5_03 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_03" + tail;
	public static final String M_3g_7_2_1_5_05 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_05" + tail;
	public static final String M_3g_7_2_1_5_06 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_06" + tail;
	public static final String M_3g_7_2_1_5_09 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_09" + tail;
	public static final String M_3g_7_2_1_5_11 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_11" + tail;
	public static final String M_3g_7_2_1_5_13 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_13" + tail;
	public static final String M_3g_7_2_1_5_15 = headREPORT + "REPORT.P_ZB_DEV_M_3G_05_15" + tail;
	// 7.2.1.6 定制专用无线上网卡发展月报
	public static final String M_3g_7_2_1_6 = headREPORT + "REPORT.P_ZB_DEV_M_3G_14_02" + tail;
	//7.2.3.1 渠道发展类统计
	public static final String M_3g_7_2_3_1_02 = headREPORT + "REPORT.P_ZB_DEV_M_3G_09_02" + tail;
	public static final String M_3g_7_2_3_1_03 = headREPORT + "REPORT.P_ZB_DEV_M_3G_09_03" + tail;
	public static final String M_3g_7_2_3_1_04 = headREPORT + "REPORT.P_ZB_DEV_M_3G_09_04" + tail;
	// 7.3.1.4 无线上网卡业务量月报
	public static final String M_3g_7_3_1_4_02 = headREPORT + "REPORT.P_ZB_USE_M_3G_04_02" + tail;
	public static final String M_3g_7_3_1_4_03 = headREPORT + "REPORT.P_ZB_USE_M_3G_04_03" + tail;
	public static final String M_3g_7_3_1_4_07 = headREPORT + "REPORT.P_ZB_USE_M_3G_04_07" + tail;
	//7.3.1.5 定制专用无线上网卡业务量月报
	public static final String M_3g_7_3_1_5 = headREPORT + "P_ZB_USE_M_3G_WIRLESS_05_02" + tail;
	//7.4.1.4 无线上网卡收入
	public static final String M_3g_7_4_1_4_03 = headREPORT + "REPORT.P_ZB_INCO_M_3G_04_03" + tail;
	public static final String M_3g_7_4_1_4_08 = headREPORT + "REPORT.P_ZB_INCO_M_3G_04_08" + tail;
	//7.5.1.3 渠道类综合月报
	public static final String M_3g_7_5_1_3 = headREPORT + "REPORT.P_ZB_M_3G_CHANNEL_ZH" + tail;
	//7.5.1.4 渠道数量类月报
	public static final String M_3g_7_5_1_4_02 = headREPORT + "P_ZB_M_3G_CHANNEL_02" + tail;
	public static final String M_3g_7_5_1_4_03 = headREPORT + "P_ZB_M_3G_CHANNEL_03" + tail;
	public static final String M_3g_7_5_1_4_04 = headREPORT + "P_ZB_M_3G_CHANNEL_04" + tail;
	public static final String M_3g_7_5_1_4_05 = headREPORT + "P_ZB_M_3G_CHANNEL_05" + tail;
	//7.5.1.5 渠道终端类月报
	public static final String M_3g_7_5_1_5 = headREPORT + "REPORT.P_ZB_CHANNEL_M_3G_05_02" + tail;
	//7.5.1.6 渠道佣金类月报
	public static final String M_3g_7_5_1_6 = headREPORT + "REPORT.P_ZB_CHANNEL_M_3G_06_02" + tail;
	// 3g 8.2 综合指标快报一
	public static final String M_3g_8_2_02 = headREPORT + "REPORT.P_ZB_M_ZH_3G_02" + tail;
	public static final String M_3g_8_2_03 = headREPORT + "REPORT.P_ZB_M_ZH_3G_03" + tail;
	
	//纵向数据接口
	//3.1.1.5 订购实例资源属性(日)
	public static final String M_ZX_3_1_1_5 = headREPORT + "P_ZB_D_BIDWAL02005" + tail;
	//4.1.1.1 客户
	public static final String M_ZX_4_1_1_1 = headREPORT + "REPORT.P_ZB_M_BIDWAL01001" + tail;
	//4.1.1.2 组织客户
	public static final String M_ZX_4_1_1_2 = headREPORT + "REPORT.P_ZB_M_BIDWAL01002" + tail;
	//4.1.1.3 个人客户
	public static final String M_ZX_4_1_1_3 = headREPORT + "REPORT.P_ZB_M_BIDWAL01003" + tail;
	//4.1.1.6 客户证件信息
	public static final String M_ZX_4_1_1_6 = headREPORT + "P_ZB_M_BIDWAL01006" + tail;
	//4.3.1.1 渠道信息
	public static final String M_ZX_4_3_1_1 = headREPORT + "P_ZB_M_BIDWAL03001" + tail;
	//4.3.1.2 渠道佣金
	public static final String M_ZX_4_3_1_2 = headREPORT + "P_ZB_M_BIDWAL03002" + tail;
	//4.8.1.1 号码资源表
	public static final String M_ZX_4_8_1_1 = headREPORT + "P_ZB_M_BIDWAL08001" + tail;
	
	//3G核心明细数据
	//3.1.3.1. 渠道信息表
	public static final String M_3GMX_3_1_3_1 = headREPORT + "P_REPORT_M_3G_USER_CHANNEL" + tail;
	//3.4.1. 扇区信息
	public static final String M_3GMX_3_4_1 = headREPORT + "P_REPORT_M_3G_USER_CELL" + tail;
	
}
