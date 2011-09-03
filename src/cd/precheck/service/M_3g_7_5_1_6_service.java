package cd.precheck.service;

import org.apache.log4j.Logger;

import cd.check.service.Check_Service;
import cd.check.service.ProcId;
import cd.precheck.sql.M_3g_7_5_1_6_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * ����ȷ�� 7.5.1.6 ����Ӷ�����±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_6_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_5_1_6_service.class);
	
	public boolean precheck(String time){
		
		//�ù��̱���ǰ�ù��� 7.5.1.5 ���к��������
		Check_Service cs = new Check_Service();
		int statusId = cs.checkSingle(ProcId.M_3g_7_5_1_5, TimeFormat.MONTH, time);
		if(statusId != 1){
			log.warn(" 7.5.1.6 ����Ӷ�����±� REPORT.P_ZB_CHANNEL_M_3G_06_02 [��]������������!");
			log.warn("		ԭ��:7.5.1.5 REPORT.P_ZB_CHANNEL_M_3G_05_02 " + LogCheck.getStatus(statusId));
			return false;
		}
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_5_1_6_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_06_02_01;
		boolean flag1 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_6_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_06_02_02;
		boolean flag2 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_6_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_06_02_03;
		boolean flag4 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag4 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_6_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_06_02_04;
		boolean flag5 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag5 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_6_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_06_02_05;
		boolean flag6 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag6 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_6_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_06_02_06;
		boolean flag7 = pm.check_success( TimeFormat.MONTH, time, sql);
		log.info((flag7 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		boolean flag = flag1 && flag2 && flag4 && flag5 && flag6 && flag7;
		if(flag)
			log.warn(" 7.5.1.6 ����Ӷ�����±� REPORT.P_ZB_CHANNEL_M_3G_06_02 [��]������������!");
		else
			log.warn(" 7.5.1.6 ����Ӷ�����±� REPORT.P_ZB_CHANNEL_M_3G_06_02 [��]������������!");
		
		return flag;
	}
	
	public static void main(String[] args) {
		M_3g_7_5_1_6_service _7516 = new M_3g_7_5_1_6_service();
		boolean result = _7516.precheck("201108");
		log.warn(result);
	}
}
