package cd.precheck.sql;

public class P_MID_M_3G_WIRELESS_INDEX_sql {
	/**
	 * ��Ҫ����������Ĵ洢����,�ȶ�����������ǰ���. MID.P_MID_M_3G_WIRELESS_INDEX
	 */
	public static final String PRECHECK_MID_P_MID_M_3G_WIRELESS_INDEX_01 = "select * from mid.mid_t_log where UPPER(procname)='MID.P_MID_M_3G_USER_PROPERTY' AND LOGDATE=?";
	public static final String PRECHECK_MID_P_MID_M_3G_WIRELESS_INDEX_02 = "select * from mid.mid_t_log where UPPER(procname)='MID.P_MID_M_USER_CHARGE_SECOND_HOR' AND LOGDATE=?";
	public static final String PRECHECK_MID_P_MID_M_3G_WIRELESS_INDEX_03 = "select * from mid.mid_t_log where UPPER(procname)='P_MID_M_USER_SMS_GPRS_3G' AND LOGDATE=?";
	//������ձ�����,��־������Ҫ����Ϊ��
	public static final String PRECHECK_MID_P_MID_M_3G_WIRELESS_INDEX_04 = "select * from dwd.dwd_t_log where UPPER(procname)='DWD.P_DWD_D_USER_GPRS_STREAM' AND LOGDATE=?";

}
