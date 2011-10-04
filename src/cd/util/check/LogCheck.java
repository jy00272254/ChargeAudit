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
	 * 检测日志过程的运行情况
	 * 	-1	执行失败
	 * 	0	未执行
	 * 	1	执行成功
	 * 	1	正在执行中
	 * @param timeFormat
	 * @param time
	 * @param sql
	 * @return
	 */
	public int check(String timeFormat, String time, String sql) {
		
		Connection conn = DB2Factory.getConn();
		
		P_Log p_log = get_P_Log(conn, timeFormat, time, sql);
		log.info(sql);
		log.info("查询到的日志内容为: " + p_log);
		int result = check_P_log(p_log);
		switch(result){
		case -1: log.info("执行失败");break;
		case 0 : log.info("未执行");break;
		case 1: log.info("执行成功");break;
		case 2 : log.info("正在执行中");break;
		default : log.info("未知状态"); break;
		}
		
		DB2Factory.closeConn(conn);
		
		return result;
	}
	
	/**
	 * 获取开始时间
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
	 * 获取结束时间
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
	 * 取得过程的平均运行时间
	 * @param timeFormat
	 * @param time
	 * @param sql
	 * @return
	 */
	public int avgDuration(String timeFormat, String time, String sql){
		Connection conn = DB2Factory.getConn();
		
		// 设定获取当前时间前5条记录的平均时间
		int area = -5;
		// 若格式为日,则将时间设定为昨天
		if(TimeFormat.MONTH.equals(timeFormat)){
			
		}else{
			time = GetTime.yesterday();
		}
		// 获取范围内时间
		List<String> areaTimes = GetTime.fromTo(time, area, timeFormat);
		// 获取日志列表
		List<P_Log> p_logs = new ArrayList<P_Log>();
		for(String areaTime : areaTimes){
			P_Log p_log = get_P_Log(conn, timeFormat, areaTime, sql);
			if(p_log != null)
				p_logs.add(p_log);
		}
		log.info(sql);
		// 生效的时间数量
		int length = 0;
		// 总时间
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
	 * 判断存储过程是否运行成功
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
	 * 从数据库中取出对应的日志记录
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
	 * 通过日志判断是否执行过
	 * @param p_log
	 * @return
	 * 		-1		 执行失败
	 * 		0		未执行
	 * 		1		执行成功
	 * 		2		正在执行中
	 */
	private int check_P_log(P_Log p_log) {
		int result = 0;
		if (p_log == null){
			//未执行,未查到记录
			result = 0;
		} else if(p_log.getFlag().toUpperCase().contains("RUNNING")){
			//正在执行中
			result = 2;
		} else if (p_log.getFlag().toUpperCase().contains("SUCCESS") 
						|| p_log.getNote().contains("执行成功")) {
			//执行成功
			result = 1;
		} else if(p_log.getFlag().toUpperCase().contains("FAIL")){
			//执行失败
			result = -1;
		} 
		return result;
	}
	
	/**
	 * 通过状态ID判断状态情况
	 * @param statusId
	 * @return
	 */
	public static String getStatus(int statusId){
		String result = null;
		switch(statusId){
		case -1	:	 result = "执行失败"; break;
		case 0	:	 result = "未执行"; break;
		case 1	:	 result = "执行成功"; break;
		case 2	:	 result = "正在执行中"; break;
		default : result = "未知状态";break;
		}
		return result;
	}
}
