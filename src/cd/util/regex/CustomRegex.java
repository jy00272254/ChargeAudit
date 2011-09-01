package cd.util.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomRegex {
	
	public List<List<String>> match(String src, String rule){
		return match(src, null, null, rule);
	}
	
	public List<List<String>> match(String src, String begin, String end, String rule){
		List<List<String>> result = new ArrayList<List<String>>();
		Pattern p = Pattern.compile(rule);
		Matcher m = p.matcher(src);
		while(m.find()){
			List<String> row = new ArrayList<String>();
			for(int i=0; i<= m.groupCount(); i++){
				if(i != 0)
					row.add(m.group(i));
			}
			result.add(row);
		}
		return result;
	}
}
