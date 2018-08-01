package com.lingnan.usersys.usermgr.view;

import java.util.Scanner;

import com.lingnan.usersys.common.exception.NumberChooseException;
import com.lingnan.usersys.common.util.CommonUtils;
import com.lingnan.usersys.common.util.TypeUtils;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 开始页面显示
 * @author Administrator
 *
 */
public class IndexFrame implements BaseFrame{
	private UserController contrl = new UserController();
	
	@Override
	public void show() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("***********************************");
		System.out.println("*\t \t \t \t  *");
		System.out.println("*\t     欢迎使用用户管理系统 \t  \t  *");
		System.out.println("*\t \t \t \t  *");
		System.out.println("***********************************");
		System.out.println("1.登录 \t \t \t 2.注册");
		
		int choose = -1;
		choose = CommonUtils.getNumber(1, 2);
		
		switch (choose) {
			case 1:
				this.doLogin();
				break;
			
			case 2:
				this.addShow();
				this.doLogin();
				break;
			default:
				break;
		}
	}

	/**
	 * 登录页面
	 * @return 返回登录成功的用户
	 */
	public UserVO doLogin() {
		Scanner scanner = new Scanner(System.in);
		String name = null;
		String passwd = null;
		UserVO user = null;
		System.out.println("-------------登录页面-------------");
		boolean choose = true;
		while(choose) {
			try {
				System.out.println("请输入用户名：");
				name = scanner.nextLine();
				System.out.println("请输入密码：");
				passwd = scanner.nextLine();
				System.out.println("登录中...");
				user = contrl.doLogin(name, passwd);
				
				if(user != null) {
					System.out.println("登录成功!");
					if(user.getRights() == 0) {
						//调用普通页面
						System.out.println(user.getUsername()+"你好，你的权限为：普通用户");
						CommonUserFrame commonUserFrame = new CommonUserFrame(user);
						commonUserFrame.show();
						
					}else {
						//调用管理页面
						System.out.println(user.getUsername()+"你好，你的权限为：管理员");
						AdminFrame adminFrame = new AdminFrame();
						adminFrame.show();
					}
					break;
				}else {
					System.out.println("登录失败！账号或密码错误！");
					System.out.print("是否重新登录？(Y/N):");
					if("N".equalsIgnoreCase(scanner.nextLine())) {
						choose = false;
						this.show();
					}else {
						choose = true;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return user;
	}
	
	/**
	 * 注册页面
	 */
	@Override
	public void addShow() {
		Scanner scanner = new Scanner(System.in);
		String name = null;
		String passwd = null;
		String passwdAgain = null;
		String email = null;
		String phone = null;
		
		System.out.println("-----------注册页面-----------");
		try {
			System.out.println("请输入用户名：");
			name = scanner.nextLine();
			
			while(true) {
				
				System.out.println("请输入密码：");
				passwd = scanner.nextLine();
				
				System.out.println("请确认密码：");
				passwdAgain = scanner.nextLine();
				
				if(passwd.equals(passwdAgain)) {
					break;
				}else {
					System.out.println("两次密码输入不一致，请重新输入!");
				}
			}
			
			while(true) {
				System.out.println("请输入邮箱：");
				email = scanner.nextLine();
				if(TypeUtils.checkEmail(email)) {
					break;
				}else {
					System.out.println("请输入正确的邮箱！");
				}
			}
			
			while(true) {
				System.out.println("请输入电话号码：");
				phone = scanner.nextLine();
				if(TypeUtils.checkPhone(phone)) {
					break;
				}else {
					System.out.println("请输入正确的电话号码！");
				}
			}
			
			System.out.println("正在注册中...");
			boolean flag = true;
			while(flag) {
				flag = contrl.doAddUser(new UserVO(name, passwdAgain, email, phone));
				if(!flag) {
					System.out.println("注册失败!是否重新注册？(Y/N):");
					if("N".equalsIgnoreCase(scanner.nextLine())) {
						flag = false;
					}else {
						flag = true;
					}
				}else {
					System.out.println("注册成功！");
					System.out.println("新账号为："+ name + "\n");
					
					break;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void searcherShow() {
		
		
	}

	@Override
	public void updateShow(UserVO _user) {
		
		
	}

}
