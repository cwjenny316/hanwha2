package com.hanwha.myapp;

public class UserDTO {
	//form 안에 이름과 같아야 한다.
	Integer userid;
	String username;
	//java beans 기술 사용 조건 : def ault 생성자, 게터세터
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username + "]";
	}
	

	
	
	

}
