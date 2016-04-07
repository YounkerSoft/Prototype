package com.xxx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author yuan
 *
 * @date 2016年4月7日 下午7:13:03
 */
public class Database {
	
	//数据库驱动
	final public static String driverName = "com.mysql.jdbc.Driver";
	//数据库访问URL
	final public static String url = "jdbc:mysql://localhost:3306/mes";
	//数据库访问用户名
	final public static String userName = "root";
	//数据库访问口令
	final public static String userPassword = "";

	@SuppressWarnings("rawtypes")
	private static ThreadLocal connection = new ThreadLocal();


	/**
	 * 取得数据库连接
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

		//直接使用JDBC驱动连接
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

	
	//提交
	public static void commit() {
		Connection con = (Connection) connection.get();
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	//回滚
	public static void rollback() {
		Connection con = (Connection) connection.get();
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	//释放连接
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
	
	
	//构造函数
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

	
	//执行查询
	public ResultSet executeQuery(String sql) {
		try {
			rs = st.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	//更新
	public int executeUpdate(String sql) {
		int ret = 0;
		try {
			ret = st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	//关闭连接
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
