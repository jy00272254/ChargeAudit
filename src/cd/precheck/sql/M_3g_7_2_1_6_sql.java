package cd.precheck.sql;

/**
 * ����ȷ�� 7.2.1.6 ����ר��������������չ�±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_1_6_sql {

	/**
	 * �����У�����7.2.1.6 �����д洢����. 
	 * 
	 * MID.MID_M_3G_USER_PROPERTY
	 */
	public static final String PRECHECK_REPORT_P_ZB_DEV_M_3G_14_02_01 = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(procname) = 'MID.P_MID_M_3G_USER_PROPERTY' AND LOGDATE=?";

}
