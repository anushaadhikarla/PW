package com.cg.account.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.account.bean.Account;
import com.cg.account.exception.AccountException;
import com.cg.account.service.AccountService;
import com.cg.account.service.AccountServiceImpl;

public class AccountDaoImplTest {

	AccountService accService=new AccountServiceImpl();

	@Test
	public void testCreateAccountMobile() {
		Account acc=new Account("897802745","Mark","mark@gmail.com",100);
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
		}
	@Test
	public void testCreateAccountName(){
		Account acc=new Account("8978027451","M1","mark@gmail.com",100);
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Name should contain only alphabets",e.getMessage());
		}
		
	}
	@Test
	public void testCreateAccountEmail(){
		Account acc=new Account("8978027451","Mark","mark@gmail",100);
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Invalid email id",e.getMessage());
		}
	}
	@Test
	public void testCreateAccountBalance(){
		Account acc=new Account("8978027451","Mark","mark@gmail.com",10);
		try {
			accService.createAccount(acc);
		} catch (AccountException e) {
			assertEquals("Amount is invalid",e.getMessage());
		}
	}
	@Test
	public void testCreateAccount(){
		Account acc=new Account("9878987909","Mani","mani@gmail.com",300);
		try {
			String ca=accService.createAccount(acc);
			assertNotNull(ca);
	
			
		} catch (AccountException e) {
			System.out.println(e.getMessage());
			
		}
	}
	@Test
	public void testShowBalanceNumber(){
	try {
		accService.showBalance("12345");
	} catch (AccountException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testShowBalanceNumberNotExist(){
		try {
			accService.showBalance("1234567890");
		} catch (AccountException e) {
			
			assertEquals("Account with mobile number 1234567890 does not exist",e.getMessage());
		}
	}
	@Test
	public void testShowBalancePrecision(){
		try {
			accService.showBalance("8978027451");
		} catch (AccountException e) {
			assertEquals(100,100,0.00);
		}
	}
	@Test
	public void testShowBalance(){
	
	try {
		double ac=accService.showBalance("9704865324");
		assertNotNull(ac);
	} catch (AccountException e) {
		System.out.println(e.getMessage());
		
	}
	}
	
	@Test
	public void testDepositNumberDoesNotExist(){
		try {
			accService.deposit("8978027450",100);
		} catch (AccountException e) {
			assertEquals("Account with mobile number 8978027450does not exist",e.getMessage());
		}
		
	}
	@Test
	public void testDepositNumberDigits(){
		try {
			accService.deposit("89780274",100);
		} catch (AccountException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
		
	}
	@Test
	public void testDepositAmount(){
		try {
			accService.deposit("8978027489",-10);
		} catch (AccountException e) {
			assertEquals("Enter valid amount, it must be greater than zero",e.getMessage());
		}
		
	}
	@Test
	public void testDeposit(){
	Account acc= new Account();
	acc.setMobileNo("8978027489");
	try {
		Account ac=accService.deposit(acc.getMobileNo(), 100);
		assertNotNull(ac);
	} catch (AccountException e) {
		System.out.println(e.getMessage());
		
	}
	}
	@Test
	public void testWithDrawNumberDigits(){
		try {
			accService.withDraw("89780274",100);
		} catch (AccountException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
		
	}
	@Test
	public void testWithDrawNumberDoesNotExist(){
		try {
			accService.withDraw("8978027450",100);
		} catch (AccountException e) {
			assertEquals("Account with mobile number 8978027450does not exist",e.getMessage());
		}
		
	}
	@Test
	public void testWithDrawAmount(){
		try {
			accService.withDraw("8978027489",-10);
		} catch (AccountException e) {
			assertEquals("Enter valid amount, it must be greater than zero",e.getMessage());
		}
	}
	@Test
	public void testWithDraw(){
	Account acc= new Account();
	acc.setMobileNo("8978027489");
	acc.setBalance(300);
	try {
		Account ac=accService.withDraw(acc.getMobileNo(), 300);
		assertNotNull(ac);
	} catch (AccountException e) {
		System.out.println(e.getMessage());
		
	}
	}
	@Test
	public void testFundTransferNumber1DoesNotExist(){
		try {
			accService.fundTransfer("8978027411","8978027434",100);
		} catch (AccountException e) {
			assertEquals("Account with mobile number 8978027411 does not exist",e.getMessage());
		}
		
	}
	@Test
	public void testFundTransferNumber2DoesNotExist(){
		try {
			accService.fundTransfer("8978027434","8978027400",100);
		} catch (AccountException e) {
			assertEquals("Account with mobile number 8978027400 does not exist",e.getMessage());
		}
		
	}
	@Test
	public void testFundTransferInvalidAmount(){
		try {
			accService.fundTransfer("9704865324","8978027434",500);
		} catch (AccountException e) {
			assertEquals("With draw amount should be less than available amount ",e.getMessage());
		}
		
	}
	@Test
	public void testFundTransferNegativeAmount(){
		try {
			accService.fundTransfer("9704865324","8978027434",-10);
		} catch (AccountException e) {
			assertEquals("Enter valid amount, it must be greater than zero",e.getMessage());
		}
		
	}
	@Test
	public void testFundTransferNumber1Digits(){
		try {
			accService.fundTransfer("97048653","8978027434",10);
		} catch (AccountException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testFundTransferAmountZero(){
		try {
			accService.fundTransfer("9704865324","8978027434",0);
		} catch (AccountException e) {
			assertEquals("Enter valid amount, it must be greater than zero",e.getMessage());
		}
		
	}
	@Test
	public void testFundTransferNumber2Digits(){
		try {
			accService.fundTransfer("97048653","89780274",10);
		} catch (AccountException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	@Test
	public void testFundTransferSameNumber(){
		try {
			accService.fundTransfer("8978027434","8978027434",10);
		} catch (AccountException e) {
			assertEquals("Mobile number should not be same",e.getMessage());
		}
	}
	@Test
	public void testFundTransfer(){
	
	try {
		Account ac=accService.fundTransfer("9704865324","8978027434",30);
		assertNotNull(ac);
	} catch (AccountException e) {
		System.out.println(e.getMessage());
		
	}
	}
	@Test
	public void testPrintTransactionsNumberDigits(){
		try {
			accService.printTransactions("89780274");
		} catch (AccountException e) {
			assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
		
	}
	@Test
	public void testPrintTransactionsNumberDoesNotExist(){
		try {
			accService.printTransactions("8978027401");
		} catch (AccountException e) {
			assertEquals("Account with mobile number 8978027401does not exist",e.getMessage());
		}
		
	}
	@Test
	public void testPrintTransactionsNotNull(){
	
	try {
		Account ac=accService.printTransactions("9704865324");
		assertNotNull(ac);
	} catch (AccountException e) {
		System.out.println(e.getMessage());
		
	}
	}
}
