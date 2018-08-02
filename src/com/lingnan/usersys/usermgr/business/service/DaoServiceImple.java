package com.lingnan.usersys.usermgr.business.service;

import java.sql.Connection;
import java.util.List;

import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.business.dao.UserCheckVO;
import com.lingnan.usersys.usermgr.business.dao.UserDao;
import com.lingnan.usersys.usermgr.business.dao.UserDaoImpl;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class DaoServiceImple implements DaoServiceInter {
	
	private static final DaoServiceImple service = new DaoServiceImple();
	
	/**
	 * 私有化构造器
	 */
	private DaoServiceImple() {
		
	}
	
	/**
	 * 获取单例对象
	 * @return DaoServiceImple单例对象
	 */
	public static DaoServiceImple getInstance() {
		return service;
	}
	
	@Override
	public boolean addUser(UserVO user) {
		Connection connection = null;
		UserDao dao = null;
		boolean flag = false;
		try {
			connection = DBUtils.getConnection();
			dao = DaoFactory.getDao(UserDaoImpl.class, connection);
			DBUtils.setCommit(connection);
			flag = dao.addUser(user);
			DBUtils.putCommit(connection);
		} catch (Exception e) {
			DBUtils.rollbackTransaction(connection);
			e.printStackTrace();
		} finally {
			DBUtils.release(connection, null, null);
		}
		
		return flag;
	}

	@Override
	public UserVO login(String name, String password) {
		Connection connection = null;
		UserDao dao = null;
		UserVO user = null;
		
		try {
			connection = DBUtils.getConnection();
			dao = DaoFactory.getDao(UserDaoImpl.class, connection);
			user = dao.login(name, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(connection, null, null);
		}
		return user;
	}

	@Override
	public boolean updateUser(UserVO user) {
		Connection connection = null;
		UserDao dao = null;
		boolean flag = false;
		try {
			connection = DBUtils.getConnection();
			dao = DaoFactory.getDao(UserDaoImpl.class, connection);
			DBUtils.setCommit(connection);
			flag = dao.updateUser(user);
			DBUtils.putCommit(connection);
		} catch (Exception e) {
			DBUtils.rollbackTransaction(connection);
			e.printStackTrace();
		} finally {
			DBUtils.release(connection, null, null);
		}
		
		return flag;
	}

	@Override
	public boolean deleteUserById(int id) {
		Connection connection = null;
		UserDao dao = null;
		boolean flag = false;
		try {
			connection = DBUtils.getConnection();
			dao = DaoFactory.getDao(UserDaoImpl.class, connection);
			DBUtils.setCommit(connection);
			flag = dao.deleteUserById(id);
			DBUtils.putCommit(connection);
		} catch (Exception e) {
			DBUtils.rollbackTransaction(connection);
			e.printStackTrace();
		} finally {
			DBUtils.release(connection, null, null);
		}
		
		return flag;
	}

	@Override
	public UserVO findUserById(int id) {
		Connection connection = null;
		UserDao dao = null;
		UserVO user = null;
		
		try {
			connection = DBUtils.getConnection();
			dao = DaoFactory.getDao(UserDaoImpl.class, connection);
			user = dao.findUserById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(connection, null, null);
		}
		return user;
	}

	@Override
	public UserVO findUserByName(String name) {
		Connection connection = null;
		UserDao dao = null;
		UserVO user = null;
		
		try {
			connection = DBUtils.getConnection();
			dao = DaoFactory.getDao(UserDaoImpl.class, connection);
			user = dao.findUserByName(name);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(connection, null, null);
		}
		return user;
	}

	@Override
	public List<UserVO> findAllUser() {
		Connection connection = null;
		UserDao dao = null;
		List<UserVO> users = null;
		
		try {
			connection = DBUtils.getConnection();
			dao = DaoFactory.getDao(UserDaoImpl.class, connection);
			users = dao.findAllUser();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(connection, null, null);
		}
		return users;
	}

	@Override
	public List<UserVO> blurredSearch(UserCheckVO userCheck) {
		Connection connection = null;
		UserDao dao = null;
		List<UserVO> users = null;
		
		try {
			connection = DBUtils.getConnection();
			dao = DaoFactory.getDao(UserDaoImpl.class, connection);
			users = dao.blurredSearch(userCheck);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.release(connection, null, null);
		}
		return users;
	}

}
