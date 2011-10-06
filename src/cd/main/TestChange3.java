package cd.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cd.db2.DB2Factory;
import cd.util.time.GetTime;
import cd.util.time.TimeFormat;

/**
 * 调整 REPORT.REPORT_D_ZB_DEV_3G_01_02 onnet_users	网上用户
 * 
 *当日网上用户=前一日网上用户+当日净增用户（净增用户=3G发展用户-3G离网用户+2G转3G用户-3G转2G用户）
 * @author Administrator
 *
 */
public class TestChange3 {

	public static void main(String[] args) {
		String querySql = 
			"SELECT " +
				"a.city_no a_city_no," +
				"a.dinner_type a_dinner_type," +
				"(a.onnet_users+b.incr_user) a_onnet_users," +
				"b.city_no b_city_no," +
				"b.dinner_type b_dinner_type," +
				"b.onnet_users b_onnet_users " +
			"FROM " +
				"(SELECT day_no,city_no,onnet_users,dinner_type " +
				"FROM REPORT.REPORT_D_ZB_DEV_3G_01_02 " +
				"WHERE day_no=? ) a " +
			"INNER JOIN " +
				"(SELECT day_no,city_no,onnet_users," +
					"(mon_new_users-outnet_users+user_2g_3g-user_3g_2g) incr_user,dinner_type " +
				"FROM REPORT.REPORT_D_ZB_DEV_3G_01_02 " +
				"WHERE day_no=?) b " +
			"ON a.dinner_type=b.dinner_type AND a.city_no=b.city_no " +
			"WHERE a.onnet_users+b.incr_user<>b.onnet_users";
		
		String updateSql = 
			"UPDATE REPORT.REPORT_D_ZB_DEV_3G_01_02  " +
			"SET onnet_users=? " +
			"WHERE day_no = ? AND dinner_type = ? and city_no = ?";
		
		List<String> times = GetTime.fromTo("20110903", "20110924", TimeFormat.DAY);
		
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
								+ rs.getString("a_onnet_users") + " -- "
								+ rs.getString("b_city_no") + " -- "
								+ rs.getString("b_dinner_type") + " -- " 
								+ rs.getString("b_onnet_users"));
						
						ps =  conn.prepareStatement(updateSql);
						ps.setInt(1, Integer.valueOf(rs.getString("a_onnet_users")));
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
