package cd.file;

import java.io.File;

import org.apache.log4j.Logger;

public class DeleteFile {

	private static Logger log = Logger.getLogger(DeleteFile.class);
	
	/**
	 * 删除单个文件
	 * @param absolutePath
	 * @return
	 */
	public static boolean delete(String absolutePath){
		boolean flag = true;
		File file = new File(absolutePath);
		if(file.exists())
			flag = file.delete();
		log.debug("delete file " + absolutePath +  (flag ? " success" : " failed!"));
		return flag;
	}
	
	/**
	 * 删除指定文件夹下的所有文件
	 * @param targetPath
	 */
	public static void deleteFiles(String targetPath, boolean flag){
		File f = new File(targetPath);
		if(f.isDirectory()){
			File[] fs = f.listFiles();
			for(File tempf : fs){
				deleteFiles(tempf.getAbsolutePath(), false);
			}
		}
		if(!flag)
			f.delete();
	}
}
