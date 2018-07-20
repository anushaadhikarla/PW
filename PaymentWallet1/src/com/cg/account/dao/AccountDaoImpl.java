package com.cg.account.dao;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.account.bean.Account;
import com.cg.account.db.AccountDb;
import com.cg.account.exception.AccountException;

public class AccountDaoImpl implements AccountDao{
	static HashMap<String,Account> accMap=AccountDb.getAccdb();
	@Override
	public String createAccount(Account account) throws AccountException {
		if(accMap.containsKey(account.getMobileNo())){
			throw new AccountException("Account with mobile number" +account.getMobileNo()+ "already exists");
		}
		accMap.put(account.getMobileNo(), account);
		return account.getMobileNo();
		
	}

	@Override
	public double showBalance(String mobileNo) throws AccountException {
		Account acc=accMap.get(mobileNo);
		if(acc==null){
			throw new AccountException("Account with mobile number " +mobileNo+ " does not exist");
		}
		return acc.getBalance();
	}

	@Override
	public Account deposit(String mobileNo, double amount) throws AccountException {
		Account acc=accMap.get(mobileNo);
		double balance=0;
		if(acc==null){
			throw new AccountException("Account with mobile number " +mobileNo+ "does not exist");
		}
		else{
			balance=amount+acc.getBalance();
			acc.setBalance(balance);
			return acc;
			
		}
	}

	@Override
	public Account fundTransfer(String mobileNo1,String mobileNo2, double amount) throws AccountException {
		Account acc1=accMap.get(mobileNo1);
		Account acc2=accMap.get(mobileNo2);
		double balance=0;
		if(acc1==null){
			throw new AccountException("Account with mobile number " +mobileNo1+ " does not exist");
		}
		else if(acc2==null){
			throw new AccountException("Account with mobile number " +mobileNo2+ " does not exist");
		}
		else{
			if(amount<acc1.getBalance()){
				balance=acc1.getBalance()-amount;
				acc1.setBalance(balance);
			}
			else{
				throw new AccountException("With draw amount should be less than available amount ");
			}
		}
		
		return acc1;
		
		
	}

	@Override
	public Account withDraw(String mobileNo, double amount) throws AccountException {
		Account acc=accMap.get(mobileNo);
		double balance=0;
		if(acc==null){
			throw new AccountException("Account with mobile number " +mobileNo+ "does not exist");
		}
		else {
			if(amount<acc.getBalance()){
				balance=acc.getBalance()-amount;
				acc.setBalance(balance);
			}
				else {
					throw new AccountException("Amount is less than available amount ");
					
				}
				}
	return acc;	
		}

	@Override
	public Account printTransactions(String mobileNo) throws AccountException {
		Account acc= accMap.get(mobileNo);
		if(acc==null){
			throw new AccountException("Account with mobile number " +mobileNo+ "does not exist");
		}
		return acc;
	}
	}
