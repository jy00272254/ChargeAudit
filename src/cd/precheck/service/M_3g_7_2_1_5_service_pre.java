package cd.precheck.service;

import org.apache.log4j.Logger;
import cd.util.check.ReflectCheck;

/**
 * 用于确认 7.2.1.5 无线上网卡业务 存储过程是否可以运行.
 * 
 * @author Administrator
 * 
 */
public class M_3g_7_2_1_5_service_pre {

	private static Logger log = Logger.getLogger(M_3g_7_2_1_5_service_pre.class);

	public boolean precheck(String time) {

		boolean flag = false;

		ReflectCheck rc = new ReflectCheck();
		//检测当前存储过程是否能运行
		flag =rc.check("cd.precheck.sql.M_3g_7_2_1_5_sql_pre", time, "前置依赖:");
		//只是显示当前存储过程的执行状态
		rc.check("cd.check.sql.M_3g_7_2_1_5_sql", time, "当前状态:");

		return flag;
	}

	public static void main(String[] args) {
		String time = "201108";
		boolean result = false;

		M_3g_7_2_1_5_service_pre _7215 = new M_3g_7_2_1_5_service_pre();
		result = _7215.precheck(time);
		log.warn(result);
	}
}
