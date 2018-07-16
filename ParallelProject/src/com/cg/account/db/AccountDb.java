package com.cg.account.db;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.account.bean.Account;

public class AccountDb {

	private static HashMap<String,Account> accountDb=new HashMap<String,Account>();
	public static HashMap<String, Account> getAccountMap() {
		return accountDb;
		}
	Account obj=new Account();
	static{
		 
		accountDb.put("9989796959",new Account("9989796959","Ramesh","ramesh@gmail.com",3000.0,LocalDateTime.now()));
		accountDb.put("9876543210",new Account("9876543210","John","john@gmail.com",2000.0,LocalDateTime.now()));
		accountDb.put("9849228579",new Account("9849228579","Hemanth","hemanth@gmail.com",1500.0,LocalDateTime.now()));
		accountDb.put("9441674879",new Account("9441674879","Mahesh","mahesh@gmail.com",4000.0,LocalDateTime.now()));
		}
}
