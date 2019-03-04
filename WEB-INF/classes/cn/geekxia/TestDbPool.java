package cn.geekxia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class TestDbPool {
	public static BasicDataSource ds = null;
	
	public final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public final static DB_URL = "jdbc:mysql://localhost/world";
	public final static String USER_NAME = "root";
	public final static String PASS_WORD = "123456";
	
	public static void dbpoolInit() {
		// 创建数据库连接池对象
		ds = new BasicDataSource();
		// 设置数据库连接池的四个必须参数：驱动名称、数据库地址、用户名和密码
		ds.setDriverClassName(DRIVER_NAME);
		ds.setUrl(DB_URL);
		ds.setUsername(USER_NAME);
		ds.setPassword(PASS_WORD);
	}
	public void testConnection() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 从数据库连接池中取出一个现有的数据库连接对象
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from world");
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 这里的 conn.close() 不是关闭数据库连接，而是把数据库连接对象归还给数据库连接池
			try {
				if (conn != null) conn.close();
				if (stmt != null) stmt.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
	}
	public static void main(String[] args) {
		dbpoolInit();
		new TestDbPool().testConnection();
	}
}
