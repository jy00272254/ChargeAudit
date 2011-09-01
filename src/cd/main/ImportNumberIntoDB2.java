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
 * 用于将XLS,TXT文件中的手机号码导出到指定表,只能导出手机号码,一行一个.
 * @author Administrator
 *
 */
public class ImportNumberIntoDB2 {

	private static Logger log = Logger.getLogger(ImportNumberIntoDB2.class);
	
	public static void main(String[] args) {
		
		//DB2库中对应表名
		String tableName = "DM.DM_TEMP_NEED_EXCEPT_CD";
	
		//需要导入手机号码的文件夹或文件名(若为文件名,必须添加后缀名)
		String targetFileName = "X:\\工作资料\\20110815_临时需求-8月2G转3G目标用户提取\\需要剔除的号码";
		
		List<String> fileNames = new ArrayList<String>();
		
		//判断传入的是文件夹或是文件名
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
