package cd.precheck.service;

import org.apache.log4j.Logger;
import cd.util.check.ReflectCheck;

/**
 * 用于确认 8.3 综合指标二 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_2g_8_3_service_pre {
	
	private static Logger log = Logger.getLogger(M_2g_8_3_service_pre.class);
	
	public boolean precheck(String time){

		boolean flag = false;

		ReflectCheck rc = new ReflectCheck();
		//检测当前存储过程是否能运行
		flag =rc.check("cd.precheck.sql.M_2g_8_3_sql_pre", time, "前置依赖:");
		//只是显示当前存储过程的执行状态
		rc.check("cd.check.sql.M_2g_8_3_sql", time, "当前状态:");

		return flag;
	}
	
	public static void main(String[] args) {
		String time = "201108";
		boolean result = false;

		M_2g_8_3_service_pre _2g83 = new M_2g_8_3_service_pre();
		result = _2g83.precheck(time);
		log.warn(result);
	}
}
