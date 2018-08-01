package com.lingnan.usersys.usermgr.view;

import java.util.Scanner;

import com.lingnan.usersys.common.util.CommonUtils;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 普通用户操作界面
 * @author Administrator
 *
 */
public class CommonUserFrame extends IndexFrame {
	
	/**
	 * 控制器
	 */
	private UserController controller = new UserController();
	
	private UserVO user = null;
	public CommonUserFrame(UserVO user) {
		this.user = user;
	}
	
	public CommonUserFrame() {
		
	}
	
	@Override
	public void show() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----------普通用户界面------------");
		System.out.println("1.查询个人信息");
		System.out.println("2.修改个人信息");
		System.out.println("3.退出");
		
		int choose = -1;
		choose = CommonUtils.getNumber(1, 3);
		
		switch (choose) {
			case 1:
				this.searcherShow();;
				this.show();
				break;
			
			case 2:
				System.out.println("用户信息为：");
				this.searcherShow();
				this.updateShow(user);
				break;
				
			case 3:
				System.out.println("欢迎再次使用，再见！");;
				break;
			default:
				break;
		}
		
	}


	@Override
	public void searcherShow() {
		
		System.out.println("----------个人信息-----------");
		user.scannerUserInfo();
		System.out.println();
	}

	@Override
	public void updateShow(UserVO _user) {
		boolean flag = false;
		int choose = -1;
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("1.更新用户名");
			System.out.println("2.更新密码");
			System.out.println("3.更新邮箱");
			System.out.println("4.更新电话");
			System.out.println("5.退出更新");
			choose = CommonUtils.getNumber(1, 5);
			if(choose == 5) {
				this.show();
				break;
			}
			switch (choose) {
				case 1:
					flag = false;
					System.out.println("请输入新的用户名：");
					String newName = scanner.nextLine();
					
					if(newName.equals(_user.getUsername())) {
						System.out.println("用户名一样，无需更新!");
					}else {
						_user.setUsername(newName);
						flag = controller.doUpdateUser(_user);
						if(flag) {
							System.out.println("更新成功!");
						}else {
							System.out.println("更新失败!");
						}
					}
					System.out.println();
					break;
					
				case 2:
					flag = false;
					
					System.out.println("请输入旧密码：");
					String oldPasswd = scanner.nextLine();
					
					if(oldPasswd.equals(_user.getPasswd())) {
						System.out.println("请输入新密码：");
						String newPasswd = scanner.nextLine();
						_user.setPasswd(newPasswd);
						flag = controller.doUpdateUser(_user);
						
						if(flag) {
							System.out.println("更新成功!");
						}else {
							System.out.println("更新失败!");
						}
					}else {
						System.out.println("旧密码输入错误!");
					}
					System.out.println();
					break;
					
				case 3:
					flag = false;
					String newEmail = null;
					while(true) {
						System.out.println("请输入新邮箱：");
						newEmail = scanner.nextLine();
						if(!TypeUtils.checkEmail(newEmail)) {
							System.out.println("请输入正确的邮箱!");
						}else {
							break;
						}
					}
					
					if(newEmail.equals(_user.getUsername())) {
						System.out.println("邮箱名一样，无需更新!");
					}else {
						_user.setEmail(newEmail);
						flag = controller.doUpdateUser(_user);
						if(flag) {
							System.out.println("更新成功!");
						}else {
							System.out.println("更新失败!");
						}
					}
					System.out.println();
					break;
				case 4:
					flag = false;
					String newPhone = null;
					while(true) {
						System.out.println("请输入新电话：");
						newPhone = scanner.nextLine();
						if(!TypeUtils.checkPhone(newPhone)) {
							System.out.println("请输入正确的手机号码!");
						}else {
							break;
						}
					}
					
					if(newPhone.equals(_user.getUsername())) {
						System.out.println("电话号码一样，无需更新!");
					}else {
						_user.setPhone(newPhone);
						flag = controller.doUpdateUser(_user);
						if(flag) {
							System.out.println("更新成功!");
						}else {
							System.out.println("更新失败!");
						}
					}
					System.out.println();
					break;
				default:
					break;
			}
		}
	}

}
