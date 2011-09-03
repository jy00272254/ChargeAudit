package cd.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 产生调用语句,主要用来出账时候用,生成多个调用
 * @author Administrator
 *
 */
public class GenCallMulti {

	public static void main(String[] args) {
		//开始日期
		String begin = "201108";
		//结束日期
		String end = "201108";
		//日期类型 年 y 月 m 日 d
		String type = "m";
		
		_2gZB(begin, end, type);
		_3gZB(begin, end, type);
		_ZX(begin, end, type);
		_3gMX(begin, end, type);
	}
	
	// 2g 指标上传
	private static void _2gZB(String begin, String end, String type){
		//7.6.2 渠道类综合统计
		System.out.println("7.6.2 渠道类综合统计");
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_CHANNEL_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_CHANNEL_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_CHANNEL_04", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_CHANNEL_05", type);
		//2g 8.2 综合指标一
		System.out.println("8.2 综合指标一");
		sysoutCall(begin, end, "REPORT.P_ZB_M_ZH_02", type);
		//2g 8.3 综合指标二 
		System.out.println("8.3 综合指标二 ");
		sysoutCall(begin, end, "REPORT.P_ZB_ZH_M_ZH_06", type);
	}
	
	//3g 指标上传
	private static void _3gZB(String begin, String end, String type){
		//7.2.1.5 无线上网卡业务
		System.out.println("7.2.1.5 无线上网卡业务");
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_05", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_06", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_09", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_11", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_13", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_05_15", type);
		// 7.2.1.6 定制专用无线上网卡发展月报
		System.out.println("7.2.1.6 定制专用无线上网卡发展月报");
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_14_02", type);
		//7.2.3.1 渠道发展类统计
		System.out.println("7.2.3.1 渠道发展类统计");
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_09_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_09_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_DEV_M_3G_09_04", type);
		// 7.3.1.4 无线上网卡业务量月报
		System.out.println("7.3.1.4 无线上网卡业务量月报");
		sysoutCall(begin, end, "REPORT.P_ZB_USE_M_3G_04_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_USE_M_3G_04_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_USE_M_3G_04_07", type);
		//7.3.1.5 定制专用无线上网卡业务量月报
		System.out.println("7.3.1.5 定制专用无线上网卡业务量月报");
		sysoutCall(begin, end, "REPORT.P_ZB_USE_M_3G_WIRLESS_05_02", type);
		//7.4.1.4 无线上网卡收入
		System.out.println("7.4.1.4 无线上网卡收入");
		sysoutCall(begin, end, "REPORT.P_ZB_INCO_M_3G_04_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_INCO_M_3G_04_08", type);
		//7.5.1.3 渠道类综合月报
		System.out.println("7.5.1.3 渠道类综合月报");
		sysoutCall(begin, end, "REPORT.P_ZB_M_3G_CHANNEL_ZH", type);
		//7.5.1.4 渠道数量类月报
		System.out.println("7.5.1.4 渠道数量类月报");
		sysoutCall(begin, end, "REPORT.P_ZB_M_3G_CHANNEL_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_M_3G_CHANNEL_03", type);
		sysoutCall(begin, end, "REPORT.P_ZB_M_3G_CHANNEL_04", type);
		sysoutCall(begin, end, "REPORT.P_ZB_M_3G_CHANNEL_05", type);
		//7.5.1.5 渠道终端类月报
		System.out.println("7.5.1.5 渠道终端类月报");
		sysoutCall(begin, end, "REPORT.P_ZB_CHANNEL_M_3G_05_02", type);
		//7.5.1.6 渠道佣金类月报
		System.out.println("7.5.1.6 渠道佣金类月报");
		sysoutCall(begin, end, "REPORT.P_ZB_CHANNEL_M_3G_06_02", type);
		// 3g 8.2 综合指标快报一
		System.out.println("8.2 综合指标快报一");
		sysoutCall(begin, end, "REPORT.P_ZB_M_ZH_3G_02", type);
		sysoutCall(begin, end, "REPORT.P_ZB_M_ZH_3G_03", type);
	}
	
	//纵向数据接口
	private static void _ZX(String begin, String end, String type){
		//4.1.1.1 客户
		System.out.println("4.1.1.1 客户");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL01001", type);
		//4.1.1.2 组织客户
		System.out.println("4.1.1.2 组织客户");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL01002", type);
		//4.1.1.3 个人客户
		System.out.println("4.1.1.3 个人客户");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL01003", type);
		//4.1.1.6 客户证件信息
		System.out.println("4.1.1.6 客户证件信息");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL01006", type);
		//4.3.1.1 渠道信息
		System.out.println("4.3.1.1 渠道信息");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL03001", type);
		//4.3.1.2 渠道佣金
		System.out.println("4.3.1.2 渠道佣金");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL03002", type);
		//4.8.1.1 号码资源表
		System.out.println("4.8.1.1 号码资源表");
		sysoutCall(begin, end, "REPORT.P_ZB_M_BIDWAL08001", type);
	}
	
	//3G核心明细数据
	private static void _3gMX(String begin, String end, String type){
		//3.1.3.1. 渠道信息表
		System.out.println("3.1.3.1. 渠道信息表");
		sysoutCall(begin, end, "REPORT.P_REPORT_M_3G_USER_CHANNEL", type);
		//3.4.1. 扇区信息
		System.out.println("3.4.1. 扇区信息");
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
