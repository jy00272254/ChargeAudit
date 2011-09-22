package cd.zb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cd.db2.DB2Factory;
import cd.util.time.GetTime;

/**
 * 用于生成需要上传的文件
 * @author Administrator
 */
public class GenFile {
	
	public GenFile(){
		super();
	};
	
	/**
	 * 组合文件名
	 * @param name
	 * @param uploadType
	 * @param accountDate
	 * @return
	 */
	private String getFilename(String name, String uploadType, String accountDate){
		
		name = name.toUpperCase();
		uploadType = uploadType.toUpperCase();
		accountDate = accountDate.toUpperCase();
		name = name.replaceFirst("\\?", uploadType);
		name = name.replaceFirst("\\?", accountDate);
		
		return name;
	}
	
	/**
	 * 获取文件内容
	 * @param sql
	 * @param accountDate
	 * @return
	 */
	private List<String> getContent(String sql, String accountDate){
		Connection conn = DB2Factory.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> result = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, accountDate);
			
			rs = ps.executeQuery();
			result = new ArrayList<String>();
			int columns = rs.getMetaData().getColumnCount();
			while(rs.next()){
				StringBuffer sb = new StringBuffer();
				for(int i=0; i<columns; i++){
					sb.append(rs.getObject(i+1).toString());
					if( i != columns-1){
						sb.append("	");
					}
				}
				result.add(sb.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				DB2Factory.closeConn(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 获取文件首行
	 * @param filename
	 * @param accountDate
	 * @param totalCount
	 * @return
	 */
	private String getHead(String filename, String accountDate, Integer totalCount){
		
		StringBuffer sb = new StringBuffer();
		sb.append("01").append("	");
		sb.append("081").append("	");
		sb.append(filename.substring(0, 7)).append("	");
		sb.append(filename.substring(13, 16)).append("	");
		sb.append("03").append("	");
		sb.append(GetTime.today1()).append("	");
		sb.append(accountDate).append("	");
		sb.append("000000").append("	");
		sb.append(accountDate).append("	");
		sb.append("235959").append("	");
		sb.append(totalCount);
		
		return sb.toString();
	}
	
	/**
	 * 产生文件并写入到文件
	 * @param filename
	 * @param sql
	 * @param accountDate
	 * @param uploadType
	 * @param m_d
	 */
	public void gen(String filename, String sql, String accountDate, String uploadType, String m_d){
		
		String zb_filename = null;
		if("M".equals(m_d.toUpperCase())){
			zb_filename = getFilename(filename, uploadType, accountDate.substring(0, 6));
		}else{
			zb_filename = getFilename(filename, uploadType, accountDate.substring(2));
		}
		List<String> content = getContent(sql, accountDate);
		String head = getHead(zb_filename, accountDate, content.size());
		
		System.out.println(zb_filename);
		System.out.println(head);
		for(String str : content){
			System.out.println(str);
		}
		
		File file = null;
		BufferedWriter bw = null;
		try {
			file = new File(URLDecoder.decode(GenFile.class.getResource("/").getPath(), "UTF-8")+"cd/report_file/upload/"+zb_filename);
			if(!file.exists())
				file.createNewFile();
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(head);
			bw.write("\r\n");
			for(String str : content){
				bw.write(str);
				bw.write("\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		GenFile gf = new GenFile();
		gf.gen(ZB_CONSTANT.移动语音业务收入类日报_FILENAME, 
				ZB_CONSTANT.移动语音业务收入类日报_SQL, 
				"20110921", 
				"A", 
				"D");
	}

}
