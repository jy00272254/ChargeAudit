package cd.util.check;

import org.junit.Test;

import cd.precheck.sql.M_3g_7_2_1_5_sql_pre;
import cd.util.time.TimeFormat;

public class LogCheckTest {

	@Test
	public void testAvgDuration(){
		LogCheck lc = new LogCheck();
		
		lc.avgDuration(TimeFormat.MONTH, "201109", M_3g_7_2_1_5_sql_pre.M_3g_7_2_1_5_02_PRE);
	}
}
