package cd.ftp;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.junit.Test;

public class TestFtp {

	@Test
	public void testDoComand(){
		FTPClient client = new FTPClient();
		try {
			client.connect("130.81.8.58");
			System.out.println(client.login("scftp", "scftp"));
			
			client.changeWorkingDirectory("/jfbackup/up_file/d_files");

			String[] names = client.listNames();
			for(String name : names){
				System.out.println(name);
			}
			System.out.println("----------------");
			System.out.println(names.length);

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				client.logout();
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
