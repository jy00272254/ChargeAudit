package cd.precheck.sql;

/**
 * 用于确认 7.3.1.4 无线上网卡业务量月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_3_1_4_sql_pre {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	/**
	 * 下面的校验针对 7.3.1.4 无线上网卡业务量月报 的所有存储过程.
	 * 
	 * 由于 7.3.1.4 3张表都需要关联GP详单,于是把GP详单单独拿出来沉淀一个过程.用来得到沉淀数据
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 *修改为如下过程.替代GP详单
	 * MID.MID_M_MIDDLE_GP
	 * 
	 * MID.MID_M_3G_USER
	 * MID.MID_M_USER_SMS_GPRS_3G
	 */
	public static final String M_3g_7_3_1_4_01_PRE_SERVICENAME = "3G 7.3.1.4 无线上网卡业务量月报";
	
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//这个验证日期是日 注意
	//public static final String M_3g_7_3_1_4_01_PRE_PROCNAME = "DWD.P_DWD_D_USER_GPRS_STREAM";
	//public static final String M_3g_7_3_1_4_01_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;
	
	//MID.MID_M_MIDDLE_GP
	public static final String M_3g_7_3_1_4_01_PRE_PROCNAME = "MID.P_MID_M_MIDDLE_GP";
	public static final String M_3g_7_3_1_4_01_PRE = headMID + "MID.P_MID_M_MIDDLE_GP" + tail;
	//MID.MID_M_3G_USER
	public static final String M_3g_7_3_1_4_02_PRE_PROCNAME = "MID.P_MID_M_3G_USER";
	public static final String M_3g_7_3_1_4_02_PRE =  headMID + "MID.P_MID_M_3G_USER" + tail;
	//MID.MID_M_USER_SMS_GPRS_3G
	public static final String M_3g_7_3_1_4_03_PRE_PROCNAME = "P_MID_M_USER_SMS_GPRS_3G";
	public static final String M_3g_7_3_1_4_03_PRE =  headMID + "P_MID_M_USER_SMS_GPRS_3G" + tail;
	
}
