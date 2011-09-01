package cd.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import cd.util.regex.Regex;


public class ReadFile {
	
	public static void readFileName(String dirName, List<String> fileNames){
		File file = new File(dirName);
		if(file.isDirectory()){
			File[] subFiles = file.listFiles();
			for(File subFile : subFiles)
				readFileName(subFile.getAbsolutePath(), fileNames);
		}else{
			fileNames.add(file.getAbsolutePath());
		}
	}

	
	public static List<String> readTXT(String fileName) {
		BufferedReader br = null;
		List<String> device_numbers = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = null;
			while((line = br.readLine()) != null){
				List<String> subs = Regex.device_number(line);
				for(String sub : subs)
					device_numbers.add(sub);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
				try {
					if(br != null)
						br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return device_numbers;
	}
	
	public static List<String> readXLS(String fileName) {
		Workbook workbook =  null;
		List<String> device_numbers = new ArrayList<String>();
		try {
			workbook = Workbook.getWorkbook(new File(fileName));
			Sheet sheet = workbook.getSheet(0);
			int rowLength = sheet.getRows();
			for(int i=0;i<rowLength;i++){
				Cell[] cells = sheet.getRow(i);
				StringBuffer line = new StringBuffer();
				for(Cell cell : cells){
					line.append(cell.getContents()).append("  ");
				}
				List<String> subs = Regex.device_number(line);
				for(String sub : subs)
					device_numbers.add(sub);
			}
			
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			workbook.close();
		}
		return device_numbers;
	}
	
	
}
