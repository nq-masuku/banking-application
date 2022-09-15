package banking.application.framework.dataaccess;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;


public class AccountDAOHandler implements AccountDAO {
	
	enum StorageType {
		ACCOUNTS, CUSTOMERS, CHECKOURECORDENTRIES;
	}
	
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\banking\\application\\framework\\dataaccess\\storage";
	
	public static final String DATE_PATTERN = "MM/dd/yyyy";	

	
	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}
	
	
	
	final static class Pair<S,T> implements Serializable{
		
		S first;
		T second;
		Pair(S s, T t) {
			first = s;
			second = t;
		}
		@Override 
		public boolean equals(Object ob) {
			if(ob == null) return false;
			if(this == ob) return true;
			if(ob.getClass() != getClass()) return false;
			@SuppressWarnings("unchecked")
			Pair<S,T> p = (Pair<S,T>)ob;
			return p.first.equals(first) && p.second.equals(second);
		}
		
		@Override 
		public int hashCode() {
			return first.hashCode() + 5 * second.hashCode();
		}
		@Override
		public String toString() {
			return "(" + first.toString() + ", " + second.toString() + ")";
		}
		private static final long serialVersionUID = 5399827794066637059L;
	}



	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Account> retrieveAccounts() {
		return (HashMap<String,Account>) readFromStorage(StorageType.ACCOUNTS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Customer> retrieveCustomers() {
		return (HashMap<String,Customer>) readFromStorage(StorageType.CUSTOMERS);
	}

	@Override
	public void saveAccount(Account account) {
		saveCustomer(account.getCustomer());
		
		HashMap<String, Account> accounts = retrieveAccounts();
		String accountNumber = account.getAccountNumber();
		accounts.put(accountNumber, account);
		saveToStorage(StorageType.ACCOUNTS, accounts);	
	}

	@Override
	public void saveCustomer(Customer customer) {
		HashMap<String, Customer> books = retrieveCustomers();
		String custId = customer.getCustomerId();
		books.put(custId, customer);
		saveToStorage(StorageType.CUSTOMERS, books);

	}
	
	
	
	/**
	 * This block below is for testing purposes
	 * 
	 * */
	
	static void loadAccounts(List<Account> accountList) {
		HashMap<String, Account> accounts = new HashMap<String, Account>();
		accountList.forEach(acc -> accounts.put(acc.getAccountNumber(), acc));
		saveToStorage(StorageType.ACCOUNTS, accounts);
	}
	
	static void loadCustomers(List<Customer> custList) {
		HashMap<String, Customer> customers = new HashMap<String, Customer>();
		custList.forEach(cust -> customers.put(cust.getCustomerId(), cust));
		saveToStorage(StorageType.CUSTOMERS, customers);
	}
	
	
}
