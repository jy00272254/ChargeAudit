package cd.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cd.bean.Income_2G;
import cd.db2.DB2Factory;

/**
 * !!!!!!!!! 25�ź��е���ά��,ע��
 * ����2G����
 * @author Administrator
 *
 */
public class TestChange {

	public static void main(String[] args) {
		String querySql = 
			"SELECT ACCT_DAY,call_fee,incr_fee,rent_fee,call_fee+incr_fee+rent_fee LAST_JF_FEE,JF_FEE " +
			"FROM REPORT.REPORT_D_ZB_INCO_YY_BILL_TOT " +
			"WHERE ACCT_DAY = ?";
		String updateSql = 
			"update REPORT.REPORT_D_ZB_INCO_YY_BILL_TOT " + 
			"set call_fee=?,incr_fee=?,rent_fee=? " +
			"where acct_day = ? and call_fee=? and incr_fee=? and rent_fee=?";
		String time = "20110908";
		double range = 300000;
		
		Connection conn = DB2Factory.getConn();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Income_2G> incomes = new ArrayList<Income_2G>();
		try {
			ps =  conn.prepareStatement(querySql);
			ps.setString(1, time);
			
			rs = ps.executeQuery();
			while(rs.next()){
				Income_2G income = new Income_2G();
				income.setAcct_day(rs.getString("ACCT_DAY"));
				income.setCall_fee(rs.getDouble("call_fee"));
				income.setIncr_fee(rs.getDouble("incr_fee"));
				income.setRent_fee(rs.getDouble("rent_fee"));
				income.setLast_jf_fee(rs.getDouble("LAST_JF_FEE"));
				income.setJf_fee(rs.getDouble("JF_FEE"));
				incomes.add(income);
			}
			
			double total_jf_fee = 0;
			for(Income_2G income : incomes){
				System.out.println(income);
				total_jf_fee += income.getLast_jf_fee();
			}
			
			for(Income_2G income : incomes){
				double percent = income.getLast_jf_fee()/total_jf_fee;
				double dataChange = percent * range;
				
				double percentCall_fee = income.getCall_fee()/income.getLast_jf_fee();
				int dataChangeCall_fee = (int) (percentCall_fee * dataChange);
				
				double percentIncr_fee = income.getIncr_fee()/income.getLast_jf_fee();
				int dataChangeIncr_fee = (int) (percentIncr_fee * dataChange);
				
				double percentRent_fee = income.getRent_fee()/income.getLast_jf_fee();
				int dataChangeRent_fee = (int) (percentRent_fee * dataChange);
				//				System.out.println(percent + " -- " + percentCall_fee + " -- " +percentIncr_fee + " -- " + percentRent_fee);
//				System.out.println(dataChange + " -- " + dataChangeCall_fee + " -- " +dataChangeIncr_fee + " -- " + dataChangeRent_fee);
				double call_fee = income.getCall_fee();
				double incr_fee = income.getIncr_fee();
				double rent_fee = income.getRent_fee();
				
				ps = conn.prepareStatement(updateSql);
				ps.setDouble(1, call_fee - dataChangeCall_fee);
				ps.setDouble(2, incr_fee - dataChangeIncr_fee);
				ps.setDouble(3, rent_fee - dataChangeRent_fee);
				ps.setString(4, time);
				ps.setDouble(5, call_fee);
				ps.setDouble(6, incr_fee);
				ps.setDouble(7, rent_fee);
				ps.executeUpdate();
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
