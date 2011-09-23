package cd.zb;

import java.util.ArrayList;
import java.util.List;

public class ZB_CONSTANT {

	//	�ƶ�����ҵ���������ձ�	DYY04001
	public static final String �ƶ�����ҵ���������ձ�_FILENAME = "CDYY04??001.081";
	public static List<String> �ƶ�����ҵ���������ձ�_SQL = new ArrayList<String>();

	//3G�û��ձ�
	public static final String �û��ձ�_FILENAME = "CD3G02??001.081";
	public static List<String> �û��ձ�_SQL = new ArrayList<String>();
	
	//3G�����������󸶷Ѳ�Ʒ�ձ�
	public static final String �����������󸶷Ѳ�Ʒ�ձ�_FILENAME = "CD3G01??002.081";
	public static List<String> �����������󸶷Ѳ�Ʒ�ձ�_SQL = new ArrayList<String>();
	
	//3Gҵ��ʹ����
	public static final String ҵ��ʹ����_FILENAME = "CD3G03??001.081";
	public static List<String> ҵ��ʹ����_SQL = new ArrayList<String>();
	
	static {
		�ƶ�����ҵ���������ձ�_SQL.add(
			"SELECT " +
			"RECORD_TYPE," +
			"CITY_NO," +
			"BRAND_ID," +
			"TELE_TYPE_ID," +
			"PAY_MODE_ID," +
			"GROUP_FLAG_ID," +
			"CALL_FEE," +
			"INCR_FEE," +
			"SMS_FEE," +
			"RENT_FEE," +
			"JF_FEE " +
		"FROM " +
			"REPORT.REPORT_D_ZB_INCO_YY_BILL_TOT " +
		"WHERE  " +
			"ACCT_DAY=?");
		
		// 02��¼
		�û��ձ�_SQL.add(
				"SELECT " +
					"RECORD_TYPE," +
					"CITY_NO," +
					"DINNER_TYPE," +
					"ONNET_USERS," +
					"MON_NEW_USERS," +
					"NEW_USER," +
					"USER_2G_3G," +
					"RUN_OUT_USER," +
					"USER_3G_2G," +
					"CALL_USERS," +
					"ACTIVE_USERS," +
					"OUTNET_USERS," +
					"TOTAL_CALL_USERS," +
					"TOTAL_ACTIVE_USERS "+
				"FROM "+
					"report.REPORT_D_ZB_DEV_3G_01_02 "+
				"WHERE "+
					"day_no=?"
		);
		
		//04��¼
		�û��ձ�_SQL.add(
				"SELECT " +
					"RECORD_TYPE," +
					"CITY_NO," +
					"NEW_USER "+
				"FROM "+
					"REPORT.REPORT_D_ZB_DEV_D_3G_01_04 "+
				"WHERE "+
					"day_no=?"
		);
		
		//06��¼
		�û��ձ�_SQL.add(
				"SELECT " +
					"RECORD_TYPE," +
					"CITY_NO," +
					"PAY_MODE," +
					"DINNER_TYPE," +
					"CHANNEL_TYPE," +
					"ON_USERS,DEV_USER "+
				"FROM "+
					"REPORT.REPORT_D_ZB_DEV_D_3G_01_06 "+
				"WHERE "+
					"day_no=?"
		);
		
		//07��¼
		�û��ձ�_SQL.add(
				"SELECT " +
					"RECORD_TYPE," +
					"PROV_ID," +
					"CITY_NO," +
					"CHANEL_TYPE," +
					"DEV_USER," +
					"TOTAL_CHANELS," +
					"TOTAL_DEV_CHANELS "+
				"FROM "+
					"REPORT.REPORT_D_ZB_DEV_D_3G_01_07 "+
				"WHERE "+
					"day_no=?"
		);
		
		//08��¼
		�û��ձ�_SQL.add(
				"SELECT " +
					"record_type," +
					"city_no," +
					"pay_type," +
					"product_type," +
					"dinner_type," +
					"channel_type," +
					"dev_user," +
					"outnet_user," +
					"ONNET_USER," +
					"JF_INCOME "+
				"FROM "+
					"REPORT.REPORT_ZB_D_DEV_3G_01_08 "+
				"WHERE "+
					"day_no=?"
		);
		
		//10��¼
		�û��ձ�_SQL.add(
				"SELECT " +
					"RECORD_TYPE," +
					"AREA_NO," +
					"PAY_MODE," +
					"DINNER_TYPE," +
					"ONNET_USERS," +
					"DEV_USRES," +
					"USER_2G_3G "+
				"FROM "+
					"REPORT.REPORT_D_ZB_DEV_3G_01_10 "+
				"WHERE "+
					"day_no=?"
		);
		
		//13��¼
		�û��ձ�_SQL.add(
				"SELECT " +
					"RECORD_TYPE," +
					"CITY_NO," +
					"PAY_MODE," +
					"PPS_CONTRACT_TYPE," +
					"INNET_USERS," +
					"DEV_USERS "+
				"FROM "+
					"report.REPORT_D_ZB_DEV_D_3G_01_13 "+
				"WHERE "+
					"day_no=?"
		);
		
		�����������󸶷Ѳ�Ʒ�ձ�_SQL.add(
				"SELECT " +
					"RECORD_TYPE," +
					"CITY_NO," +
					"ONNET_USERS," +
					"DEV_USERS," +
					"ACTIVE_USERS," +
					"ONNET_NUM," +
					"SMS_NUM," +
					"DIS_CHARGE," +
					"CALL_INCOME," +
					"MONTH_ACTIVE_USERS "+
				"FROM "+
					"REPORT.REPORT_D_ZB_ZH_D_3G_02_02 "+
				"WHERE "+
					"day_no=?"
		);
		
		//02��¼
		ҵ��ʹ����_SQL.add(
				"SELECT " +
					"RECORD_TYPE," +
					"CITY_NO," +
					"DINNER_TYPE," +
					"JF_TIMES," +
					"CALL_DURATION," +
					"CALL_NUMS," +
					"decimal(round(dis_charge, 0),12,0) "+
				"FROM "+
					"REPORT.REPORT_D_USE_3G_01_02 "+
				"WHERE "+
					"day_no=?"
		);
		
		// 03��¼
		ҵ��ʹ����_SQL.add(
				"SELECT " +
					"record_type," +
					"city_no," +
					"pay_type," +
					"product_type," +
					"dinner_type," +
					"time_level," +
					"active_user," +
					"dis_charge," +
					"access_num," +
					"sms_num "+
				"FROM "+
					"REPORT.REPORT_D_ZB_USE_3G_01_03 "+
				"WHERE "+
					"day_no=?"
		);
	}
}
