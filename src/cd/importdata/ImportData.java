package cd.importdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import cd.db2.DB2Factory;

public class ImportData {

	private static Logger log = Logger.getLogger(ImportData.class);

	public static void importData(String absolutePath, String tableName) {
		Connection conn = null;
		PreparedStatement ps = null;
		BufferedReader br = null;
		try {
			conn = DB2Factory.getConn();

			String sql = "insert into " + tableName + " values(?)";

			br = new BufferedReader(new FileReader(absolutePath));
			ps = conn.prepareStatement(sql);

			String device_number = null;
			int i = 0;
			while ((device_number = br.readLine()) != null) {
				ps.setString(1, device_number.trim());
				ps.addBatch();
				i++;
				if ((i + 1) % 1000 == 0) {
					ps.executeBatch();
				}
				if ((i + 1) % 10000 == 0) {
					log.debug(" addbatch find 10000 records, insert table now... ");
				}
			}
			ps.executeBatch();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (br != null)
					br.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		DB2Factory.closeConn(conn);
	}
}
