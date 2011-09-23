package cd.zb;

import java.util.ArrayList;
import java.util.List;

public class ZB_CONSTANT {

	//	移动语音业务收入类日报	DYY04001
	public static final String 移动语音业务收入类日报_FILENAME = "CDYY04??001.081";
	public static List<String> 移动语音业务收入类日报_SQL = new ArrayList<String>();

	//3G用户日报
	public static final String 用户日报_FILENAME = "CD3G02??001.081";
	public static List<String> 用户日报_SQL = new ArrayList<String>();
	
	//3G无线上网卡后付费产品日报
	public static final String 无线上网卡后付费产品日报_FILENAME = "CD3G01??002.081";
	public static List<String> 无线上网卡后付费产品日报_SQL = new ArrayList<String>();
	
	//3G业务使用类
	public static final String 业务使用类_FILENAME = "CD3G03??001.081";
	public static List<String> 业务使用类_SQL = new ArrayList<String>();
	
	static {
		移动语音业务收入类日报_SQL.add(
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
		
		// 02记录
		用户日报_SQL.add(
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
		
		//04记录
		用户日报_SQL.add(
				"SELECT " +
					"RECORD_TYPE," +
					"CITY_NO," +
					"NEW_USER "+
				"FROM "+
					"REPORT.REPORT_D_ZB_DEV_D_3G_01_04 "+
				"WHERE "+
					"day_no=?"
		);
		
		//06记录
		用户日报_SQL.add(
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
		
		//07记录
		用户日报_SQL.add(
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
		
		//08记录
		用户日报_SQL.add(
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
		
		//10记录
		用户日报_SQL.add(
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
		
		//13记录
		用户日报_SQL.add(
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
		
		无线上网卡后付费产品日报_SQL.add(
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
		
		//02记录
		业务使用类_SQL.add(
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
		
		// 03记录
		业务使用类_SQL.add(
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
