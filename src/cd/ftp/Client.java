package cd.ftp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.URLDecoder;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;

import cd.main.ZB_upload;

/**
 * 用于连接FTP服务器,上传文件
 * @author Administrator
 *
 */
public class Client {

	private FTPClient ftpClient = null;
	private Logger log = Logger.getLogger(Client.class);
	
	public Client(){}
	
	public Client(String host, String user, String password){
		if(openAndLogin(host, user, password)){
			log.warn("登录成功!");
		}else{
			log.warn("登录失败!");
		}
	}
	
	/**
	 * 登录
	 * @param host
	 * @param user
	 * @param password
	 * @return
	 */
	public boolean openAndLogin(String host, String user, String password){
		
		boolean result = false;
		
		if(ftpClient == null){
			ftpClient = new FTPClient();
		}
		
		try {
			ftpClient.connect(host);
			result = ftpClient.login(user, password);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 上传文件到指定目录
	 * @param workDirectory
	 * @param remote
	 * @param local
	 * @return
	 */
	public boolean upload(String workDirectory, String remote, String local){
		boolean result = false;
		try {
			String path = URLDecoder.decode(ZB_upload.class.getResource("/").getPath(), "UTF-8") + "cd/report_file/upload/";
			
			ftpClient.changeWorkingDirectory(workDirectory);
			
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			InputStream input =  new FileInputStream(path + local);
			
			result = ftpClient.storeFile(remote, input);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void upload(String workDirectory, String suffix, List<String> files){
		for(String file : files){
			upload(workDirectory, file + suffix, file);
		}
	}
	
	/**
	 * 重命名文件
	 * @param src
	 * @param target
	 * @return
	 */
	public boolean rename(String workDirectory, String src, String target){
		boolean result = false;
		try {
			ftpClient.changeWorkingDirectory(workDirectory);
			result = ftpClient.rename(src, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void rename(String workDirectory, String suffix, List<String> files){
		for(String file : files){
			rename(workDirectory, file + suffix, file);
		}
	}
	
	/**
	 * 关闭连接
	 */
	public void disconnect(){
		try {
			ftpClient.logout();
			ftpClient.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client("10.213.9.183", "root", "y4yhl9t");
		client.upload("/", "test.remote", "c:\\cmyd_280_20110901.Z9C");
		client.disconnect();
	}

}
