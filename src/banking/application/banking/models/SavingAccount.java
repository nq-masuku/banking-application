package banking.application.banking.models;

import banking.application.banking.strategy.SavingInterestStrategy;
import banking.application.framework.enums.AccountType;
import banking.application.framework.models.Account;
import banking.application.framework.models.AccountEntry;
import banking.application.framework.models.Customer;

public class SavingAccount extends Account {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2193623630809619207L;

	public SavingAccount(String accountNumber, Customer customer, Double balance, AccountType accountType) {
        super(accountNumber, customer, balance, accountType);
        accountInterestStrategy = new SavingInterestStrategy();
    }

    @Override
    public void addAccountEntryAndNotify(Double moneyOnWithDrawOrDeposit, Double totalBalance) {
        AccountEntry accountEntry = new AccountEntry(moneyOnWithDrawOrDeposit, "new deposit", super.getAccountNumber());
        //for keeping track of the repository and withdraw

        getListOfAccountEntries().add(accountEntry);
        //When a deposit or withdrawal is done to a company account, the system sends the company an
        //Email about the transaction.
        if (getAccountType().equals(AccountType.COMPANY)) {
            notifyObservers(accountEntry);
        } else {
            if (moneyOnWithDrawOrDeposit > 500 || totalBalance < 0) {
                notifyObservers(accountEntry);
            }
        }
    }
}
