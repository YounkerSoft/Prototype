package com.xxx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author yuan
 *
 * @date 2016��4��7�� ����7:13:03
 */
public class Database {
	
	//���ݿ�����
	final public static String driverName = "com.mysql.jdbc.Driver";
	//���ݿ����URL
	final public static String url = "jdbc:mysql://localhost:3306/mes";
	//���ݿ�����û���
	final public static String userName = "root";
	//���ݿ���ʿ���
	final public static String userPassword = "";

	@SuppressWarnings("rawtypes")
	private static ThreadLocal connection = new ThreadLocal();


	/**
	 * ȡ�����ݿ�����
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public synchronized static java.sql.Connection getConnection()
			throws SQLException {
		Connection con = (Connection) connection.get();
		if (con != null && !con.isClosed()) {
			return con;
		}

		//ֱ��ʹ��JDBC��������
		try {
			Class.forName(driverName);
			
			con = DriverManager.getConnection(url, userName, userPassword);
			con.setAutoCommit(false);
			connection.set(con);
			return con;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	//�ύ
	public static void commit() {
		Connection con = (Connection) connection.get();
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	//�ع�
	public static void rollback() {
		Connection con = (Connection) connection.get();
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	//�ͷ�����
	public synchronized static void releaseConnection(Connection connection) {

		try {
			if (connection != null && !connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = null;
	}
	
	
	
	
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	
	//���캯��
	public Database() {
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, userName, userPassword);
			st = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	
	//ִ�в�ѯ
	public ResultSet executeQuery(String sql) {
		try {
			rs = st.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	//����
	public int executeUpdate(String sql) {
		int ret = 0;
		try {
			ret = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	//�ر�����
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
