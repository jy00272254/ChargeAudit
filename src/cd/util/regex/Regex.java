package cd.util.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	/**
	 * Æ¥ÅäÊÖ»úºÅÂë
	 * @param lineStr
	 * @return
	 */
	public static List<String> device_number(String lineStr) {
		Pattern p = Pattern.compile("1[3,4,5,8]\\d{9}");
		Matcher m = p.matcher(lineStr);
		List<String> device_numbers = new ArrayList<String>();
		while(m.find())
			device_numbers.add(m.group());
		return device_numbers;
	}
	
	/**
	 * Æ¥ÅäÊÖ»úºÅÂë
	 * @param lineStr
	 * @return
	 */
	public static List<String> device_number(StringBuffer lineStr) {
		return device_number(lineStr.toString());
	}
	

}
