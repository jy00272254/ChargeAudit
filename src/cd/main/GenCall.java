package cd.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * �����������,��Ҫ����ʱ��������̫��,������д.
 * @author Administrator
 *
 */
public class GenCall {

	public static void main(String[] args) {
		//�洢������
		String procname = "\"DM\".\"P_DM_D_3G_SCHOOL_CARD_STAT\"";
		//��ʼ����
		String begin = "20110811";
		//��������
		String end = "20110823";
		//�������� �� y �� m �� d
		String type = "d";
		sysoutCall(begin, end, procname, type);
	}
	
	private static void sysoutCall(String begin, String end, String procname, String type){
		Calendar beginC = getCalendar(begin, type);
		Calendar endC = getCalendar(end, type);
		sysout(beginC, endC, procname, type);
	}
	
	private static void sysout(Calendar beginC, Calendar endC, String procname, String type){
		
		String dateFormat = "";
		int cFormat = 0;
		if("d".equals(type.toLowerCase())){
			dateFormat = "yyyyMMdd";
			cFormat = Calendar.DAY_OF_MONTH;
		}else if("m".equals(type.toLowerCase())){
			dateFormat = "yyyyMM";
			cFormat = Calendar.MONTH;
		}else if("y".equals(type.toLowerCase())){
			dateFormat = "yyyy";
			cFormat = Calendar.YEAR;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		while(beginC.compareTo(endC) <= 0){
			System.out.println("call " + procname + "('"+ sdf.format(new Date(beginC.getTimeInMillis())) +"');");
			beginC.set(cFormat, beginC.get(cFormat)+1);
		}
	}
	
	private static Calendar getCalendar(String date, String type){
		int year = getYear(date);
		int month  = getMonth(date);
		int day =  getDay(date);
		return new GregorianCalendar(year, month-1 , day);
	} 
	
	private static int getYear(String date){
		return Integer.valueOf(date.substring(0, 4));
	}
	
	private static int getMonth(String date){
		return Integer.valueOf(date.substring(4, 6));
	}
	
	private static int getDay(String date){
		return Integer.valueOf(date.substring(6, 8));
	}

}
