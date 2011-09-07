package cd.util.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

/**
 * 取得各种时间日期格式的时间字符串
 * @author Administrator
 *
 */
public class GetTime {

	private static Logger log = Logger.getLogger(GetTime.class);
	private static final String CURRMONTH = "yyyyMM";
	private static final String TODAY1 = "yyyyMMdd";
	private static final String YESTERDAY = TODAY1;
	private static final String TODAY2 = "yyyy-MM-dd";
	private static final String DAKAMONTH  = "yyyy-MM";
	
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
	
	public static String dakaMonth(){
		Calendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		if(day > 24){
			cal.add(Calendar.MONTH, 1);
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DAKAMONTH);
		return sdf.format(cal.getTime());
	}
	
	public static String dakaMonth(String time){
		if(time.length() < 8){
			log.warn("传入值不符合规则,例如:  20110808 (YYYYMMDD) ");
			return null;
		}
		time = time.length() > 8 ? time.substring(0, 8) : time;
		try {
			int year = Integer.valueOf(time.substring(0, 4));
			int month  = Integer.valueOf(time.substring(4, 6));
			int day = Integer.valueOf(time.substring(6, 8));
			
			Calendar cal = new GregorianCalendar(year, month-1, day);
			day = cal.get(Calendar.DAY_OF_MONTH);
			if(day > 24){
				cal.add(Calendar.MONTH, 1);
			}
			SimpleDateFormat sdf = new SimpleDateFormat(DAKAMONTH);
			return sdf.format(cal.getTime());
		} catch (Exception e) {
			log.warn("传入值不符合规则,例如:  20110808 (YYYYMMDD) ");
			return null;
		}
	}
}
