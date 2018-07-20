package com.cg.account.bean;

import java.time.LocalDateTime;

public class Account {
	private String name;
	private String mobileNo;
	private String emailId;
	private double balance;
	public Account(String mobileNo, String name, String emailId, double balance) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.balance = balance;
	}
	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}


	


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
