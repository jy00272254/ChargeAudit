package cd.main;

import org.apache.log4j.Logger;

import cd.precheck.service.M_2g_7_6_2_service;
import cd.precheck.service.M_2g_8_2_service;
import cd.precheck.service.M_2g_8_3_service;
import cd.precheck.service.M_3g_7_2_1_5_service_pre;
import cd.precheck.service.M_3g_7_2_1_6_service;
import cd.precheck.service.M_3g_7_2_3_1_service;
import cd.precheck.service.M_3g_7_3_1_4_service;
import cd.precheck.service.M_3g_7_3_1_5_service;
import cd.precheck.service.M_3g_7_4_1_4_service;
import cd.precheck.service.M_3g_7_5_1_3_service;
import cd.precheck.service.M_3g_7_5_1_4_service;
import cd.precheck.service.M_3g_7_5_1_5_service;
import cd.precheck.service.M_3g_7_5_1_6_service;
import cd.precheck.service.M_3g_8_2_service;

public class PrecheckProcedure {

	private static Logger log = Logger.getLogger(PrecheckProcedure.class);
	
	public static void main(String[] args) {
		
		String time = "201108";
		boolean result = false;
		
		M_3g_7_2_1_5_service_pre _7215 = new M_3g_7_2_1_5_service_pre();
		result = _7215.precheck(time);
		log.warn(result);
		
		M_3g_7_2_1_6_service _7216 = new M_3g_7_2_1_6_service();
		result = _7216.precheck(time);
		log.warn(result);
		
		M_3g_7_2_3_1_service _7231 = new M_3g_7_2_3_1_service();
		result = _7231.precheck(time);
		log.warn(result);
		
		M_3g_7_3_1_4_service _7314 = new M_3g_7_3_1_4_service();
		result = _7314.precheck(time);
		log.warn(result);
		
		M_3g_7_3_1_5_service _7315 = new M_3g_7_3_1_5_service();
		result = _7315.precheck(time);
		log.warn(result);
		
		M_3g_7_4_1_4_service _7414 = new M_3g_7_4_1_4_service();
		result = _7414.precheck(time);
		log.warn(result);
		
		M_3g_7_5_1_3_service _7513 = new M_3g_7_5_1_3_service();
		result = _7513.precheck(time);
		log.warn(result);
		
		M_3g_7_5_1_4_service _7514 = new M_3g_7_5_1_4_service();
		result = _7514.precheck(time);
		log.warn(result);
		
		// 7.5.1.5 不是我负责的,但是必须按照顺序运行才可以.
		M_3g_7_5_1_5_service _7515 = new M_3g_7_5_1_5_service();
		result = _7515.precheck(time);
		log.warn(result);
		
		M_3g_7_5_1_6_service _7516 = new M_3g_7_5_1_6_service();
		result = _7516.precheck(time);
		log.warn(result);
		
		M_3g_8_2_service _82 = new M_3g_8_2_service();
		result = _82.precheck(time);
		log.warn(result);
		
		M_2g_7_6_2_service _762 = new M_2g_7_6_2_service();
		result = _762.precheck(time);
		log.warn(result);
		
		M_2g_8_2_service _2g82 = new M_2g_8_2_service();
		result = _2g82.precheck(time);
		log.warn(result);
		
		M_2g_8_3_service _2g83 = new M_2g_8_3_service();
		result = _2g83.precheck(time);
		log.warn(result);
	}

}
