package banking.application.ui.controller;

import java.util.Collection;

import banking.application.framework.models.Account;
import banking.application.framework.services.AccountService;
import banking.application.framework.services.AccountServiceImpl;

public class BankApplicationUIController {
	private static BankApplicationUIController controller = null;
	
	AccountService accountService = AccountServiceImpl.getInstance();
	
	private BankApplicationUIController() {
		
	}
	
	public Collection<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}
	
	public void deposit(String accountNumber,double amount, String description) {
		accountService.deposit(accountNumber, amount, description);
	}
	
	public void withdraw(String accountNumber,double amount ) {
		accountService.withdraw(accountNumber, amount);
	}
	
	public void addInterest(String accountNumber) {
		accountService.addInterest(accountNumber);
	}
	
	public void createAccount(Account account) {
		accountService.createAccount(account);
	}
	
	public static BankApplicationUIController getInstance() {
         if(controller == null) {
        	 controller =new BankApplicationUIController();
         }
         return controller;
	}
	
	

}
