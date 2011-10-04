package cd.util.check;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cd.bean.P_Log;
import cd.db2.DB2Factory;
import cd.util.time.FormatTime;
import cd.util.time.GetTime;
import cd.util.time.TimeFormat;

public class LogCheck {

	private static Logger log = Logger.getLogger(LogCheck.class);
	
	/**
	 * �����־���̵��������
	 * 	-1	ִ��ʧ��
	 * 	0	δִ��
	 * 	1	ִ�гɹ�
	 * 	1	����ִ����
	 * @param timeFormat
	 * @param time
	 * @param sql
	 * @return
	 */
	public int check(String timeFormat, String time, String sql) {
		
		Connection conn = DB2Factory.getConn();
		
		P_Log p_log = get_P_Log(conn, timeFormat, time, sql);
		log.info(sql);
		log.info("��ѯ������־����Ϊ: " + p_log);
		int result = check_P_log(p_log);
		switch(result){
		case -1: log.info("ִ��ʧ��");break;
		case 0 : log.info("δִ��");break;
		case 1: log.info("ִ�гɹ�");break;
		case 2 : log.info("����ִ����");break;
		default : log.info("δ֪״̬"); break;
		}
		
		DB2Factory.closeConn(conn);
		
		return result;
	}
	
	/**
	 * ��ȡ��ʼʱ��
	 * @param timeFormat
	 * @param time
	 * @param sql
	 * @return
	 */
	public String begin_time(String timeFormat, String time, String sql){
		Connection conn = DB2Factory.getConn();
		P_Log p_log = get_P_Log(conn, timeFormat, time, sql);
		DB2Factory.closeConn(conn);
		String result = null; 
		if( p_log != null && p_log.getBEGIN_DATE() != null){
			result = FormatTime.format(p_log.getBEGIN_DATE(), TimeFormat.SSFORMAT);
		}
		return result;
	}
	
	/**
	 * ��ȡ����ʱ��
	 * @param timeFormat
	 * @param time
	 * @param sql
	 * @return
	 */
	public String end_time(String timeFormat, String time, String sql){
		Connection conn = DB2Factory.getConn();
		P_Log p_log = get_P_Log(conn, timeFormat, time, sql);
		DB2Factory.closeConn(conn);
		String result = null; 
		if(  p_log != null && p_log.getEND_DATE() != null){
			result = FormatTime.format(p_log.getEND_DATE(), TimeFormat.SSFORMAT);
		}
		return result;
	}
	
	/**
	 * ȡ�ù��̵�ƽ������ʱ��
	 * @param timeFormat
	 * @param time
	 * @param sql
	 * @return
	 */
	public int avgDuration(String timeFormat, String time, String sql){
		Connection conn = DB2Factory.getConn();
		
		// �趨��ȡ��ǰʱ��ǰ5����¼��ƽ��ʱ��
		int area = -5;
		// ����ʽΪ��,��ʱ���趨Ϊ����
		if(TimeFormat.MONTH.equals(timeFormat)){
			
		}else{
			time = GetTime.yesterday();
		}
		// ��ȡ��Χ��ʱ��
		List<String> areaTimes = GetTime.fromTo(time, area, timeFormat);
		// ��ȡ��־�б�
		List<P_Log> p_logs = new ArrayList<P_Log>();
		for(String areaTime : areaTimes){
			P_Log p_log = get_P_Log(conn, timeFormat, areaTime, sql);
			if(p_log != null)
				p_logs.add(p_log);
		}
		log.info(sql);
		// ��Ч��ʱ������
		int length = 0;
		// ��ʱ��
		int totalTime = 0;
		for(P_Log p_log : p_logs){
			if(p_log.getDuration() != null){
				totalTime += Integer.valueOf(p_log.getDuration());
				length ++;
			}
		}
		DB2Factory.closeConn(conn);
		
		return totalTime/length;
	}
	
	/**
	 * �жϴ洢�����Ƿ����гɹ�
	 * @param conn
	 * @param timeFormat
	 * @param time
	 * @param sql
	 * @return
	 */
	public boolean check_success(String timeFormat, String time, String sql) {
		return check(timeFormat, time, sql) == 1;
	}

	/**
	 * �����ݿ���ȡ����Ӧ����־��¼
	 * @param conn
	 * @param timeFormat
	 * @param time
	 * @param sql
	 * @return
	 */
	private P_Log get_P_Log(Connection conn, String timeFormat, String time,
			String sql) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		P_Log p_log = null;
		try {
			ps = conn.prepareStatement(sql);
			if (timeFormat == null || timeFormat.equals(TimeFormat.MONTH))
				ps.setString(1, time);
			else if (timeFormat.equals(TimeFormat.DAY))
				ps.setString(1, GetTime.yesterday());

			rs = ps.executeQuery();

			if (rs.next()) {
				p_log = new P_Log();
				p_log.setLogDate(rs.getString("LOGDATE"));
				p_log.setProcname(rs.getString("PROCNAME"));
				p_log.setBEGIN_DATE(rs.getDate("BEGIN_DATE"));
				p_log.setEND_DATE(rs.getDate("END_DATE"));
				p_log.setFlag(rs.getString("FLAG"));
				p_log.setDuration(rs.getInt("DURATION"));
				p_log.setNote(rs.getString("NOTE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p_log;
	}

	/**
	 * ͨ����־�ж��Ƿ�ִ�й�
	 * @param p_log
	 * @return
	 * 		-1		 ִ��ʧ��
	 * 		0		δִ��
	 * 		1		ִ�гɹ�
	 * 		2		����ִ����
	 */
	private int check_P_log(P_Log p_log) {
		int result = 0;
		if (p_log == null){
			//δִ��,δ�鵽��¼
			result = 0;
		} else if(p_log.getFlag().toUpperCase().contains("RUNNING")){
			//����ִ����
			result = 2;
		} else if (p_log.getFlag().toUpperCase().contains("SUCCESS") 
						|| p_log.getNote().contains("ִ�гɹ�")) {
			//ִ�гɹ�
			result = 1;
		} else if(p_log.getFlag().toUpperCase().contains("FAIL")){
			//ִ��ʧ��
			result = -1;
		} 
		return result;
	}
	
	/**
	 * ͨ��״̬ID�ж�״̬���
	 * @param statusId
	 * @return
	 */
	public static String getStatus(int statusId){
		String result = null;
		switch(statusId){
		case -1	:	 result = "ִ��ʧ��"; break;
		case 0	:	 result = "δִ��"; break;
		case 1	:	 result = "ִ�гɹ�"; break;
		case 2	:	 result = "����ִ����"; break;
		default : result = "δ֪״̬";break;
		}
		return result;
	}
}
