package cd.main;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import cd.autocheckin.Client;

public class AutoCheckIn {
	
	private static Logger log = Logger.getLogger(AutoCheckIn.class);

	public static void main(String[] args) {
		
		log.info("自动打卡监控开始.....");
		while(true){
			
			if(System.currentTimeMillis() >= 1314837000484L){
				log.info("时间满足要求,打开开始....");
				DefaultHttpClient httpClient = new DefaultHttpClient();
				new Client(httpClient, "chengding", "123456").checkIn();
				log.info("时间满足要求,打开成功....");
				break;
			}
			
			log.info("时间未到,延迟1分钟...");
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
