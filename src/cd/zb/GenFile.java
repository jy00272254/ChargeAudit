package cd.zb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import cd.db2.DB2Factory;
import cd.util.time.FormatTime;
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
	public String getFilename(String name, String uploadType, String accountDate){
		
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
	public List<String> getContent(List<String> sqls, String accountDate){
		Connection conn = DB2Factory.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> result = new ArrayList<String>();
		System.out.println(accountDate);
		try {
			for(int i=0; i< sqls.size(); i++){
				String sql = sqls.get(i);
				ps = conn.prepareStatement(sql);
				ps.setString(1, accountDate);
				
				rs = ps.executeQuery();
				int columns = rs.getMetaData().getColumnCount();
				while(rs.next()){
					StringBuffer sb = new StringBuffer();
					for(int j=0; j<columns; j++){
						sb.append(rs.getObject(j+1).toString());
						if( j != columns-1){
							sb.append("	");
						}
					}
					result.add(sb.toString());
				}
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
	public String getHead(String filename, String accountDate, Integer totalCount, String m_d){
		
		String from = null;
		String to = null;
		if("M".equals(m_d.toUpperCase())){
			from = accountDate.substring(0,6) + "01";
			Calendar c = new GregorianCalendar(
					Integer.valueOf(accountDate.substring(0,4)), 
					Integer.valueOf(accountDate.substring(4,6)), 
					0);
			to = FormatTime.format(new Date(c.getTimeInMillis()), "yyyyMMdd");
		}else{
			from = accountDate;
			to = accountDate;
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("01").append("	");
		sb.append("081").append("	");
		sb.append(filename.substring(0, 7)).append("	");
		sb.append(filename.substring(13, 16)).append("	");
		sb.append("03").append("	");
		sb.append(GetTime.today1()).append("	");
		sb.append(from).append("	");
		sb.append("000000").append("	");
		sb.append(to).append("	");
		sb.append("235959").append("	");
		sb.append(totalCount);
		
		return sb.toString();
	}
	
	public List<String> genMulti(String filename, List<String> sqls, String uploadType, String m_d, String from, String to){
		
		if( from == null || "".equals(from) || to == null || "".equals(to))
			return null;
		
		List<String> timeList = null;
		
		if("M".equals(m_d.toUpperCase())){
			if(from.length() < 6 || to.length() < 6)
				return null;
			
			from = from.substring(0, 6);
			to = to.substring(0, 6);
		}else{
			if(from.length() < 8 || to.length() < 8)
				return null;
			
			from = from.substring(0, 8);
			to = to.substring(0, 8);
		}
		timeList = GetTime.fromTo(from, to, m_d);
		
		List<String> result = new ArrayList<String>();
		for(String accountDate : timeList){
			result.add(genSingle(filename, sqls, accountDate, uploadType, m_d));
		}
		
		return result;
	}
	
	/**
	 * 产生文件并写入到文件
	 * @param filename
	 * @param sql
	 * @param accountDate
	 * @param uploadType
	 * @param m_d
	 */
	public String genSingle(String filename, List<String> sqls, String accountDate, String uploadType, String m_d){
		
		String zb_filename = null;
		if("M".equals(m_d.toUpperCase())){
			zb_filename = getFilename(filename, uploadType, accountDate.substring(0, 6));
		}else{
			zb_filename = getFilename(filename, uploadType, accountDate.substring(2));
		}
		List<String> content = getContent(sqls, accountDate);
		String head = getHead(zb_filename, accountDate, content.size(), m_d);
		
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
		
		return zb_filename;
	}
	
	public static void main(String[] args) {
		GenFile gf = new GenFile();
		gf.genSingle(ZB_CONSTANT.移动语音业务收入类日报_FILENAME, 
				ZB_CONSTANT.移动语音业务收入类日报_SQL, 
				"20110922", 
				"A", 
				"D");
	}

}
