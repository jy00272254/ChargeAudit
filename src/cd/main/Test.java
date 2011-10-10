package cd.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cd.check.service.ProcId;


public class Test {
	public static void main(String[] args) {
		
//		System.out.println(System.currentTimeMillis());
//		
		Calendar c = new GregorianCalendar();
		
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)+1, 8, 30, 0);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmmss");
		System.out.println(sdf.format(c.getTime()));
		
		System.out.println(sdf.format(new Date(1317169800390l)));
		
		System.out.println(c.getTimeInMillis());
		
		
		String querySql = 
			"SELECT " +
				"a.city_no a_city_no," +
				"a.dinner_type a_dinner_type, " +
				"a.total_active_users a_total_active_users," +
				"b.city_no b_city_no," +
				"b.dinner_type b_dinner_type, " +
				"b.total_active_users b_total_active_users " +
			"FROM 	" +
			"(SELECT city_no,dinner_type,total_active_users " +
			"FROM REPORT.REPORT_D_ZB_DEV_3G_01_02 	" +
			"WHERE day_no = ?) a " +
			"INNER JOIN " +
			"(SELECT city_no,dinner_type,total_active_users " +
			"FROM REPORT.REPORT_D_ZB_DEV_3G_01_02 	" +
			"WHERE day_no = ?) b " +
			"ON a.dinner_type=b.dinner_type and a.city_no=b.city_no " +
			"WHERE a.total_active_users > b.total_active_users";
		
		System.out.println(querySql);

//		ProcId.all();
		
//		System.out.println(13186998 - 13186998);
		
		
//		String str = "SELECT "+
//	"* "+
//"FROM  "+
//		"(SELECT dinner_type,total_call_users  "+
//		"FROM REPORT.REPORT_D_ZB_DEV_3G_01_02  "+
//		"WHERE day_no = to_char(to_date('?','yyyymmdd') - 1 days, 'yyyymmdd')) a "+
//	"INNER JOIN "+
//		"(SELECT dinner_type,total_call_users  "+
//		"FROM REPORT.REPORT_D_ZB_DEV_3G_01_02  "+
//		"WHERE day_no = '?') b "+
//	"ON "+
//		"a.dinner_type=b.dinner_type "+
//"WHERE "+
//	"a.total_call_users > b.total_call_users;";
//		
//		
//		System.out.println(str);
		
//		for (int i = 4; i <= 100; i++) {
//			int cs = i - 2 ;
//			int result = 120*(cs*cs+cs*3);
//			System.out.println( i + " -- " + result + " -- " + result/60 + " -- " + result/60/24);
//		}
	
	}
}
