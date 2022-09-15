package banking.application.creditcard.models;

import banking.application.creditcard.strategy.*;
import banking.application.framework.enums.AccountType;
import banking.application.framework.enums.CreditCardType;
import banking.application.framework.models.Account;
import banking.application.framework.models.AccountEntry;
import banking.application.framework.models.Customer;
import banking.application.framework.observers.NotificationObserver;

import java.time.LocalDate;

public class CreditCard extends Account implements NotificationObserver {

    /**
     *
     */
    private static final long serialVersionUID = -5544177350265007172L;

    private Double minimumPaymentAmount;
    private Double amountOwing;
    private CreditCardType creditCardType;
    protected CreditCardBillingStrategy billingStrategy;

    public CreditCard(String accountNumber, Customer customer, Double balance,
                      AccountType accountType, CreditCardType creditCardType) {
        super(accountNumber, customer, balance, accountType);
        this.creditCardType = creditCardType;
        accountInterestStrategy = new CreditCardInterestStrategy();

        //Instantiate the correct strategy based on credit card type
        if (creditCardType.equals(CreditCardType.GOLD)) {
            billingStrategy = new GoldBillingStrategy();
        } else if (creditCardType.equals(CreditCardType.SILVER)) {
            billingStrategy = new SilverBillingStrategy();
        } else {
            billingStrategy = new BronzeBillingStrategy();
        }
    }

    public Double getMinimumPaymentAmount() {
        return minimumPaymentAmount;
    }

    public void setMinimumPaymentAmount(Double minimumPaymentAmount) {
        this.minimumPaymentAmount = minimumPaymentAmount;
    }

    public Double getAmountOwing() {
        return amountOwing;
    }

    public void setAmountOwing(Double amountOwing) {
        this.amountOwing = amountOwing;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    @Override
    public void update(AccountEntry accountEntry) {
        if (accountEntry.getDescription().contains("deposit")) {
            double newAmountOwing = amountOwing - accountEntry.getAmount();
            newAmountOwing += billingStrategy.monthlyPayment(newAmountOwing, accountEntry.getAmount());

            setAmountOwing(newAmountOwing); //set new amount owing with added interest
        } else {
            minimumPaymentAmount += billingStrategy.minimumPayment(accountEntry.getAmount());
        }


    }

    //for keeping track for the history of charges and payment
    public void addAccountEntryAndNotify(Double moneyOnWithDrawOrDeposit, Double totalMoney) {
        //Why localDate.now? because we will record the account history based on the time that account is operated
        //AccountEntry accountEntry = new AccountEntry(LocalDate.now(), super.getAccountNumber(), moneyOnWithDrawOrDeposit);
        //for keeping track for the history of charges and payment
       // getListOfAccountEntries().add(accountEntry);
       // if (totalMoney < 0 || moneyOnWithDrawOrDeposit > 400) {
            //notifyObservers(accountEntry);
        //}
    }

	public CreditCardBillingStrategy getBillingStrategy() {
		return billingStrategy;
	}

	public void setBillingStrategy(CreditCardBillingStrategy billingStrategy) {
		this.billingStrategy = billingStrategy;
	}
    
}
