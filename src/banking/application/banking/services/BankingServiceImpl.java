package banking.application.banking.services;

import java.util.Collection;

import banking.application.framework.models.Account;
import banking.application.framework.services.AccountService;
import banking.application.framework.services.AccountServiceImpl;

public class BankingServiceImpl{
	private AccountService accountServiceHandler = AccountServiceImpl.getInstance();
	
    public void createAccount(Account account) {
    	accountServiceHandler.createAccount(account);
    }
    public void deposit(String accountNumber,double amount, String description) {
    	accountServiceHandler.deposit(accountNumber, amount, description);
    }
    public void withdraw(String accountNumber,double amount ) {
    	accountServiceHandler.withdraw(accountNumber, amount);
    }
    public Collection<Account> getAllAccounts(){
    	return accountServiceHandler.getAllAccounts();
    }
    
    public Account getAccountById(String accountNumber) {
    	return accountServiceHandler.getAccountById(accountNumber);
    }
    //call for the banking service
    public String generateReportForParticularAccount(String accountNumber){
        return accountServiceHandler.generateReportForBankingAndSavingAccounts(accountNumber);
    }
  }
