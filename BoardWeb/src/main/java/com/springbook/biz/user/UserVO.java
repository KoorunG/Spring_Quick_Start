package com.springbook.biz.user;

// UserVO

public class UserVO {

	private String id;
	private String password;
	private String name;
	private String rold;
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getRold() {
		return rold;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRold(String rold) {
		this.rold = rold;
	}
	
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", rold=" + rold + "]";
	}
	
	
	
	
}
