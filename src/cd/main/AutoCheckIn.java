package cd.main;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import cd.autocheckin.Client;

public class AutoCheckIn {
	
	
	private static Logger log = Logger.getLogger(AutoCheckIn.class);

	public static void main(String[] args) {
		
		log.warn("�Զ��򿨼�ؿ�ʼ.....");
		while(true){
			
			if(System.currentTimeMillis() >= 1317256200609l){
				log.warn("ʱ������Ҫ��,�򿨿�ʼ....");
				DefaultHttpClient httpClient = new DefaultHttpClient();
				new Client(httpClient, "chengding", "123456").checkIn();
				log.warn("ʱ������Ҫ��,�򿨳ɹ�....");
				break;
			}
			
			log.warn("ʱ��δ��,�ӳ�2����...");
			try {
				Thread.sleep(120000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
