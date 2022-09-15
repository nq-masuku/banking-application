package banking.application.framework.models;

import java.time.LocalDate;
import java.util.UUID;

public class AccountEntry {
    private String id = UUID.randomUUID().toString();
    private LocalDate date = LocalDate.now();
    private double amount;
    private String description;
    private String fromAccountNumber;
    private Account account;

    //TODO
    //Constructor for account entry in saving and checking account
    public AccountEntry(double amount, String description, String fromAccountNumber) {
        this.amount = amount;
        this.description = description;
        this.fromAccountNumber = fromAccountNumber;
    }
    //Constructor for credit card account entry
    public AccountEntry(LocalDate localDate,String accountNumber,double amount) {
        this.date = localDate;
        this.fromAccountNumber = accountNumber;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "AccountEntry{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", fromAccountNumber='" + fromAccountNumber + '\'' +
                ", account=" + account +
                '}';
    }
}
