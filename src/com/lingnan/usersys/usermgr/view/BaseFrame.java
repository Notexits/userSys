package com.lingnan.usersys.usermgr.view;

import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 页面显示接口
 * @author Administrator
 *
 */
public interface BaseFrame {
	
	/**
	 * 总页面显示
	 */
	public void show();
	
	/**
	 * 添加用户页面
	 */
	public void addShow();
	
	/**
	 * 查询页面
	 */
	public void searcherShow();
	
	/**
	 * 更新页面
	 * @param _user TODO
	 */
	public void updateShow(UserVO _user);
}
