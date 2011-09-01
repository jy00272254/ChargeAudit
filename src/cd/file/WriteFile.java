package cd.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
	
	public static String write(List<String> device_numbers){
		
			BufferedWriter bw = null;
			String absolutePath = null;
			try {
				File file = new File("c:\\result.txt");
				if(! file.exists()){
					file.createNewFile();
				}
				absolutePath = file.getAbsolutePath();
				bw = new BufferedWriter(new FileWriter(file, true));
				for(int i=0; i<device_numbers.size(); i++){
					bw.write(device_numbers.get(i)+"\r\n");
					if((i+1) % 5000 == 0){
						//log.debug("write record 5000 success ....");
						bw.flush();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return absolutePath;
	}
}
