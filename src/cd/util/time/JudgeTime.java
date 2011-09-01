package cd.util.time;

import java.util.Date;

/**
 * �����ж�ʱ���Ƿ��ڷ�Χ��,�Ƚ�ʱ��ȵ�
 * @author Administrator
 *
 */
public class JudgeTime {
	
	public static boolean between(String src, String begin, String end, String format){
		Date srcDate = FormatTime.parse(src, format);
		Date beginDate = FormatTime.parse(begin, format);
		Date endDate = FormatTime.parse(end, format);
		return srcDate.getTime() >= beginDate.getTime() && srcDate.getTime() <= endDate.getTime();
	}
	
}
