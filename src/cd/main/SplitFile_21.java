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
 * ��TXT�ļ��е����ݷֵ�21���ļ���,�ļ����Ĵ�21����������
 * 
 * @author Administrator
 * 
 */
public class SplitFile_21 {

	private static String[] area_names = { "�ɶ�", "�Ű�", "��ɽ", "��֦��", "��ɽ", "����",
			"�ڽ�", "�˱�", "�Թ�", "üɽ", "����", "����", "�ϳ�", "�㰲", "����", "����", "��Ԫ",
			"����", "����", "����", "����" };
	private static Map<String, String> area_no_name_pair = new HashMap<String, String>();
	private static Map<String, Integer> area_no_rows = new HashMap<String, Integer>();
	
	private static int splitRecord = 0;
	private static Map<String, BufferedWriter> targetFiles = null;
	
	public static void main(String[] args) {

		String srcName = "c:\\ȫ����.TXT";
		String targetPath = "c:\\ȫ����";

		long startTime = System.currentTimeMillis();
		int totalRecord = 0;
		//�ж�targetPath�Ƿ����,�������������ļ���
		File targetDirectory = new File(targetPath);
		if(! targetDirectory.exists()){
			targetDirectory.mkdir();
		}
		
		//ɾ��Ŀ���ļ����������ļ�
		DeleteFile.deleteFiles(targetPath, true);
		
		//��21���ļ�
		targetFiles = new HashMap<String, BufferedWriter>();
		openFiles(targetFiles, srcName, targetPath);
		
		File f = new File(srcName);

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));

			// ���ڴ洢��ȡ�����ļ�����Ϣ
			List<String> srcStrs = new ArrayList<String>();
			String str = "";
			for (int i = 0; (str = br.readLine()) != null; i++) {
				totalRecord++;
				srcStrs.add(str);

				// ÿ��ȡ100000����¼����һ�δ���
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
			
			// �ر������ļ�
			closeFiles(targetFiles);
			
			System.out.println(" ��ʱ :  " + (System.currentTimeMillis() - startTime) + " ms");
			System.out.println(" ��ȡ���ܼ�¼��: " + totalRecord);
			System.out.println(" д��ļ�¼��: " + splitRecord);
			
			Set<String> keys = area_no_rows.keySet();
			for(String key : keys){
				System.out.println(key + "		" + area_no_rows.get(key));
			}
		}
		
	}

	/**
	 * ����������ݷֱ�д�뵽ָ���ļ�������
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
		//ˢ�������ļ�
		flushFiles(targetFiles);
	}

	/**
	 * ����ȡ�õ��б�����������
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
	 * ���յ��д��ļ�,��û���ļ����½�
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
		
		// ��21���ļ�
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
	 * �ر������ļ�
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
	 * ˢ�������ļ�
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
		area_no_name_pair.put("810", "�ɶ�");
		area_no_name_pair.put("811", "�Ű�");
		area_no_name_pair.put("812", "��ɽ");
		area_no_name_pair.put("813", "��֦��");
		area_no_name_pair.put("814", "��ɽ");
		area_no_name_pair.put("815", "����");
		area_no_name_pair.put("816", "�ڽ�");
		area_no_name_pair.put("817", "�˱�");
		area_no_name_pair.put("818", "�Թ�");
		area_no_name_pair.put("819", "üɽ");
		area_no_name_pair.put("820", "����");
		area_no_name_pair.put("821", "����");
		area_no_name_pair.put("822", "�ϳ�");
		area_no_name_pair.put("823", "�㰲");
		area_no_name_pair.put("824", "����");
		area_no_name_pair.put("825", "����");
		area_no_name_pair.put("826", "��Ԫ");
		area_no_name_pair.put("827", "����");
		area_no_name_pair.put("828", "����");
		area_no_name_pair.put("829", "����");
		area_no_name_pair.put("830", "����");
		area_no_name_pair.put("�ɶ�", "�ɶ�");
		area_no_name_pair.put("�Ű�", "�Ű�");
		area_no_name_pair.put("��ɽ", "��ɽ");
		area_no_name_pair.put("��֦��", "��֦��");
		area_no_name_pair.put("��ɽ", "��ɽ");
		area_no_name_pair.put("����", "����");
		area_no_name_pair.put("�ڽ�", "�ڽ�");
		area_no_name_pair.put("�˱�", "�˱�");
		area_no_name_pair.put("�Թ�", "�Թ�");
		area_no_name_pair.put("üɽ", "üɽ");
		area_no_name_pair.put("����", "����");
		area_no_name_pair.put("����", "����");
		area_no_name_pair.put("�ϳ�", "�ϳ�");
		area_no_name_pair.put("�㰲", "�㰲");
		area_no_name_pair.put("����", "����");
		area_no_name_pair.put("����", "����");
		area_no_name_pair.put("��Ԫ", "��Ԫ");
		area_no_name_pair.put("����", "����");
		area_no_name_pair.put("����", "����");
		area_no_name_pair.put("����", "����");
		area_no_name_pair.put("����", "����");
		
		area_no_rows.put("�ɶ�", 0);
		area_no_rows.put("�Ű�", 0);
		area_no_rows.put("��ɽ",0);
		area_no_rows.put("��֦��", 0);
		area_no_rows.put("��ɽ", 0);
		area_no_rows.put("����", 0);
		area_no_rows.put("�ڽ�", 0);
		area_no_rows.put("�˱�", 0);
		area_no_rows.put("�Թ�", 0);
		area_no_rows.put("üɽ", 0);
		area_no_rows.put("����", 0);
		area_no_rows.put("����", 0);
		area_no_rows.put("�ϳ�", 0);
		area_no_rows.put("�㰲", 0);
		area_no_rows.put("����", 0);
		area_no_rows.put("����", 0);
		area_no_rows.put("��Ԫ", 0);
		area_no_rows.put("����", 0);
		area_no_rows.put("����", 0);
		area_no_rows.put("����", 0);
		area_no_rows.put("����", 0);
	}
}
