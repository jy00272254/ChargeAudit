package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.check.service.Check_Service;
import cd.check.service.ProcId;
import cd.db2.DB2Factory;
import cd.precheck.sql.M_3g_7_2_3_1_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * ����ȷ�� 7.2.3.1 ������չ��ͳ�� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_3_1_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_2_3_1_service.class);
	
	public boolean precheck(String time){
	
		// 7.2.3.1  ���������� P_MID_M_3G_WIRELESS_INDEX
		Check_Service cs = new Check_Service();
		int statusId = cs.checkSingle(ProcId.P_MID_M_3G_WIRELESS_INDEX, TimeFormat.MONTH, time);
		if(statusId != 1){
			log.warn(" 7.2.3.1 ������չ��ͳ�� REPORT.ZB_DEV_M_3G_09_XX [��]������������!");
			log.warn("		ԭ��:MID.P_MID_M_3G_WIRELESS_INDEX " + LogCheck.getStatus(statusId));
			return false;
		}
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_2_3_1_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_09_XX_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_2_3_1_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_09_XX_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_2_3_1_sql.PRECHECK_REPORT_P_ZB_DEV_M_3G_09_XX_03;
		boolean flag3 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag3 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 && flag3 ;
		if(flag)
			log.warn(" 7.2.3.1 ������չ��ͳ�� REPORT.ZB_DEV_M_3G_09_XX [��]������������!");
		else
			log.warn(" 7.2.3.1 ������չ��ͳ�� REPORT.ZB_DEV_M_3G_09_XX [��]������������!");
		
		return flag;
	}
	
	public static void main(String[] args) {
		M_3g_7_2_3_1_service _7231 = new M_3g_7_2_3_1_service();
		boolean result = _7231.precheck("201108");
		log.warn(result);
	}
}
