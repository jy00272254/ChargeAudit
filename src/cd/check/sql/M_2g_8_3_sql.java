package cd.check.sql;

public class M_2g_8_3_sql {
	
	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	//2g 8.3 综合指标二 
	public static final String M_2g_8_3_PROCNAME = "REPORT.P_ZB_ZH_M_ZH_06";
	public static final String M_2g_8_3 = headREPORT + "REPORT.P_ZB_ZH_M_ZH_06" + tail;
	
}
