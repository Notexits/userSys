package com.lingnan.usersys.usermgr.business.dao;

import java.util.List;
import java.util.Vector;

import com.lingnan.usersys.common.dao.BaseDao;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * account表方法接口类
 * @author Administrator
 *
 */
public interface UserDao extends BaseDao {
	
	/**
	 * 注册
	 * @param user 注册的用户信息
	 * @return 返回是否注册成功
	 */
	public boolean addUser(UserVO user);
	
	/**
	 * 登录
	 * @param name 传入用户id
	 * @param password 传入用户密码
	 * @return	返回用户id和密码是否匹配
	 */
	public UserVO login(String name, String password);
	
	/**
	 * 修改用户信息
	 * @param user 更新的用户信息
	 * @return 返回用户信息是否修改成功
	 */
	public boolean updateUser(UserVO user);
	
	/**
	 * 根据用户id删除用户
	 * @param id 传入删除的用户id
	 * @return 返回是否删除成功
	 */
	public boolean deleteUserById(int id);
	
	/**
	 * 按照用户id查询信息
	 * @param id 传入想要查找的用户id
	 * @return 返回查到的用户信息
	 */
	public UserVO findUserById(int id);
	
	/**
	 * 按照用户名字查询信息
	 * @param name 传入想要查找的用户名字
	 * @return 返回查找到的用户信息
	 */
	public UserVO findUserByName(String name);
	
	/**
	 * 查找所有用户信息
	 * @return 返回保存所有用户信息的动态数组
	 */
	public List<UserVO> findAllUser();
	
	
	/**
	 * 模糊查找方法
	 * @param userCheck 存放查找信息的类
	 * @return 返回符合条件的结果集
	 */
	public List<UserVO> blurredSearch(UserCheckVO userCheck);
	
	
}
