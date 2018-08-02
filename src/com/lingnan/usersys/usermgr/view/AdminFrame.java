package com.lingnan.usersys.usermgr.view;

import java.util.List;
import java.util.Scanner;

import com.lingnan.usersys.common.util.CommonUtils;
import com.lingnan.usersys.usermgr.business.dao.UserCheckVO;
import com.lingnan.usersys.usermgr.controller.UserController;
import com.lingnan.usersys.usermgr.domain.UserVO;

/**
 * 管理员页面显示
 * @author Administrator
 *
 */
public class AdminFrame extends CommonUserFrame {
	public AdminFrame() {
		
	}
	
	public AdminFrame(UserVO user) {
		super(user);
		
	}
	
	/**
	 * 控制器
	 */
	private UserController controller = new UserController();
	@Override
	public void show() {
		System.out.println("----------管理员界面-----------");
		
		int choose = -1;
		while(true) {
			System.out.println("1.查询用户信息");
			System.out.println("2.更新用户信息");
			System.out.println("3.添加用户");
			System.out.println("4.删除用户");
			System.out.println("5.退出");
			choose = CommonUtils.getNumber(1, 5);
			
			if(choose == 5) {
				break;
			}
			
			switch (choose) {
			case 1:
				this.searcherShow();
				break;
			case 2:
				this.updateShow(null);
				break;
			case 3:
				this.addShow();
				break;
			case 4:
				this.deleteShow();
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void searcherShow() {
		Scanner scanner = new Scanner(System.in);
		int choose = -1;
		
		while(true) {
			System.out.println("1.查询所有用户");
			System.out.println("2.根据Id查询");
			System.out.println("3.根据用户名查询");
			System.out.println("4.模糊查询");
			System.out.println("5.退出查询");
			
			choose = CommonUtils.getNumber(1, 5);
			if(choose == 5) {
				break;
			}
			
			switch (choose) {
			case 1:
				List<UserVO> users = controller.doFindAllUser();
				System.out.println("所有用户信息如下：");
				for(UserVO user : users) {
					user.scannerUserInfo();
				}
				System.out.println();
				break;
			case 2:
				this.showUserInfoById();
				break;
			case 3:
				String username = null;
				UserVO user = null;
				System.out.print("请输入所查询的用户名：");
				username = scanner.nextLine();
				
				user = controller.doFindUserByName(username);
				if(user != null) {
					user.scannerUserInfo();
				}else {
					System.out.println("用户名为 " + username + "的用户不存在!");
				}
				break;
			case 4:
				System.out.print("请输入所查询的信息：");
				String searchInfo = scanner.nextLine();
				users = controller.doBlurredSearch(new UserCheckVO(searchInfo,
						searchInfo, searchInfo, searchInfo, searchInfo, searchInfo, searchInfo, searchInfo));
				System.out.println("符合条件的用户信息如下：");
				for(UserVO u : users) {
					u.scannerUserInfo();
				}
				System.out.println();
				break;
			default:
				break;
			}
		}
	}

	
	public void updateShow(UserVO _user) {
		_user = this.showUserInfoById();
		
		super.updateShow(_user);
		
	}

	/**
	 * 删除用户信息
	 */
	public void deleteShow() {
		Scanner scanner = new Scanner(System.in);
		UserVO user = this.showUserInfoById();
		
		boolean choose = false;
		System.out.println("是否确定删除？(Y/N)");
		if("N".equalsIgnoreCase(scanner.nextLine())) {
			choose = false;
		}else {
			choose = true;
		}
		
		if(choose) {
			boolean flag = controller.doDeleteUserById(user.getId());
			if(flag) {
				System.out.println("删除成功！");
			}else {
				System.out.println("删除失败！");
			}
		}
	}
	
	
	/**
	 * 根据用户ID查询用户信息
	 * @return 符合条件的用户
	 */
	private UserVO showUserInfoById() {
		Scanner scanner = new Scanner(System.in);
		int id = -1;
		UserVO user = null;
		while(true) {
			try {
				System.out.print("请输入用户Id:");
				id = scanner.nextInt();
				scanner.nextLine();
				break;
			} catch (Exception e) {
				System.out.println("请输入正确的用户Id!");
			}
		}
		
		user = controller.doFindUserById(id);
		if(user != null) {
			System.out.println("用户信息为：");
			user.scannerUserInfo();
		}else {
			System.out.println("Id为 " + id + "的用户不存在!");
		}
		
		return user;
	}
}
