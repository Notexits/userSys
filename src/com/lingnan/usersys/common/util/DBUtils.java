package com.lingnan.usersys.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtils {

	public static DataSource dataSource = null;
	
	static {
		dataSource = new ComboPooledDataSource("helloc3p0");
	}
	
	/**
	 * 获取数据库链接
	 * @return 返回一个 Connection 对象
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	/**
	 * 设置事务提交方式为手动提交
	 * @param connection 数据库连接对象
	 */
	public static void setCommit(Connection connection){
		if(connection != null) {
			try {
				connection.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 提交事务
	 * @param connection 数据库连接对象
	 */
	public static void putCommit(Connection connection) {
		if(connection != null) {
			try {
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 回滚事务
	 * @param connection 数据库连接对象
	 */
	public static void rollbackTransaction(Connection connection) {
		if(connection != null) {
			try {
				connection.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 依次释放ResultSet， Statement， Connection数据库链接
	 * @param connection 数据库连接对象
	 * @param statement SQL语句执行对象
	 * @param rs 结果集对象
	 */
	public static void release(Connection connection, Statement statement, ResultSet rs) {

		try {
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
