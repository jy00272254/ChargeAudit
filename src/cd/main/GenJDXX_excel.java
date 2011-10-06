package cd.main;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.log4j.Logger;

import cd.db2.DB2Factory;

/**
 * ֵ��ʱ�����ҵ����������ļ�,����EXCEL�ļ�
 */
public class GenJDXX_excel {

	private static Logger log = Logger.getLogger(GenJDXX_excel.class);

	public static void main(String[] args) throws UnsupportedEncodingException {
		log.warn("����ֵ����Ҫ�ļҵ�����EXCEL�ļ�,�ļ���Ϊ:  ʡ�ֹ�˾���ҵ����硱ͳ�Ʊ�.xls");

		//��Ҫͳ�Ƶ�����
		String time = "20111005";
		//Ŀ���ļ���
		String dstFilename = "c:\\ʡ�ֹ�˾���ҵ����硱ͳ�Ʊ�.xls";
		//Դ�ļ���
		String srcFilename = URLDecoder.decode(GenJDXX_excel.class.getResource("/")
					.getPath(), "UTF-8")	+ "cd\\resource\\ʡ�ֹ�˾���ҵ����硱ͳ�Ʊ�.xls";
		
		createExcel(getDataFromDB2(time), srcFilename, dstFilename);
	}

	private static void createExcel(Map<String, String> result, String srcFilename, String dstFilename){
		Workbook src = null;
		WritableWorkbook dst = null;
		try {
			// ����EXCEL�ļ�
			src = Workbook.getWorkbook(new File(srcFilename));
			dst = Workbook.createWorkbook(new File(dstFilename), src);
			WritableSheet sheet = dst.getSheet(0);

			/**
			 * 4 -- 0 :1 4 -- 1 :7 4 -- 2 : 4 -- 3 : 4 -- 4 :27728.07 4 -- 5 : 4
			 * -- 6 : 4 -- 7 :384039 4 -- 8 : 4 -- 9 : 4 -- 10 :29763 4 -- 11
			 * :44247
			 */
			WritableCell cell = sheet.getWritableCell(1, 4);

			Label label = new Label(1, 4, result.get("day_dev_users"), cell.getCellFormat());// �շ�չ
			Label label1 = new Label(4, 4, result.get("day_fee"), cell.getCellFormat());// ������
			Label label2 = new Label(7, 4, result.get("day_pay_unit"), cell.getCellFormat());// ͨ��ʱ��
			Label label3 = new Label(10, 4, result.get("day_call_users"),
					cell.getCellFormat());// ��ͨ���û���
			Label label4 = new Label(11, 4, result.get("month_call_users"),
					cell.getCellFormat());// ��ͨ���û���

			sheet.addCell(label);
			sheet.addCell(label1);
			sheet.addCell(label2);
			sheet.addCell(label3);
			sheet.addCell(label4);

			dst.write();
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}finally{
			try {
				dst.close();
				src.close();
			} catch (WriteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Map<String, String> getDataFromDB2(String time) {
		Connection conn = DB2Factory.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String, String> result = null;

		String sql = "SELECT " + "acct_day," + "day_dev_users \"�շ�չ\","
				+ "day_fee \"������\"," + "day_pay_unit \"ͨ��ʱ��\","
				+ "day_call_users \"��ͨ���û���\","
				+ "month_call_users \"��ͨ���û���\"   "
				+ "FROM REPORT.REPORT_D_SC_JDXX  " + "where acct_day= '" + time + "'";
		
		System.out.println(sql);
		
		String day_dev_users = null; // �շ�չ
		String day_fee = null; // ������
		String day_pay_unit = null; // ͨ��ʱ��
		String day_call_users = null; // ��ͨ���û���
		String month_call_users = null; // ��ͨ���û���

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				day_dev_users = rs.getString(2);
				day_fee = rs.getString(3);
				day_pay_unit = rs.getString(4);
				day_call_users = rs.getString(5);
				month_call_users = rs.getString(6);

				log.warn("�ҵ���������: [ ����: " + rs.getString(1) + "--�շ�չ: "
						+ day_dev_users + "--������: " + day_fee + "--ͨ��ʱ��: "
						+ day_pay_unit + "--��ͨ���û���: " + day_call_users
						+ "--��ͨ���û���: " + month_call_users + "]");
			}
			result = new HashMap<String, String>();
			result.put("day_dev_users", day_dev_users);
			result.put("day_fee", day_fee);
			result.put("day_pay_unit", day_pay_unit);
			result.put("day_call_users", day_call_users);
			result.put("month_call_users", month_call_users);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DB2Factory.closeConn(conn);
		return result;
	}

}
