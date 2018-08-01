package com.lingnan.usersys.common.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lingnan.usersys.common.dao.DaoFactory;
import com.lingnan.usersys.common.util.DBUtils;
import com.lingnan.usersys.usermgr.business.dao.UserDao;
import com.lingnan.usersys.usermgr.business.dao.UserDaoImpl;
import com.lingnan.usersys.usermgr.domain.UserVO;

class UserDaoImplTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testLogin() {
		Connection connection = DBUtils.getConnection();
		UserDao dao = DaoFactory.getDao(UserDaoImpl.class, connection);
		UserVO user = dao.login("Mr.Chen", "123456");
		System.out.println(user);
	}

	@Test
	void testAddUser() {
		Connection connection = DBUtils.getConnection();
		UserDao dao = DaoFactory.getDao(UserDaoImpl.class, connection);
		boolean flag = dao.addUser(new UserVO("张三", "123456", "245687421@qq.com", "12345678901"));
		System.out.println(flag);
	}

	@Test
	void testUpdateUser() {
		Connection connection = DBUtils.getConnection();
		UserDao dao = DaoFactory.getDao(UserDaoImpl.class, connection);
		boolean flag = dao.updateUser(new UserVO(1, "MRYT", "123456", null, "245687421@qq.com", "12345678901", 1, 1));
		System.out.println(flag);
	}

	@Test
	void testDeleteUserById() {
		Connection connection = DBUtils.getConnection();
		UserDao dao = DaoFactory.getDao(UserDaoImpl.class, connection);
		boolean flag = dao.deleteUserById(5);
		System.out.println(flag);
	}

	@Test
	void testFindUserById() {
		Connection connection = DBUtils.getConnection();
		UserDao dao = DaoFactory.getDao(UserDaoImpl.class, connection);
		UserVO user = dao.findUserById(5);
		System.out.println(user);
	}

	@Test
	void testFindUserByName() {
		Connection connection = DBUtils.getConnection();
		UserDao dao = DaoFactory.getDao(UserDaoImpl.class, connection);
		UserVO user = dao.findUserByName("MrYT");
		System.out.println(user);
	}

	@Test
	void testFindAllUser() {
		Connection connection = DBUtils.getConnection();
		UserDao dao = DaoFactory.getDao(UserDaoImpl.class, connection);
		List<UserVO> users = dao.findAllUser();
		for(UserVO user : users) {
			System.out.println(user);
		}
	}

}
