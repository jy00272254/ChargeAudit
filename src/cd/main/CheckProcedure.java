package cd.main;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import cd.check.service.Check_Service;

public class CheckProcedure {

	private static Logger log = Logger.getLogger(CheckProcedure.class);
	
	public static void main(String[] args) {
		Check_Service cs = new Check_Service();
		List<Map<String, Integer>> result = cs.checkAll("201108");
		for(Map<String, Integer> map : result){
			Set<String> keys = map.keySet();
			for(String key : keys){
				log.warn(key + " -- " + map.get(key));
			}
		}
	}
	
}
