package banking.application.framework.dataaccess;

import java.util.HashMap;

import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;


public interface AccountDAO { 
	HashMap<String,Account> retrieveAccounts();
	HashMap<String,Customer> retrieveCustomers();
	void saveAccount(Account account);
	void saveCustomer(Customer customer);
}
