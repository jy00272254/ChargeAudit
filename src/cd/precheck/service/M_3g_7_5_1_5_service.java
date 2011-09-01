package cd.precheck.service;

import java.sql.Connection;
import org.apache.log4j.Logger;

import cd.db2.DB2Factory;
import cd.precheck.sql.M_3g_7_5_1_5_sql;
import cd.util.check.LogCheck;
import cd.util.time.TimeFormat;

/**
 * 
 * У��ù�������Ϊ�ù������к�������� 7.5.1.6 ����.���Ǳ���ù��̲���Ҫ�Ҹ���.
 * ����ȷ�� 7.5.1.5 �����ն����±� �洢�����Ƿ��������.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_5_service {
	
	private static Logger log = Logger.getLogger(M_3g_7_5_1_5_service.class);
	
	public boolean precheck(String time){
		
		boolean flag3 = false;
		//�ù��̱���ǰ�ù��� 7.5.1.3 ���к��������
		M_3g_7_5_1_3_service _7513 = new M_3g_7_5_1_3_service();
		flag3 = _7513.precheck(time);
		
		Connection conn = DB2Factory.getConn();
		if(conn == null)
			return false;
		
		LogCheck pm = new LogCheck();
		
		String sql = M_3g_7_5_1_5_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_05_02_01;
		boolean flag1 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag1 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		sql = M_3g_7_5_1_5_sql.PRECHECK_REPORT_P_ZB_CHANNEL_M_3G_05_02_02;
		boolean flag2 = pm.check_success(conn, TimeFormat.MONTH, time, sql);
		log.info((flag2 ? "ͨ��" : "δͨ��")	+" -- " + sql);
		
		DB2Factory.closeConn(conn);
		
		boolean flag = flag1 && flag2 && flag3;
		if(flag)
			log.warn(" 7.5.1.5 �����ն����±� REPORT.P_ZB_CHANNEL_M_3G_05_02 [��]������������!");
		else
			log.warn(" 7.5.1.5 �����ն����±� REPORT.P_ZB_CHANNEL_M_3G_05_02 [��]������������!");
		
		return flag;
	}
}
