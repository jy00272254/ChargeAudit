package cd.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cd.file.DeleteFile;
import cd.file.ReadFile;
import cd.file.WriteFile;
import cd.importdata.ImportData;
import cd.util.file.GetSuffix;

/**
 * ���ڽ�XLS,TXT�ļ��е��ֻ����뵼����ָ����,ֻ�ܵ����ֻ�����,һ��һ��.
 * @author Administrator
 *
 */
public class ImportNumberIntoDB2 {

	private static Logger log = Logger.getLogger(ImportNumberIntoDB2.class);
	
	public static void main(String[] args) {
		
		//DB2���ж�Ӧ����
		String tableName = "MID.MID_TEMP_BAZHONG_USERNAME_TEMP1";
	
		//��Ҫ�����ֻ�������ļ��л��ļ���(��Ϊ�ļ���,������Ӻ�׺��)
		String targetFileName = "X:\\��������\\20110902_����ͳ�ƣ���ʱ����-���зֹ�˾7��3G�ֻ������û�ר���������\\�����зֹ�˾7��3G�ֻ������û�������Ϣ.xls";
		
		List<String> fileNames = new ArrayList<String>();
		
		//�жϴ�������ļ��л����ļ���
		File targetFile = new File(targetFileName);
		if(targetFile.isDirectory())
			ReadFile.readFileName(targetFileName, fileNames);
		else
			fileNames.add(targetFileName);
		
		List<String> device_numbers = new ArrayList<String>();
		
		for(String fileName : fileNames){
			if(device_numbers.size() >= 500000){
				log.debug(" records exceed 500000 ,write into file and clear the list ...");
				log.debug(" current list records number : " + device_numbers.size());
				WriteFile.write(device_numbers);
				device_numbers.clear();
			}
			String suffix = GetSuffix.get(fileName);
			if("txt".equals(suffix.toLowerCase())){
				List<String> subs = ReadFile.readTXT(fileName);
				log.debug(fileName + " have " + subs.size() + " records! ");
				for(String sub : subs)
					device_numbers.add(sub);
			}
			if("xls".equals(suffix.toLowerCase())){
				List<String> subs = ReadFile.readXLS(fileName);
				log.debug(fileName + " have " + subs.size() + " records! ");
				for(String sub : subs)
					device_numbers.add(sub);
			}
		}
		
		log.debug(" current list records number : " + device_numbers.size());
		String absolutePath = WriteFile.write(device_numbers);
		
		ImportData.importData(absolutePath, tableName);
		
		DeleteFile.delete(absolutePath);
	}

}
