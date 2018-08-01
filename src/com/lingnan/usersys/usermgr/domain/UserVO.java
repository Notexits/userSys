package com.lingnan.usersys.usermgr.domain;

import java.util.Date;

/**
 * 账号信息类
 * @author Administrator
 *
 */
public class UserVO {
	private int id;			//用户编号
	private String username;	//用户名
	private String passwd;	//密码
	private Date hiredate;		//注册时间
	private String email;		//邮箱
	private String phone;		//电话
	private int rights; 		//权限
	private int status;		//状态
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRights() {
		return rights;
	}
	public void setRights(int rights) {
		this.rights = rights;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", username=" + username + ", passwd=" + passwd + ", hiredate=" + hiredate
				+ ", email=" + email + ", phone=" + phone + ", rights=" + rights + ", status=" + status + "]";
	}
	public UserVO(int id, String username, String passwd, Date hiredate, String email, String phone, int rights,
			int status) {
		super();
		this.id = id;
		this.username = username;
		this.passwd = passwd;
		this.hiredate = hiredate;
		this.email = email;
		this.phone = phone;
		this.rights = rights;
		this.status = status;
	}
	
	public UserVO(String username, String passwd, String email, String phone) {
		this.username = username;
		this.passwd = passwd;
		this.email = email;
		this.phone = phone;
	}
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 浏览打印用户信息
	 */
	public void scannerUserInfo() {
		String identity = null;
		if(this.rights == 0) {
			identity = "普通用户";
		}else {
			identity = "管理员";
		}
		
		System.out.println("用户ID:" + this.id + "\t用户名: "+ this.username + "\t注册时间: " 
				+ this.hiredate + "\t邮箱: " + this.email 
					+ "\t联系电话: " + this.phone + "\t权限: " + identity);
	}
	
}
