package cd.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * �����������,��Ҫ��������ʱ����,���ɶ������
 * @author Administrator
 *
 */
public class GenCallMulti {

	public static void main(String[] args) {
		//��ʼ����
		String begin = "201108";
		//��������
		String end = "201108";
		//�������� �� y �� m �� d
		String type = "m";
		
		_2gZB(begin, end, type);
		_3gZB(begin, end, type);
		_ZX(begin, end, type);
		_3gMX(begin, end, type);
	}
	
	// 2g ָ���ϴ�
	private static void _2gZB(String begin, String end, String type){
		//7.6.2 �������ۺ�ͳ��
		System.out.println("7.6.2 �������ۺ�ͳ��");
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_CHANNEL_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_CHANNEL_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_CHANNEL_04", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_CHANNEL_05", type);
		//2g 8.2 �ۺ�ָ��һ
		System.out.println("8.2 �ۺ�ָ��һ");
		sysoutCall(begin, end, "REPORT.P_ZB_M_ZH_02", type);
		//2g 8.3 �ۺ�ָ��� 
		System.out.println("8.3 �ۺ�ָ��� ");
		sysoutCall(begin, end, "REPORT.P_ZB_ZH_M_ZH_06", type);
	}
	
	//3g ָ���ϴ�
	private static void _3gZB(String begin, String end, String type){
		//7.2.1.5 ����������ҵ��
		System.out.println("7.2.1.5 ����������ҵ��");
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_05", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_06", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_09", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_11", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_13", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_15", type);
		// 7.2.1.6 ����ר��������������չ�±�
		System.out.println("7.2.1.6 ����ר��������������չ�±�");
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_14_02", type);
		//7.2.3.1 ������չ��ͳ��
		System.out.println("7.2.3.1 ������չ��ͳ��");
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_09_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_09_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_09_04", type);
		// 7.3.1.4 ����������ҵ�����±�
		System.out.println("7.3.1.4 ����������ҵ�����±�");
		sysoutCall(begin, end, "REPORT.P_ZB_USE_M_3G_04_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_USE_M_3G_04_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_USE_M_3G_04_07", type);
		//7.3.1.5 ����ר������������ҵ�����±�
		System.out.println("7.3.1.5 ����ר������������ҵ�����±�");
		sysoutCall(begin, end, "REPORT.P_ZB_USE_M_3G_WIRLESS_05_02", type);
		//7.4.1.4 ��������������
		System.out.println("7.4.1.4 ��������������");
		sysoutCall(begin, end, "REPORT.P_ZB_INCO_M_3G_04_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_INCO_M_3G_04_08", type);
		//7.5.1.3 �������ۺ��±�
		System.out.println("7.5.1.3 �������ۺ��±�");
		sysoutCall(begin, end, "REPORT.P_ZB_M_3G_CHANNEL_ZH", type);
		//7.5.1.4 �����������±�
		System.out.println("7.5.1.4 �����������±�");
		sysoutCall(begin, end, "REPORT.P_ZB_M_3G_CHANNEL_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_M_3G_CHANNEL_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_M_3G_CHANNEL_04", type);
		sysoutCall(begin, end, "REPORT.P_ZB_M_3G_CHANNEL_05", type);
		//7.5.1.5 �����ն����±�
		System.out.println("7.5.1.5 �����ն����±�");
		sysoutCall(begin, end, "REPORT.P_ZB_CHANNEL_M_3G_05_02", type);
		//7.5.1.6 ����Ӷ�����±�
		System.out.println("7.5.1.6 ����Ӷ�����±�");
		sysoutCall(begin, end, "REPORT.P_ZB_CHANNEL_M_3G_06_02", type);
		// 3g 8.2 �ۺ�ָ��챨һ
		System.out.println("8.2 �ۺ�ָ��챨һ");
		sysoutCall(begin, end, "REPORT.P_ZB_M_ZH_3G_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_M_ZH_3G_03", type);
	}
	
	//�������ݽӿ�
	private static void _ZX(String begin, String end, String type){
		//4.1.1.1 �ͻ�
		System.out.println("4.1.1.1 �ͻ�");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL01001", type);
		//4.1.1.2 ��֯�ͻ�
		System.out.println("4.1.1.2 ��֯�ͻ�");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL01002", type);
		//4.1.1.3 ���˿ͻ�
		System.out.println("4.1.1.3 ���˿ͻ�");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL01003", type);
		//4.1.1.6 �ͻ�֤����Ϣ
		System.out.println("4.1.1.6 �ͻ�֤����Ϣ");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL01006", type);
		//4.3.1.1 ������Ϣ
		System.out.println("4.3.1.1 ������Ϣ");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL03001", type);
		//4.3.1.2 ����Ӷ��
		System.out.println("4.3.1.2 ����Ӷ��");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL03002", type);
		//4.8.1.1 ������Դ��
		System.out.println("4.8.1.1 ������Դ��");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL08001", type);
	}
	
	//3G������ϸ����
	private static void _3gMX(String begin, String end, String type){
		//3.1.3.1. ������Ϣ��
		System.out.println("3.1.3.1. ������Ϣ��");
		sysoutCall(begin, end, "REPORT.P_REPORT_M_3G_USER_CHANNEL", type);
		//3.4.1. ������Ϣ
		System.out.println("3.4.1. ������Ϣ");
		sysoutCall(begin, end, "REPORT.P_REPORT_M_3G_USER_CELL", type);
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
			System.out.println("CALL " + procname + "('"+ sdf.format(new Date(beginC.getTimeInMillis())) +"');");
			beginC.set(cFormat, beginC.get(cFormat)+1);
		}
	}
	
	private static Calendar getCalendar(String date, String type){
		int year = getYear(date);
		int month  = 1;
		if("M".equals(type.toUpperCase())
				|| "D".equals(type.toUpperCase())){
			month = getMonth(date);
		}
		int day =  1;
		if("D".equals(type.toUpperCase())){
			day = getDay(date);
		}
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
