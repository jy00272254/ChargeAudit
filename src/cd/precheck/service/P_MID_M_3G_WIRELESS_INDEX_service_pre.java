package cd.precheck.service;

import org.apache.log4j.Logger;
import cd.util.check.ReflectCheck;

public class P_MID_M_3G_WIRELESS_INDEX_service_pre {
	
	private static Logger log = Logger.getLogger(P_MID_M_3G_WIRELESS_INDEX_service_pre.class);
	
	public boolean precheck(String time){

		boolean flag = false;

		ReflectCheck rc = new ReflectCheck();
		//检测当前存储过程是否能运行
		flag =rc.check("cd.precheck.sql.P_MID_M_3G_WIRELESS_INDEX_pre", time, "前置依赖:");
		//只是显示当前存储过程的执行状态
		rc.check("cd.check.sql.P_MID_M_3G_WIRELESS_INDEX_sql", time, "当前状态:");

		return flag;
	}
	
	public static void main(String[] args) {
		P_MID_M_3G_WIRELESS_INDEX_service_pre _3g82 = new P_MID_M_3G_WIRELESS_INDEX_service_pre();
		boolean result = _3g82.precheck("201108");
		log.warn(result);
	}
}
