package cd.precheck.service;

import org.apache.log4j.Logger;

import cd.precheck.sql.M_3g_7_3_1_4_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * ����ȷ�� 7.3.1.4 ����������ҵ�����±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_3_1_4_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_3_1_4_service.class);
	
	public boolean precheck(String time){
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_3_1_4_sql.PRECHECK_REPORT_P_ZB_USE_M_3G_04_XX_01;
		boolean flag1 = pm.check_success( TimeFormat.DAY, null, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_3_1_4_sql.PRECHECK_REPORT_P_ZB_USE_M_3G_04_XX_02;
		boolean flag2 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_3_1_4_sql.PRECHECK_REPORT_P_ZB_USE_M_3G_04_XX_03;
		boolean flag3 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		boolean flag = flag1 && flag2 && flag3;
		if(flag)
			log.warn(" 7.3.1.4 ����������ҵ�����±� REPORT.P_ZB_USE_M_3G_04_02/3/7 [��]������������!");
		else
			log.warn(" 7.3.1.4 ����������ҵ�����±� REPORT.P_ZB_USE_M_3G_04_02/3/7 [��]������������!");
		
		return flag;
	}
	
	public static void main(String[] args) {
		M_3g_7_3_1_4_service _7314 = new M_3g_7_3_1_4_service();
		boolean result = _7314.precheck("201108");
		log.warn(result);
	}
}
