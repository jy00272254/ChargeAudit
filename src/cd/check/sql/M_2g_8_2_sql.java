package cd.check.sql;

public class M_2g_8_2_sql {
	
	private static final String headREPORT = "SELECT * FROM REPORT.REPORT_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";
	
	//2g 8.2 综合指标一
	public static final String M_2g_8_2_PROCNAME = "REPORT.P_ZB_M_ZH_02";
	public static final String M_2g_8_2 = headREPORT + "REPORT.P_ZB_M_ZH_02" + tail;
	
}
