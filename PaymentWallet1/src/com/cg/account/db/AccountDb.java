package com.cg.account.db;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

import com.cg.account.bean.Account;


public class AccountDb {
	private static HashMap<String,Account> accdb=new HashMap<String,Account>();
	public static HashMap<String,Account> getAccdb(){
		return accdb;

	}
	static{
		accdb.put("9704865324",new Account("9704865324","Mark","mark@gmail.com",100));
		accdb.put("8978027434",new Account("8978027434","Sara","sara@gmail.com",200));
		accdb.put("8978027489",new Account("8978027489","John","john@gmail.com",300));
	
}
}
