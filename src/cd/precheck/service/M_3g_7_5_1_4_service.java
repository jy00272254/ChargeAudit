package cd.precheck.service;

import org.apache.log4j.Logger;

import cd.precheck.sql.M_3g_7_5_1_4_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * ����ȷ�� 7.5.1.4 �����������±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_4_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_5_1_4_service.class);
	
	public boolean precheck(String time){
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_01;
		boolean flag1 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_02;
		boolean flag2 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_03;
		boolean flag3 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_04;
		boolean flag4 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag4 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_05;
		boolean flag5 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag5 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_4_sql.PRECHECK_REPORT_P_ZB_M_3G_CHANNEL_XX_06;
		boolean flag6 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag6 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		boolean flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6;
		
		if(flag)
			log.warn(" 7.5.1.4 �����������±� REPORT.P_ZB_M_3G_CHANNEL_02/03/04/05 [��]������������!");
		else
			log.warn(" 7.5.1.4 �����������±� REPORT.P_ZB_M_3G_CHANNEL_02/03/04/05 [��]������������!");
		
		return flag;
	}
}
