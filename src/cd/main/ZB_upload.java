package cd.main;

import java.util.List;
import cd.zb.GenFile;
import cd.zb.ZB_CONSTANT;

/**
 * 用于生成总部需要的文件格式并上传
 * @author Administrator
 *
 */
public class ZB_upload {

	public static void main(String[] args) {
		
		GenFile gf = new GenFile();
		List<String> filenames = gf.genMulti(
						ZB_CONSTANT.移动语音业务收入类日报_FILENAME, 	//文件名
						ZB_CONSTANT.移动语音业务收入类日报_SQL, 			//查询SQL
						"b", 	// 正常/重传 A/B
						"d",  // 日/月 D/M
						"20111009", 	//起始日期
						"20111031");	//结束日期
		
		for(String filename : filenames){
			System.out.println(filename);
		}
		
//		Client client = new Client("10.213.9.183", "root", "y4yhl9t");	// 主机/登录帐号/密码
//		client.upload("/", "back", filenames);	//工作目录/文件后缀(主要是怕正在传的时候总部接收过去,所以把名字改了)/文件名列表
//		client.rename("/", "back", filenames);	//工作目录/文件后缀(把名字改过来)/文件名列表
//		client.disconnect();

	}

}
