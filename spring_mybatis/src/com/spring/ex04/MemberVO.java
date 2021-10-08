package com.spring.ex04;

import java.util.Date;

// SQL문을 전달할 값이나 SQL문 실행 후 반환되는 레코드들의 값을 각 속성에 저장하는 역할을 하는 클래스
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	// Default Constructor
	public MemberVO() {
	}
	
	// Constructor 
	public MemberVO(String id, String pwd, String name, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	
	// Getter 
	
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	
	// Setter 
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	// toString
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", joinDate=" + joinDate
				+ "]";
	}
	
	
	
	
	
	
}
