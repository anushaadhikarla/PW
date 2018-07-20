package com.cg.account.service;

import com.cg.account.bean.Account;
import com.cg.account.dao.AccountDao;
import com.cg.account.dao.AccountDaoImpl;
import com.cg.account.exception.AccountException;

public class AccountServiceImpl implements AccountService {
AccountDao accountDao=new AccountDaoImpl();
	@Override
	public String createAccount(Account account) throws AccountException {
		if(validateNumber(account.getMobileNo()) && validateName(account.getName()) && validateEmailId(account.getEmailId())
				&& validateAmount(account.getBalance())){
			
			return accountDao.createAccount(account);
		}
		else 
			{
			throw new  AccountException("Invalid inputs to create account");
			}
			}
	

	@Override
	public double showBalance(String mobileNo) throws AccountException {
		if(!validateNumber(mobileNo)){
			throw new AccountException("Invalid mobile number");
			
		}
		
		else return accountDao.showBalance(mobileNo);
	}

	@Override
	public Account deposit(String mobileNo, double amount) throws AccountException {
		if(!validateNumber(mobileNo) && !validateAmount(amount)){
			throw new AccountException("Invalid inputs");
		}
		
		
		else return accountDao.deposit(mobileNo, amount);
	}

	@Override
	public Account fundTransfer(String mobileNo1,String mobileNo2, double amount) throws AccountException {
		if(!validateNumber(mobileNo1) && !validateNumber(mobileNo2) && !validateAmount(amount)){
			throw new AccountException("Invalid inputs");
			
		}
		
		else return accountDao.fundTransfer(mobileNo1, mobileNo2, amount);
	}

	@Override
	public Account withDraw(String mobileNo, double amount) throws AccountException {
		if(!validateNumber(mobileNo) && !validateAmount(amount)){
			throw new AccountException("Invalid inputs");
		}
		
		else return accountDao.withDraw(mobileNo, amount);
	}
	private boolean validateNumber(String mobileNo) throws AccountException{
		if(!mobileNo.matches("\\d{10}")){
			throw new AccountException("Mobile number should contain 10 digits");
		}
		else{
			return true;
		}
	}
    private boolean validateName(String name) throws AccountException{
    	if(!name.matches("[A-Z][a-z]{3,}")){
    		throw new AccountException("Name should contain only alphabets");
    	}
    	return true;
    }
    private boolean validateEmailId(String emailId) throws AccountException{
    	if(!emailId.matches("[a-z]{2,10}@{1}[a-z]{5}.com{1}")){
    		throw new AccountException("Invalid email id");
    		}
    
    	return true;
    }
    private boolean validateAmount(double amount) throws AccountException{
    	if(amount<=0){
    		throw new AccountException("Enter valid amount, it must be greater than zero");
    	}
    	return true;
    }


	@Override
	public Account printTransactions(String mobileNo) throws AccountException {
		if(validateNumber(mobileNo)){
			return accountDao.printTransactions(mobileNo)	;	
					}
		else{
			throw new AccountException("Mobile number does not exist");
		}
	}
    }
