package com.lingnan.usersys.common.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 访问数据的 DAO 接口. 
 * 里边定义好访问数据表的各种方法
 * @param T: DAO 处理的实体类的类型. 
 */
public interface DAO<T> {

	/**
	 * 批量处理的方法
	 * @param connection 数据库连接
	 * @param sql sql语句
	 * @param args: 填充占位符的 Object [] 类型的可变参数.
	 * @throws SQLException sql异常 
	 */  
	void batch(Connection connection, 
			String sql, Object [] ... args) throws SQLException;
	
	/**
	 * 查询一条记录的某个值，如姓名/年龄/记录总条数等
	 * @param connection：数据库连接
	 * @param sql：SQL语句
	 * @param objects：填充占位符的可变参数
	 * @return 返回一个具体的值
	 * @throws SQLException sql异常
	 */
	<E> E getForValue(Connection connection,
			String sql, Object ... objects) throws SQLException;
	
	/**
	 * 返回符合条件的所以记录的一个集合
	 * @param connection：数据库连接
	 * @param sql：SQL语句
	 * @param objects：填充占位符的可变参数
	 * @return 返回一个包含有所有记录对象的List容器
	 * @throws SQLException sql异常
	 */
	<T> List<T> getForList(Connection connection,
			String sql, Object...objects) throws SQLException;
	
	/**
	 * 返回符合条件的第一条记录的对象
	 * @param connection：数据库链接
	 * @param sql：SQL语句
	 * @param objects：填充占位符的可变参数
	 * @return 返回一个符合条件的对象
	 * @throws SQLException sql异常
	 */
	T get(Connection connection,
			String sql, Object...objects) throws SQLException;
	
	/**
	 * 可以执行insert、update、delete操作
	 * @param connection：数据库链接
	 * @param sql：SQL语句
	 * @param objects：填充占位符的可变参数
	 * @return 返回影响的行数
	 * @throws SQLException sql异常
	 */
	int update(Connection connection,
			String sql, Object...objects) throws SQLException;


}
