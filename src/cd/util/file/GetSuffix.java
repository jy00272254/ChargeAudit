package cd.util.file;

public class GetSuffix {
	
	/**
	 * 获取文件后缀名
	 * @param fileName
	 * @return
	 */
	public static String get(String fileName){
		int path = fileName.lastIndexOf(".");
		if(path==-1 || path == fileName.length())
			return "";
		return fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
	}
}
