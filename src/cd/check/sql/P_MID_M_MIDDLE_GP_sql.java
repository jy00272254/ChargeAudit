package cd.check.sql;

public class P_MID_M_MIDDLE_GP_sql {

	private static final String headMID = "SELECT * FROM MID.MID_T_LOG WHERE UPPER(PROCNAME) = '";
	private static final String tail = "' AND LOGDATE=?";

	// 3g 8.2 综合指标快报一
	public static final String P_MID_M_3G_WIRELESS_INDEX_PROCNAME = "MID.P_MID_M_MIDDLE_GP";
	public static final String P_MID_M_3G_WIRELESS_INDEX = headMID + "MID.P_MID_M_MIDDLE_GP" + tail;

}
