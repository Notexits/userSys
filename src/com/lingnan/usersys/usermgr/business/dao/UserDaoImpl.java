package com.lingnan.usersys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.lingnan.usersys.common.dao.DaoImplement;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 具体UserDao实现类
 * @author Administrator
 *
 */
public class UserDaoImpl extends DaoImplement<UserVO> implements UserDao{

	private Connection connection = null; // 数据库连接

	/**
	 * 构造方法
	 * @param connection 传入数据库连接
	 */
	public UserDaoImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	/**
	 * 登录
	 * @param name 传入用户id
	 * @param password 传入用户密码
	 * @return 返回用户id和密码是否匹配
	 */
	public UserVO login(String name, String password) {
		
		String sql = "select * from u_user where username = ? and passwd = ?";
		try {
			return (UserVO) get(connection, sql, name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 注册
	 * @param user 传入注册对象
	 * @return 返回是否注册成功
	 */
	@Override
	public boolean addUser(UserVO user) {
		String sql = "insert into u_user(username, "
				+ "passwd, email, phone, rights, status) values(?, ?, ?, ?, 0, 1)";
		int flag = 0;
		try {
			flag = update(connection, sql, user.getUsername(), 
					user.getPasswd(), user.getEmail(), user.getPhone());
			if(flag > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改用户信息
	 * @param user 传入用户信息
	 * @return 返回用户信息是否修改成功
	 */
	@Override
	public boolean updateUser(UserVO user) {
		String sql = "update u_user set username = ?, "
				+ "passwd = ?, email = ?, phone = ? where id = ?";
		int flag = 0;
		try {
			flag = update(connection, sql, user.getUsername(), 
					user.getPasswd(), user.getEmail(), user.getPhone(), user.getId());
			if(flag > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 根据用户id删除用户
	 * @param id 传入删除的用户id
	 * @return 返回是否删除成功
	 */
	@Override
	public boolean deleteUserById(int id) {
		String sql = "update u_user set status = 0 where id = ?";
		int flag = 0;
		try {
			flag = update(connection, sql, id);
			if(flag > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 按照用户id查询信息
	 * @param id 传入想要查找的用户id
	 * @return 返回查到的用户信息
	 */
	@Override
	public UserVO findUserById(int id) {
		String sql = "select * from u_user where id = ? and status = 1";
		try {
			return (UserVO)this.get(connection, sql, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 按照用户名字查询信息
	 * @param name 传入想要查找的用户名字
	 * @return 返回查找到的用户信息
	 */
	@Override
	public UserVO findUserByName(String name) {
		String sql = "select * from u_user where username = ? and status = 1";
		try {
			return (UserVO)this.get(connection, sql, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询所有用户的信息
	 * @return 返回查找到的用户信息集合
	 */
	@Override
	public List<UserVO> findAllUser() {
		String sql = "select * from u_user where status = 1";
		try {
			return this.getForList(connection, sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
