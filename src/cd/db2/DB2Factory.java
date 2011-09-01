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

		// 初始化时创建的连接数，应在minPoolSize与maxPoolSize之间取值。默认为3；
		cpds.setInitialPoolSize(2);
		cpds.setMinPoolSize(2);
		// 当连接池中的连接用完时，C3P0一次性创建新连接的数目2
		cpds.setAcquireIncrement(2);
		cpds.setMaxPoolSize(10);
		// 最大空闲时间，超过空闲时间的连接将被丢弃。为0或负数则永不丢弃。默认为0；
		cpds.setMaxIdleTime(3);
		// 连接池中保留的最大连接数。默认为15；
		cpds.setMaxPoolSize(100);
		/**
		 * 当连接池用完时客户端调用getConnection()后等待获取新连接的时间，超时后将抛出SQLException，
		 * 如设为0则无限期等待。单位毫秒，默认为0；
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
			log.error("获取数据库连接失败!");
		}
		return conn;
	}
	
	public static void closeConn(Connection conn){
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				log.error("关闭数据库连接出错!");
			}
	}

}
