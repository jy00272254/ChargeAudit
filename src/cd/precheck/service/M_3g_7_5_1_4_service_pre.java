package cd.precheck.service;

import org.apache.log4j.Logger;
import cd.util.check.ReflectCheck;

/**
 * 用于确认 7.5.1.4 渠道数量类月报 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_5_1_4_service_pre {
	
	private static Logger log = Logger.getLogger(M_3g_7_5_1_4_service_pre.class);
	
	public boolean precheck(String time){

		boolean flag = false;

		ReflectCheck rc = new ReflectCheck();
		//检测当前存储过程是否能运行
		flag =rc.check("cd.precheck.sql.M_3g_7_5_1_4_sql_pre", time, "前置依赖:");
		//只是显示当前存储过程的执行状态
		rc.check("cd.check.sql.M_3g_7_5_1_4_sql", time, "当前状态:");

		return flag;
	}
	
	public static void main(String[] args) {
		M_3g_7_5_1_4_service_pre _7514 = new M_3g_7_5_1_4_service_pre();
		boolean result = _7514.precheck("201108");
		log.warn(result);
	}
}
