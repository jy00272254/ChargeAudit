package cd.main;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cd.autocheckin.Client;
import cd.util.time.GetTime;

public class Test1 {

	public static void main(String[] args) {
		
		Client client = new Client();
		System.out.println(client.nextDakaTime());
		
		Calendar c = new GregorianCalendar();
		long curr = c.getTimeInMillis(); 
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 8, 30, 0);
		long _0830 = c.getTimeInMillis();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), 18, 30, 0);
		long _1630 = c.getTimeInMillis();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)+1, 8, 30, 0);
		long _0830n = c.getTimeInMillis();
		
		System.out.println(curr);
		System.out.println(_0830);
		System.out.println(_1630);
		System.out.println(_0830n);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmmss");
		System.out.println(sdf.format(new Date(curr)));
		System.out.println(sdf.format(new Date(_0830)));
		System.out.println(sdf.format(new Date(_1630)));
		System.out.println(sdf.format(new Date(_0830n)));
	}

}
