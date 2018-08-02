package com.lingnan.usersys.usermgr.controller;

import java.util.List;

import com.lingnan.usersys.usermgr.business.dao.UserCheckVO;
import com.lingnan.usersys.usermgr.business.service.DaoServiceImple;
import com.lingnan.usersys.usermgr.domain.UserVO;

public class UserController {
	private DaoServiceImple service = DaoServiceImple.getInstance();
	
	/**
	 * 登录
	 * @param name 传入用户名
	 * @param password 传入用户密码
	 * @return 返回用户名和密码是否匹配
	 */
	public UserVO doLogin(String name, String password) {
		
		try {
			return service.login(name, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 注册
	 * @param user 传入注册对象
	 * @return 返回是否注册成功
	 */
	public boolean doAddUser(UserVO user) {
		try {
			return service.addUser(user);
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
	public boolean doUpdateUser(UserVO user) {
		try {
			return service.updateUser(user);
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
	public boolean doDeleteUserById(int id) {
		try {
			return service.deleteUserById(id);
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
	public UserVO doFindUserById(int id) {
		try {
			return service.findUserById(id);
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
	public UserVO doFindUserByName(String name) {
		try {
			return service.findUserByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 查询所有用户的信息
	 * @return 返回查找到的用户信息集合
	 */
	public List<UserVO> doFindAllUser(){
		try {
			return service.findAllUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 模糊查找方法
	 * @param user 存放查找信息的类
	 * @return 返回符合条件的结果集
	 */
	public List<UserVO> doBlurredSearch(UserCheckVO user){
		try {
			return service.blurredSearch(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
