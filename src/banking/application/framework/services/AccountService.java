package banking.application.framework.services;

import java.util.Collection;
import java.util.List;

import banking.application.framework.models.Account;

public interface AccountService {
	  void createAccount(Account account);
	    void deposit(String accountNumber,double amount, String description);
	    void withdraw(String accountNumber,double amount );
	    Collection<Account> getAllAccounts();
	    Account getAccountById(String accountNumber);
	    String generateReportForBankingAndSavingAccounts(String accountNumber);
	    String generateMonthlyBillingReportsForCreditCard(String accountNumber);
	    void addInterest(String accountNumber);
	    String[] getAccountDetails(Account account);
	    List<Account> getAllAccountsBasedOnTheSpecificCustomer(String customerName);
}
