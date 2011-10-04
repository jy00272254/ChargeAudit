package cd.util.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
	
	/**
	 * 获取传入时间 area 范围内的时间列表
	 * @param from
	 * @param area
	 * @param m_d
	 * @return
	 */
	public static List<String> fromTo(String from, int area, String m_d){
		String to = null;
		List<String> result = null;
		try {
			area = area < 0 ? ++area : --area;
			if(TimeFormat.MONTH.equals(m_d.toUpperCase())){
				SimpleDateFormat sdf = new SimpleDateFormat(CURRMONTH);
				sdf.parse(from);
				Calendar fc = new GregorianCalendar(
						Integer.valueOf(from.substring(0, 4)),
						Integer.valueOf(from.substring(4, 6)) - 1 + area,
						1);
				to = sdf.format(new Date(fc.getTimeInMillis()));
			}else{
				SimpleDateFormat sdf = new SimpleDateFormat(TODAY1);
				sdf.parse(from);
				Calendar fc = new GregorianCalendar(
						Integer.valueOf(from.substring(0, 4)),
						Integer.valueOf(from.substring(4, 6)) - 1,
						Integer.valueOf(from.substring(6, 8)) + area);
				to = sdf.format(new Date(fc.getTimeInMillis()));
			}
			result = area < 0 ? fromTo(to, from, m_d) : fromTo(from, to, m_d);
		} catch (ParseException e) {
			e.printStackTrace();
			log.error("参数错误!");
			return null;
		}
		return result;
	}
	
	/**
	 * 获取从 from 到 to 时间范围内的时间
	 * @param from
	 * @param to
	 * @param m_d
	 * @return
	 */
	public static List<String> fromTo(String from, String to, String m_d){
		List<String> result = null;
		try {
			result = new ArrayList<String>();
			
			if(TimeFormat.MONTH.equals(m_d.toUpperCase())){
				SimpleDateFormat sdf = new SimpleDateFormat(CURRMONTH);
				sdf.parse(from);
				sdf.parse(to);
				Calendar fc = new GregorianCalendar(
						Integer.valueOf(from.substring(0, 4)),
						Integer.valueOf(from.substring(4, 6)) - 1,
						1);
				
				Calendar tc = new GregorianCalendar(
						Integer.valueOf(to.substring(0, 4)),
						Integer.valueOf(to.substring(4, 6)) - 1,
						1);
				
				if(fc.getTimeInMillis() > tc.getTimeInMillis())
					return null;
				
				while(fc.getTimeInMillis() <= tc.getTimeInMillis()){
					result.add(new SimpleDateFormat(CURRMONTH).format(new Date(fc.getTimeInMillis())));
					fc.add(Calendar.MONTH, 1);
				}
			}else{
				SimpleDateFormat sdf = new SimpleDateFormat(TODAY1);
				sdf.parse(from);
				sdf.parse(to);
				Calendar fc = new GregorianCalendar(
						Integer.valueOf(from.substring(0, 4)),
						Integer.valueOf(from.substring(4, 6)) - 1,
						Integer.valueOf(from.substring(6, 8)));
				
				Calendar tc = new GregorianCalendar(
						Integer.valueOf(to.substring(0, 4)),
						Integer.valueOf(to.substring(4, 6)) - 1,
						Integer.valueOf(to.substring(6, 8)));
				
				if(fc.getTimeInMillis() > tc.getTimeInMillis())
					return null;
				
				while(fc.getTimeInMillis() <= tc.getTimeInMillis()){
					result.add(new SimpleDateFormat(TODAY1).format(new Date(fc.getTimeInMillis())));
					fc.add(Calendar.DAY_OF_MONTH, 1);
				}
			}
			
		} catch (ParseException e) {
			log.error("参数错误!");
			return null;
		}
		
		return result;
	}
}
