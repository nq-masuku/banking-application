package banking.application.framework.dataaccess;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import banking.application.creditcard.models.CreditCard;
import banking.application.framework.enums.AccountType;
import banking.application.framework.enums.CreditCardType;
import banking.application.framework.models.Account;
import banking.application.framework.models.Address;
import banking.application.framework.models.Customer;

/**
 * This class loads data into the data repository and also
 * sets up the storage units that are used in the application.
 * The main method in this class must be run once (and only
 * once) before the rest of the application can work properly.
 * It will create three serialized objects in the dataaccess.storage
 * folder.
 * 
 *
 */
public class TestData {
	
	
	public static void main(String[] args) {
		TestData td = new TestData();
		td.loadData();	
		AccountDAO da = new AccountDAOHandler();
		//System.out.println(da.retrieveAccounts());
		//System.out.println(da.retrieveCustomers());
	}
	///create books
	public void loadData() {
		AccountDAOHandler.loadAccounts(allAccounts);
		AccountDAOHandler.loadCustomers(allCustomers);
	}
	


	@SuppressWarnings("serial")
	List<Account> allAccounts = new ArrayList<Account>() {
		{
			
			 add(new CreditCard("426353", new
			 Customer("James1994-03-16","James","bmz@gmail.com", new
			 Address("100 N 4th st","Fairfield","Iowa","56452"),LocalDate.now()), 500.00,
			 AccountType.PERSONAL, CreditCardType.GOLD));
			 
			add(new CreditCard("645672",
					new Customer("App1994-03-16","Apple Inc","apple@gmail.com", 
							new Address("100 N 4th st","Fairfield","Iowa","56452"),LocalDate.now()),
					500.00, AccountType.COMPANY, CreditCardType.SILVER));
	
		}
	};
	
	@SuppressWarnings("serial")
	List<Customer> allCustomers = new ArrayList<Customer>() {
		{
			
			 add(new Customer("James1994-03-16","James","bmz@gmail.com", 
					 new Address("100 N 4th st","Fairfield","Iowa","56452"),LocalDate.now()));
			 
			add(new Customer("App1994-03-16","Apple Inc","apple@gmail.com", 
							new Address("100 N 4th st","Fairfield","Iowa","56452"),LocalDate.now()));
	
		}
	};

}
