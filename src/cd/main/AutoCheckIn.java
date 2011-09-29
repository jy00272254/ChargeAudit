package cd.main;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import cd.autocheckin.Client;

public class AutoCheckIn {
	
	
	private static Logger log = Logger.getLogger(AutoCheckIn.class);

	public static void main(String[] args) {
		
		log.warn("自动打卡监控开始.....");
		while(true){
			
			if(System.currentTimeMillis() >= 1317256200609l){
				log.warn("时间满足要求,打卡开始....");
				DefaultHttpClient httpClient = new DefaultHttpClient();
				new Client(httpClient, "chengding", "123456").checkIn();
				log.warn("时间满足要求,打卡成功....");
				break;
			}
			
			log.warn("时间未到,延迟2分钟...");
			try {
				Thread.sleep(120000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
