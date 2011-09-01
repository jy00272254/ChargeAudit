package cd.db2;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DB2Factory {

	private static Logger log = Logger.getLogger(DB2Factory.class);
	private static String driver = "com.ibm.db2.jcc.DB2Driver";
	private static String url = "jdbc:db2:BONCBI";
	private static String user = "dm";
	private static String password = "scltuser";
	private static ComboPooledDataSource cpds = null;

	static {
		initPool();
	}

	private static void initPool() {
		cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass(driver);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		cpds.setJdbcUrl(url);
		cpds.setUser(user);
		cpds.setPassword(password);

		// ��ʼ��ʱ��������������Ӧ��minPoolSize��maxPoolSize֮��ȡֵ��Ĭ��Ϊ3��
		cpds.setInitialPoolSize(2);
		cpds.setMinPoolSize(2);
		// �����ӳ��е���������ʱ��C3P0һ���Դ��������ӵ���Ŀ2
		cpds.setAcquireIncrement(2);
		cpds.setMaxPoolSize(10);
		// ������ʱ�䣬��������ʱ������ӽ���������Ϊ0����������������Ĭ��Ϊ0��
		cpds.setMaxIdleTime(3);
		// ���ӳ��б����������������Ĭ��Ϊ15��
		cpds.setMaxPoolSize(100);
		/**
		 * �����ӳ�����ʱ�ͻ��˵���getConnection()��ȴ���ȡ�����ӵ�ʱ�䣬��ʱ���׳�SQLException��
		 * ����Ϊ0�������ڵȴ�����λ���룬Ĭ��Ϊ0��
		 */
		cpds.setCheckoutTimeout(10000);
	}

	public static Connection getConn(){
		if (cpds == null)
			initPool();
		Connection conn = null;
		try {
			conn = cpds.getConnection();
		} catch (SQLException e) {
			log.error("��ȡ���ݿ�����ʧ��!");
		}
		return conn;
	}
	
	public static void closeConn(Connection conn){
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				log.error("�ر����ݿ����ӳ���!");
			}
	}

}
