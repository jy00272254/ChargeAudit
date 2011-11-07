package cd.main;

import org.junit.Test;

public class MainTest {

	@Test
	public void sql(){
		String querySql = 
			"SELECT ACCT_DAY,call_fee,incr_fee,rent_fee,call_fee+incr_fee+rent_fee LAST_JF_FEE,JF_FEE " +
			"FROM REPORT.REPORT_D_ZB_INCO_YY_BILL_TOT " +
			"WHERE ACCT_DAY = ?";
		String updateSql = 
			"update REPORT.REPORT_D_ZB_INCO_YY_BILL_TOT " + 
			"set call_fee=?,incr_fee=?,rent_fee=? " +
			"where acct_day = ? and call_fee=? and incr_fee=? and rent_fee=?";
		
		System.out.println(querySql);
		System.out.println(updateSql);
	}
}
