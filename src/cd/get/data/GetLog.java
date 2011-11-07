package cd.get.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cd.bean.P_Log;
import cd.util.time.GetTime;
import cd.util.time.TimeFormat;

public class GetLog {

	public List<P_Log> getLog(Connection conn, String timeFormat, String time, String sql) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<P_Log> p_log = null;
		try {
			ps = conn.prepareStatement(sql);
			if (timeFormat == null || timeFormat.equals(TimeFormat.MONTH))
				ps.setString(1, time);
			else if (timeFormat.equals(TimeFormat.DAY))
				ps.setString(1, GetTime.yesterday());

			rs = ps.executeQuery();

			p_log = new ArrayList<P_Log>();
			
			while (rs.next()) {
				P_Log subLog = new P_Log();
				subLog.setLogDate(rs.getString("LOGDATE"));
				subLog.setProcname(rs.getString("PROCNAME"));
				subLog.setBEGIN_DATE(rs.getDate("BEGIN_DATE"));
				subLog.setEND_DATE(rs.getDate("END_DATE"));
				subLog.setFlag(rs.getString("FLAG"));
				subLog.setDuration(rs.getInt("DURATION"));
				subLog.setNote(rs.getString("NOTE"));
				p_log.add(subLog);
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
}
