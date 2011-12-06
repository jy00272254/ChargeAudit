package cd.main.confirm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cd.ftp.Client;

/**
 * ����У����ϸ�ϴ��ɹ����,����ϴ��ɹ�,��������ļ���
 * @author Administrator
 *
 */
public class DetailConfirm {

	public static void main(String[] args) {
		
		Map<String, String> resources = new HashMap<String, String>();
		
		resources.put("4.1.1.1 �ͻ�", "CMBBIDWAL01001??");
		resources.put("4.1.1.2 ��֯�ͻ�", "CMBBIDWAL01002??");
		resources.put("4.1.1.3 ���˿ͻ�", "CMBBIDWAL01003??");
		resources.put("4.1.1.6 �ͻ�֤����Ϣ", "CMBBIDWAL01006??");
		resources.put("4.3.1.1 ������Ϣ", "CMBBIDWAL03001??");
		resources.put("4.3.1.2 ����Ӷ��", "CMBBIDWAL03002??");
		resources.put("4.8.1.1 ������Դ��", "CMBBIDWAL08001??");
		resources.put("6.1.1 ְҵ���ͱ���ӳ���", "CMBBIYS01001??");
		resources.put("6.1.2 ��ҵ���ͱ���ӳ���", "CMBBIYS01002??");
		resources.put("6.1.3 ��λ���ʱ���ӳ���", "CMBBIYS01003??");
		resources.put("6.1.4 �ͻ�������ӳ���", "CMBBIYS01004??");
		resources.put("6.1.5 Ӫҵ�������ͱ���ӳ���", "CMBBIYS01005??");
		resources.put("6.1.6 ֤�����ͱ���ӳ���", "CMBBIYS01006??");
		resources.put("6.3.2 Ӷ���Ŀ����ӳ���", "CMBBIYS03002??");
		resources.put("6.3.3 �������ͱ���ӳ���", "CMBBIYS03003??");
		resources.put("6.3.5 ���򼶱����ӳ���", "CMBBIYS03005??");
		resources.put("3.1.3.1 ������Ϣ��", "CDWMQD0601??");
		resources.put("3.4.1 ������Ϣ", "CDWMZY0601??");
		resources.put("4.7 �������ͱ���ӳ���", "CDWMYS??0007");
		resources.put("4.8 ���򼶱����ӳ���", "CDWMYS??0008");
		
		String fileType = "A"; //�ļ�����
		String date = "201111"; //����
		
		Map<String, StringBuffer> result = new HashMap<String, StringBuffer>();
		
		Client client = new Client("130.81.8.58","scftp","scftp"); //FTP��������ַ,�û���,����
		client.changeWorkingDirectory("/jfbackup/up_file/d_files"); //��ϸ�ĵ��ϴ���ַ
		
		String[] names = client.listNames();
		
		client.disconnect();
		
		for(String name : names){
			Set<String> keys = resources.keySet();
			for(String key : keys){
				String value = resources.get(key).replaceFirst("\\?", fileType).replaceFirst("\\?", date);
				if(name.contains(value)){
					if(result.get(key) == null)
						result.put(key, new StringBuffer());
					result.get(key).append(name).append("\r\n");
				}
			}
		}
		
		Set<String> keys = result.keySet();
		for(String key : keys){
			System.out.println(key);
			System.out.println(result.get(key));
		}
	}
}
