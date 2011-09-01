package cd.util.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTime {

	public static Date parse(String src, String format){
		Date result = null;
		try {
			 result = new SimpleDateFormat(format).parse(src);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String format(Date src, String format){
		return new SimpleDateFormat(format).format(src);
	}
	
}
