package cd.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cd.file.DeleteFile;

/**
 * 将TXT文件中的内容分到21个文件中,文件按四川21个州市命名
 * 
 * @author Administrator
 * 
 */
public class SplitFile_21 {

	private static String[] area_names = { "成都", "雅安", "凉山", "攀枝花", "乐山", "泸州",
			"内江", "宜宾", "自贡", "眉山", "达州", "遂宁", "南充", "广安", "绵阳", "德阳", "广元",
			"巴中", "甘孜", "阿坝", "资阳" };
	private static Map<String, String> area_no_name_pair = new HashMap<String, String>();
	private static Map<String, Integer> area_no_rows = new HashMap<String, Integer>();
	
	private static int splitRecord = 0;
	private static Map<String, BufferedWriter> targetFiles = null;
	
	public static void main(String[] args) {

		String srcName = "c:\\全家乐.TXT";
		String targetPath = "c:\\全家乐";

		long startTime = System.currentTimeMillis();
		int totalRecord = 0;
		//判断targetPath是否存在,不存在则建立该文件夹
		File targetDirectory = new File(targetPath);
		if(! targetDirectory.exists()){
			targetDirectory.mkdir();
		}
		
		//删除目标文件夹下所有文件
		DeleteFile.deleteFiles(targetPath, true);
		
		//打开21个文件
		targetFiles = new HashMap<String, BufferedWriter>();
		openFiles(targetFiles, srcName, targetPath);
		
		File f = new File(srcName);

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));

			// 用于存储读取到的文件行信息
			List<String> srcStrs = new ArrayList<String>();
			String str = "";
			for (int i = 0; (str = br.readLine()) != null; i++) {
				totalRecord++;
				srcStrs.add(str);

				// 每读取100000条记录进行一次处理
				if ((i + 1) % 100000 == 0) {
					splictDataToFile(srcStrs, srcName, targetPath);
					srcStrs.clear();
				}
			}
			splictDataToFile(srcStrs, srcName, targetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			// 关闭所有文件
			closeFiles(targetFiles);
			
			System.out.println(" 耗时 :  " + (System.currentTimeMillis() - startTime) + " ms");
			System.out.println(" 读取到总记录数: " + totalRecord);
			System.out.println(" 写入的记录数: " + splitRecord);
			
			Set<String> keys = area_no_rows.keySet();
			for(String key : keys){
				System.out.println(key + "		" + area_no_rows.get(key));
			}
		}
		
	}

	/**
	 * 将传入的数据分别写入到指定文件夹下面
	 * 
	 * @param srcStrs
	 * @param targetPath
	 */
	private static void splictDataToFile(List<String> srcStrs, String srcName,
			String targetPath) {
		
		for (String srcStr : srcStrs) {
			try {
				String areaInfo = getAreaInfo(srcStr);
				if(areaInfo != null){
					targetFiles.get(area_no_name_pair.get(getAreaInfo(srcStr))).write(srcStr, 0, srcStr.length());
					targetFiles.get(area_no_name_pair.get(getAreaInfo(srcStr))).newLine();
					splitRecord++;
					area_no_rows.put(getAreaInfo(srcStr), area_no_rows.get(getAreaInfo(srcStr))+ 1);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//刷新所有文件
		flushFiles(targetFiles);
	}

	/**
	 * 用于取得地市编码或地市名称
	 * 
	 * @param srcStr
	 * @return
	 */
	private static String getAreaInfo(String srcStr) {
		if (srcStr == null || "".equals(srcStr))
			return null;
		String[] strs = srcStr.split("	");
		for (String str : strs) {
			if (str.trim().matches("^8[1,2,3][0-9]$")) {
				return str.trim();
			} else {
				for (String area_name : area_names) {
					if (str.trim().equals(area_name))
						return str.trim();
				}
			}
		}
		return null;
	}

	/**
	 * 按照地市打开文件,若没有文件则新建
	 * 
	 * @param srcName
	 * @param targetPath
	 * @return
	 */
	private static void openFiles(Map<String, BufferedWriter> targetFiles,
			String srcName, String targetPath) {
		
		if (srcName == null || "".equals(srcName) || targetPath == null
				|| "".equals(targetPath) || targetFiles == null)
			return;
		String[] tempName = srcName.split("\\\\");
		
		// 打开21个文件
		for (String area_name : area_names) {
			String tempFileName = targetPath + "\\"
					+ tempName[tempName.length - 1].split("\\.")[0] + "_"
					+ area_name + ".txt";
			
			try {
				File f = new File(tempFileName);
				if (!f.exists()) {
					f.createNewFile();
				}
				BufferedWriter br = new BufferedWriter(new FileWriter(f, true));
				targetFiles.put(area_name, br);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭所有文件
	 * 
	 * @param targetFiles
	 */
	private static void closeFiles(Map<String, BufferedWriter> targetFiles) {
		Set<String> keys = targetFiles.keySet();

		for (String key : keys) {
			BufferedWriter br = targetFiles.get(key);

			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 刷新所有文件
	 * @param targetFiles
	 */
	private static void flushFiles(Map<String, BufferedWriter> targetFiles){
		Set<String> keys = targetFiles.keySet();

		for (String key : keys) {
			BufferedWriter br = targetFiles.get(key);

			if (br != null) {
				try {
					br.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static{
		area_no_name_pair.put("810", "成都");
		area_no_name_pair.put("811", "雅安");
		area_no_name_pair.put("812", "凉山");
		area_no_name_pair.put("813", "攀枝花");
		area_no_name_pair.put("814", "乐山");
		area_no_name_pair.put("815", "泸州");
		area_no_name_pair.put("816", "内江");
		area_no_name_pair.put("817", "宜宾");
		area_no_name_pair.put("818", "自贡");
		area_no_name_pair.put("819", "眉山");
		area_no_name_pair.put("820", "达州");
		area_no_name_pair.put("821", "遂宁");
		area_no_name_pair.put("822", "南充");
		area_no_name_pair.put("823", "广安");
		area_no_name_pair.put("824", "绵阳");
		area_no_name_pair.put("825", "德阳");
		area_no_name_pair.put("826", "广元");
		area_no_name_pair.put("827", "巴中");
		area_no_name_pair.put("828", "甘孜");
		area_no_name_pair.put("829", "阿坝");
		area_no_name_pair.put("830", "资阳");
		area_no_name_pair.put("成都", "成都");
		area_no_name_pair.put("雅安", "雅安");
		area_no_name_pair.put("凉山", "凉山");
		area_no_name_pair.put("攀枝花", "攀枝花");
		area_no_name_pair.put("乐山", "乐山");
		area_no_name_pair.put("泸州", "泸州");
		area_no_name_pair.put("内江", "内江");
		area_no_name_pair.put("宜宾", "宜宾");
		area_no_name_pair.put("自贡", "自贡");
		area_no_name_pair.put("眉山", "眉山");
		area_no_name_pair.put("达州", "达州");
		area_no_name_pair.put("遂宁", "遂宁");
		area_no_name_pair.put("南充", "南充");
		area_no_name_pair.put("广安", "广安");
		area_no_name_pair.put("绵阳", "绵阳");
		area_no_name_pair.put("德阳", "德阳");
		area_no_name_pair.put("广元", "广元");
		area_no_name_pair.put("巴中", "巴中");
		area_no_name_pair.put("甘孜", "甘孜");
		area_no_name_pair.put("阿坝", "阿坝");
		area_no_name_pair.put("资阳", "资阳");
		
		area_no_rows.put("成都", 0);
		area_no_rows.put("雅安", 0);
		area_no_rows.put("凉山",0);
		area_no_rows.put("攀枝花", 0);
		area_no_rows.put("乐山", 0);
		area_no_rows.put("泸州", 0);
		area_no_rows.put("内江", 0);
		area_no_rows.put("宜宾", 0);
		area_no_rows.put("自贡", 0);
		area_no_rows.put("眉山", 0);
		area_no_rows.put("达州", 0);
		area_no_rows.put("遂宁", 0);
		area_no_rows.put("南充", 0);
		area_no_rows.put("广安", 0);
		area_no_rows.put("绵阳", 0);
		area_no_rows.put("德阳", 0);
		area_no_rows.put("广元", 0);
		area_no_rows.put("巴中", 0);
		area_no_rows.put("甘孜", 0);
		area_no_rows.put("阿坝", 0);
		area_no_rows.put("资阳", 0);
	}
}
