package com.jeaeok.myproject.testApp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
		name="User",
		uniqueConstraints={
			@UniqueConstraint(
				columnNames={"userId"}
			)
		}
	)
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long num;
	private String userId;
	private String userName;
	private String userPassword;
	
	public User() {}
	public User(String userId,String userName,String userPassword) {
		this.userId=userId;
		this.userName=userName;
		this.userPassword=userPassword;
	}
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public boolean isAdmin() {
		return this.userId.equals("admin");
	}
	
	
}
