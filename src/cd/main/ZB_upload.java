package cd.main;

import java.util.List;

import cd.ftp.Client;
import cd.zb.GenFile;
import cd.zb.ZB_CONSTANT;

/**
 * ���������ܲ���Ҫ���ļ���ʽ���ϴ�
 * @author Administrator
 *
 */
public class ZB_upload {

	public static void main(String[] args) {
		
		GenFile gf = new GenFile();
		List<String> filenames = gf.genMulti(
						ZB_CONSTANT.�û��ձ�_FILENAME, 	//�ļ���
						ZB_CONSTANT.�û��ձ�_SQL, 			//��ѯSQL
						"a", 	// ����/�ش� A/B
						"d",  // ��/�� D/M
						"20110915", 	//��ʼ����
						"20110921");	//��������
		
		for(String filename : filenames){
			System.out.println(filename);
		}
		
//		Client client = new Client("10.213.9.183", "root", "y4yhl9t");	// ����/��¼�ʺ�/����
//		client.upload("/", "back", filenames);	//����Ŀ¼/�ļ���׺(��Ҫ�������ڴ���ʱ���ܲ����չ�ȥ,���԰����ָ���)/�ļ����б�
//		client.rename("/", "back", filenames);	//����Ŀ¼/�ļ���׺(�����ָĹ���)/�ļ����б�
//		client.disconnect();

	}

}
