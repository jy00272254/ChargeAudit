package cd.precheck.sql;

/**
 * ����ȷ�� �洢���� ����״̬ ʧ��/������/δ����/���гɹ�
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
	 * �����У�����7.6.2 �������ۺ�ͳ�� �����д洢����.
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
	 * �����У�����8.2 �ۺ�ָ��һ �����д洢����.
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
	 * �����У�����8.3 �ۺ�ָ��� �����д洢����.
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
	 * �����У�����7.2.1.5 �����д洢����.
	 */
	public static final String M_3g_7_2_1_5_01_PRE = headMID + "MID.P_MID_M_3G_WIRELESS_INDEX" + tail;
	public static final String M_3g_7_2_1_5_02_PRE = headMID + "P_MID_M_REPORT_CALL_3G" + tail;
	public static final String M_3g_7_2_1_5_03_PRE = headMID + "MID.P_MID_M_3G_NETWORK_CARD" + tail;
	public static final String M_3g_7_2_1_5_04_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;
	
	/**
	 * �����У�����7.2.1.6 �����д洢����. 
	 * 
	 * MID.MID_M_3G_USER_PROPERTY
	 */
	public static final String M_3g_7_2_1_6_PRE  = headMID + "MID.P_MID_M_3G_USER_PROPERTY" + tail;

	
	/**
	 * �����У�����7.2.3.1 �����д洢����.
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
	 * �����У����� 7.3.1.4 ����������ҵ�����±� �����д洢����.
	 * 
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 * MID.MID_M_3G_USER
	 * MID.MID_M_USER_SMS_GPRS_3G
	 */
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//�����֤�������� ע��
	public static final String M_3g_7_3_1_4_01_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;
	//MID.MID_M_3G_USER
	public static final String M_3g_7_3_1_4_02_PRE =  headMID + "MID.P_MID_M_3G_USER" + tail;
	//MID.MID_M_USER_SMS_GPRS_3G
	public static final String M_3g_7_3_1_4_03_PRE =  headMID + "P_MID_M_USER_SMS_GPRS_3G" + tail;
	
	
	/**
	 * �����У�����7.3.1.5 ����ר������������ҵ�����±� �����д洢����.
	 * 
	 * MID.MID_M_3G_USER
	 * DWD.DWD_D_USER_GPRS_STREAM_NEW
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER
	public static final String M_3g_7_3_1_5_01_PRE =  headMID + "MID.P_MID_M_3G_USER" + tail;
	//DWD.DWD_D_USER_GPRS_STREAM_NEW
	//�����֤�������� ע��
	public static final String M_3g_7_3_1_5_02_PRE =  headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_7_3_1_5_03_PRE =  headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	
	/**
	 * �����У�����7.4.1.4 �������������� �����д洢����.
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
	 * �����У�����7.5.1.3 �������ۺ��±� �����д洢����.
	 * 
	 * MID.MID_M_3G_USER_PROPERTY
	 * MID.MID_M_USER_CHARGE_SECOND_HOR
	 */
	//MID.MID_M_3G_USER_PROPERTY
	public static final String M_3g_7_5_1_3_01_PRE = headMID + "MID.P_MID_M_3G_USER_PROPERTY" + tail;
	//MID.MID_M_USER_CHARGE_SECOND_HOR
	public static final String M_3g_7_5_1_3_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	
	/**
	 * �����У�����7.5.1.4 �����������±� �����д洢����.
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
	 * У��ù�������Ϊ�ù������к�������� 7.5.1.6 ����.���Ǳ���ù��̲���Ҫ�Ҹ���.
	 * �����У�����7.5.1.5 �����ն����±� �����д洢����.
	 * 
	 * MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	 * MID.MID_M_3G_USER
	 */
	//MID.MID_M_V_USER_MOBILEUSER_3G_ZD
	public static final String M_3g_7_5_1_5_01_PRE = headMID + "MID.P_MID_M_V_USER_MOBILEUSER_3G_ZD" + tail;
	//MID.MID_M_3G_USER
	public static final String M_3g_7_5_1_5_02_PRE = headMID + "MID.P_MID_M_3G_USER" + tail;

	
	/**
	 * �����У�����7.5.1.6 ����Ӷ�����±� �����д洢����.
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
	 * �����У�����8.2 �ۺ�ָ��챨һ �����д洢����.
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
	//�����֤�������� ע��
	public static final String M_3g_8_2_06_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;
	
	
	/**
	 * ��Ҫ����������Ĵ洢����,�ȶ�����������ǰ���. MID.P_MID_M_3G_WIRELESS_INDEX
	 */
	public static final String P_MID_M_3G_WIRELESS_INDEX_01_PRE = headMID + "MID.P_MID_M_3G_USER_PROPERTY" + tail;
	public static final String P_MID_M_3G_WIRELESS_INDEX_02_PRE = headMID + "MID.P_MID_M_USER_CHARGE_SECOND_HOR" + tail;
	public static final String P_MID_M_3G_WIRELESS_INDEX_03_PRE = headMID + "P_MID_M_USER_SMS_GPRS_3G" + tail;
	//������ձ�����,��־������Ҫ����Ϊ��
	public static final String P_MID_M_3G_WIRELESS_INDEX_04_PRE = headDWD + "DWD.P_DWD_D_USER_GPRS_STREAM" + tail;

}
