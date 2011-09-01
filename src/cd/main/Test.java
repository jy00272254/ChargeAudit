package cd.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Test {
	public static void main(String[] args) {
		
		System.out.println(System.currentTimeMillis());
		
		Calendar c = new GregorianCalendar();
		
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)+1, 8, 30, 0);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmmss");
		System.out.println(sdf.format(c.getTime()));
		
		System.out.println(sdf.format(new Date(1314923400671l)));
		
		System.out.println(c.getTimeInMillis());
	
	}
}
