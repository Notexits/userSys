package com.lingnan.usersys.usermgr.business.dao;

import java.util.Date;

public class UserCheckVO {
	private String id;			//用户编号
	private String username;	//用户名
	private String passwd;	//密码
	private String hiredate;		//注册时间
	private String email;		//邮箱
	private String phone;		//电话
	private String rights; 		//权限
	private String status;		//状态
	@Override
	public String toString() {
		return "UserCheckVO [id=" + id + ", username=" + username + ", passwd=" + passwd + ", hiredate=" + hiredate
				+ ", email=" + email + ", phone=" + phone + ", rights=" + rights + ", status=" + status + "]";
	}
	public UserCheckVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserCheckVO(String id, String username, String passwd, String hiredate, String email, String phone,
			String rights, String status) {
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
	public String getId() {
		
		return id == null ? "%%":"%" + id + "%";
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username == null ? "%%":"%" + username + "%";
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		
		return passwd == null ? "%%":"%" + passwd + "%";
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getHiredate() {

		return hiredate == null ? "%%":"%" + hiredate + "%";
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getEmail() {

		return email == null ? "%%":"%" + email + "%";
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		
		return phone == null ? "%%":"%" + phone + "%";
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRights() {
		
		return rights == null ? "%%":"%" + rights + "%";
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	public String getStatus() {

		return status == null ? "%%":"%" + status + "%";
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
