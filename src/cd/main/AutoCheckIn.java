package cd.main;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import cd.autocheckin.Client;

public class AutoCheckIn {
	
	private static Logger log = Logger.getLogger(AutoCheckIn.class);

	public static void main(String[] args) {
		
		log.info("�Զ��򿨼�ؿ�ʼ.....");
		while(true){
			
			if(System.currentTimeMillis() >= 1314837000484L){
				log.info("ʱ������Ҫ��,�򿪿�ʼ....");
				DefaultHttpClient httpClient = new DefaultHttpClient();
				new Client(httpClient, "chengding", "123456").checkIn();
				log.info("ʱ������Ҫ��,�򿪳ɹ�....");
				break;
			}
			
			log.info("ʱ��δ��,�ӳ�1����...");
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
