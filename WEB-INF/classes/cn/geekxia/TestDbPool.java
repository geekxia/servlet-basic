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
		// �������ݿ����ӳض���
		ds = new BasicDataSource();
		// �������ݿ����ӳص��ĸ�����������������ơ����ݿ��ַ���û���������
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
			// �����ݿ����ӳ���ȡ��һ�����е����ݿ����Ӷ���
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from world");
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// ����� conn.close() ���ǹر����ݿ����ӣ����ǰ����ݿ����Ӷ���黹�����ݿ����ӳ�
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
