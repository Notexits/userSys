package com.lingnan.usersys.common.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.lingnan.usersys.common.util.ReflectionUtils;

public class DaoImplement<T> implements DAO{

	private QueryRunner queryRunner = null;
	private Class<T> type = null;
	
	public DaoImplement() {
		queryRunner = new QueryRunner();
		type = ReflectionUtils.getSuperGenericType(getClass());
	}
	@Override
	public void batch(Connection connection, String sql, Object[]... args) throws SQLException {
		queryRunner.batch(connection, sql, args);	
	}

	@Override
	public Object getForValue(Connection connection, String sql, Object... args) throws SQLException {
		return queryRunner.query(connection, sql, new ScalarHandler(), args);
	}

	@Override
	public List<T> getForList(Connection connection, String sql, Object... objects) throws SQLException {
		return queryRunner.query(connection, sql, 
				new BeanListHandler<>(type), objects);
	}

	@Override
	public Object get(Connection connection, String sql, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		return queryRunner.query(connection, sql, new BeanHandler<>(type), objects);
	}

	@Override
	public int update(Connection connection, String sql, Object... objects) throws SQLException {
		// TODO Auto-generated method stub
		return queryRunner.update(connection, sql, objects);
	}
	
}
