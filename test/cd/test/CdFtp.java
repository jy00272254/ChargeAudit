package cd.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class CdFtp {

	public static void main(String[] args) {
		FTPClient client = new FTPClient();

		try {
			client.connect("10.213.9.183");

			client.login("root", "y4yhl9t");

			client.changeWorkingDirectory("/");

			FTPFile[] files = client.listFiles();
			for (FTPFile file : files) {
				System.out.println(file.getName());
			}
			
			client.setFileType(FTP.BINARY_FILE_TYPE);
			
			InputStream input =  new FileInputStream("c:\\CDYY04B110921001.081");
			
			boolean result = client.storeFile("cdyy04.081", input);

			System.out.println(" ---------------------------- " + result);

			FTPFile[] files1 = client.listFiles();
			for (FTPFile file : files1) {
				System.out.println(file.getName());
			}

			input.close();
			client.logout();
			client.disconnect();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
