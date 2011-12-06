package cd.main.confirm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cd.ftp.Client;

/**
 * 用于校验明细上传成功与否,如果上传成功,将会读出文件名
 * @author Administrator
 *
 */
public class DetailConfirm {

	public static void main(String[] args) {
		
		Map<String, String> resources = new HashMap<String, String>();
		
		resources.put("4.1.1.1 客户", "CMBBIDWAL01001??");
		resources.put("4.1.1.2 组织客户", "CMBBIDWAL01002??");
		resources.put("4.1.1.3 个人客户", "CMBBIDWAL01003??");
		resources.put("4.1.1.6 客户证件信息", "CMBBIDWAL01006??");
		resources.put("4.3.1.1 渠道信息", "CMBBIDWAL03001??");
		resources.put("4.3.1.2 渠道佣金", "CMBBIDWAL03002??");
		resources.put("4.8.1.1 号码资源表", "CMBBIDWAL08001??");
		resources.put("6.1.1 职业类型编码映射表", "CMBBIYS01001??");
		resources.put("6.1.2 行业类型编码映射表", "CMBBIYS01002??");
		resources.put("6.1.3 单位性质编码映射表", "CMBBIYS01003??");
		resources.put("6.1.4 客户类别编码映射表", "CMBBIYS01004??");
		resources.put("6.1.5 营业场所类型编码映射表", "CMBBIYS01005??");
		resources.put("6.1.6 证件类型编码映射表", "CMBBIYS01006??");
		resources.put("6.3.2 佣金科目编码映射表", "CMBBIYS03002??");
		resources.put("6.3.3 渠道类型编码映射表", "CMBBIYS03003??");
		resources.put("6.3.5 地域级别编码映射表", "CMBBIYS03005??");
		resources.put("3.1.3.1 渠道信息表", "CDWMQD0601??");
		resources.put("3.4.1 扇区信息", "CDWMZY0601??");
		resources.put("4.7 渠道类型编码映射表", "CDWMYS??0007");
		resources.put("4.8 地域级别编码映射表", "CDWMYS??0008");
		
		String fileType = "A"; //文件类型
		String date = "201111"; //账期
		
		Map<String, StringBuffer> result = new HashMap<String, StringBuffer>();
		
		Client client = new Client("130.81.8.58","scftp","scftp"); //FTP服务器地址,用户名,密码
		client.changeWorkingDirectory("/jfbackup/up_file/d_files"); //明细文档上传地址
		
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
