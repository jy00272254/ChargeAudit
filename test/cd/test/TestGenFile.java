package cd.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import cd.util.time.FormatTime;
import cd.zb.GenFile;

public class TestGenFile extends GenFile{

	@Test
	public void testTime() {

		String time = "20111022";
		Calendar c = new GregorianCalendar(
				Integer.valueOf(time.substring(0, 4)),
				Integer.valueOf(time.substring(4, 6)), 
				0);
		
		Date date = new Date(c.getTimeInMillis());
		System.out.println(FormatTime.format(date, "yyyyMMdd"));
	}
	
	@Test
	public void testGetHead(){
		GenFile gf = new GenFile();
		System.out.println(gf.getHead("CM3G05A201108004.081", "201108", 25663, "m"));
		System.out.println(gf.getHead("CDYY04B110921001.081", "20110822", 33, "d"));
	}

}
