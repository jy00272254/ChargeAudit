package cd.main.adjust;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cd.db2.DB2Factory;
import cd.util.time.GetTime;
import cd.util.time.TimeFormat;

/**
 * 调整 REPORT.REPORT_D_ZB_DEV_3G_01_02 total_call_users	累计通话用户
 * 
 * 累计通话用户>=通话用户数
 * 当月1日的累计通话用户=通话用户
 * 当月1日后的累计通话用户>=前一日累计
 * @author Administrator
 *
 */
public class TestChange1 {

	public static void main(String[] args) {
		String querySql = 
			"SELECT " +
				"a.city_no a_city_no," +
				"a.dinner_type a_dinner_type, " +
				"a.total_call_users a_total_call_users," +
				"b.city_no b_city_no," +
				"b.dinner_type b_dinner_type, " +
				"b.total_call_users b_total_call_users " +
			"FROM 	" +
			"(SELECT city_no,dinner_type,total_call_users " +
			"FROM REPORT.REPORT_D_ZB_DEV_3G_01_02 	" +
			"WHERE day_no = ?) a " +
			"INNER JOIN " +
			"(SELECT city_no,dinner_type,total_call_users " +
			"FROM REPORT.REPORT_D_ZB_DEV_3G_01_02 	" +
			"WHERE day_no = ?) b " +
			"ON a.dinner_type=b.dinner_type and a.city_no=b.city_no " +
			"WHERE a.total_call_users > b.total_call_users";
		
		String updateSql = 
			"UPDATE REPORT.REPORT_D_ZB_DEV_3G_01_02  " +
			"SET total_call_users=? " +
			"WHERE day_no = ? AND dinner_type = ? and city_no = ?";
		
		List<String> times = GetTime.fromTo("20110928", "20110930", TimeFormat.DAY);
		
		Connection conn = DB2Factory.getConn();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			for(String time : times){
				ps =  conn.prepareStatement(querySql);
				ps.setString(1, GetTime.fromTo(time, -2, TimeFormat.DAY).get(0));
				ps.setString(2, time);
				
				rs = ps.executeQuery();
				
				System.out.println("time : " + time);
				if(rs != null){
					while(rs.next()){
						System.out.println(
								time + " -- "
								+ rs.getString("a_city_no") + " -- "
								+ rs.getString("a_dinner_type") + " -- "
								+ rs.getString("a_total_call_users") + " -- "
								+ rs.getString("b_city_no") + " -- "
								+ rs.getString("b_dinner_type") + " -- " 
								+ rs.getString("b_total_call_users"));
						
						ps =  conn.prepareStatement(updateSql);
						ps.setInt(1, Integer.valueOf(rs.getString("a_total_call_users")));
						ps.setString(2, time);
						ps.setString(3, rs.getString("b_dinner_type"));
						ps.setString(4, rs.getString("b_city_no"));
						ps.executeUpdate();
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
				try {
					if(rs != null)
						rs.close();
					if(ps != null)
						ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		DB2Factory.closeConn(conn);
	}

}
