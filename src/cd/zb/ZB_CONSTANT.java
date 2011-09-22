package cd.zb;

public class ZB_CONSTANT {

	public static final String 移动语音业务收入类日报_FILENAME = "CDYY04??001.081";
	public static final String 移动语音业务收入类日报_SQL = 
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
			"ACCT_DAY=?";
}
