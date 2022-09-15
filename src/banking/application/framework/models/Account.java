package banking.application.framework.models;

import banking.application.banking.strategy.AccountInterestStrategy;
import banking.application.framework.enums.AccountType;
import banking.application.framework.observers.AccountObserverSubjectInterface;
import banking.application.framework.observers.NotificationObserver;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Serializable, AccountObserverSubjectInterface {
    //That will be in account service
//    abstract void depositMoney();
//    abstract void withdrawMoney();

    /**
     *
     */
    private static final long serialVersionUID = 7998092388498016664L;
    private String accountNumber;//modify name of the id
    private Customer customer;
    private AccountType accountType;
    private List<AccountEntry> listOfAccountEntries = new ArrayList<>();
    private Double balance;
    protected AccountInterestStrategy accountInterestStrategy;

    private List<NotificationObserver> observers;
    //private Double amount;

    public Account(String accountNumber, Customer customer, Double balance, AccountType accountType) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
        this.accountType = accountType;
    }

    public void addAccountEntry(AccountEntry accountEntry) {
        if (null == accountEntry) {
            listOfAccountEntries = new ArrayList<>();
        }
        this.listOfAccountEntries.add(accountEntry);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public List<AccountEntry> getListOfAccountEntries() {
        return listOfAccountEntries;
    }


    public Double depositMoney(Double addedMoney) {
        balance += addedMoney;
        //call the method after the balance operation of depositing money
        AccountEntry accountEntry = new AccountEntry(LocalDate.now(), accountNumber, addedMoney);
      // listOfAccountEntries.add(accountEntry);
        addAccountEntryAndNotify(addedMoney, balance);
        return balance;
    }

    public Double withdrawMoney(Double withDrawMoney) {
        balance -= withDrawMoney;
        //call the method after the balance operation of
        AccountEntry accountEntry = new AccountEntry(LocalDate.now(), accountNumber, withDrawMoney);
        //listOfAccountEntries.add(accountEntry);
        addAccountEntryAndNotify(withDrawMoney, balance);
        return balance;
    }

    public abstract void addAccountEntryAndNotify(Double moneyOnWithDrawOrDeposit, Double totalBalance);

    public void getReports() {
        System.out.println();
    }

    public Double getBalance() {
        // return listOfAccountEntries.stream().mapToDouble(e -> e.getAmount()).sum();
        return balance;
    }

    public Account addInterest() {
        //new balance= balance+interest.
        balance += accountInterestStrategy.calculateInterest(balance);
        return this;
    }

    public void setAccountInterestStrategy(AccountInterestStrategy accountInterestStrategy) {
        this.accountInterestStrategy = accountInterestStrategy;
    }


    //-------------------------
    @Override
    public void registerObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(NotificationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(AccountEntry accountEntry) {

        observers.forEach(e -> e.update(accountEntry));
    }

}
