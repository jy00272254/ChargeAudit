package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.M_3g_7_2_1_5_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * ����ȷ�� 7.2.1.5 ����������ҵ�� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_1_5_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_2_1_5_service.class);
	
	public boolean precheck(String time){
	
		// 7.2.1.5 ���������� P_MID_M_3G_WIRELESS_INDEX
		P_MID_M_3G_WIRELESS_INDEX_service p = new P_MID_M_3G_WIRELESS_INDEX_service();
		if(!p.precheck(time)){
			return false;
		}
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_2_1_5_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_2_1_5_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_2_1_5_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_03;
		boolean flag3 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_2_1_5_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_05_XX_04;
		boolean flag4 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag4 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 && flag3 && flag4;
		if(flag)
			log.warn(" 7.2.1.5 ����������ҵ�� REPORT.P_ZB_DEV_M_3G_05_02/03/05/06/09/11/13/15 [��]������������!");
		else
			log.warn(" 7.2.1.5 ����������ҵ�� REPORT.P_ZB_DEV_M_3G_05_02/03/05/06/09/11/13/15 [��]������������!");
		
		return flag;
	}
}
