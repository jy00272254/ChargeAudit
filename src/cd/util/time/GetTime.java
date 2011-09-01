package cd.util.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 取得各种时间日期格式的时间字符串
 * @author Administrator
 *
 */
public class GetTime {

	private static final String CURRMONTH="yyyyMM";
	private static final String TODAY1="yyyyMMdd";
	private static final String YESTERDAY=TODAY1;
	private static final String TODAY2="yyyy-MM-dd";
	
	public static String currMonth(){
		SimpleDateFormat sdf = new SimpleDateFormat(CURRMONTH);
		return sdf.format(new Date());
	}
	
	public static String today1(){
		SimpleDateFormat sdf = new SimpleDateFormat(TODAY1);
		return sdf.format(new Date());
	}
	
	public static String today2(){
		SimpleDateFormat sdf = new SimpleDateFormat(TODAY2);
		return sdf.format(new Date());
	}
	
	public static String yesterday(){
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat sdf = new SimpleDateFormat(YESTERDAY);
		return sdf.format(cal.getTime());
	}
}
