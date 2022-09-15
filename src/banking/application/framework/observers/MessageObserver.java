package banking.application.framework.observers;

import banking.application.framework.models.Account;
import banking.application.framework.models.AccountEntry;

public class MessageObserver implements NotificationObserver,DisplayNotification{
    private Account concreteAccountSubject;
    // private AccountEntry accountEntry;

    public MessageObserver(Account concreteAccountSubject) {
        this.concreteAccountSubject = concreteAccountSubject;
        concreteAccountSubject.registerObserver(this);
    }

    @Override
    public void update(AccountEntry accountEntry) {
//        this.accountEntry = accountEntry;
        display(accountEntry);
    }


    @Override
    public void display(AccountEntry accountEntry) {
        System.out.println("Message Notification : your account number of money amount is " + accountEntry.getAmount());
    }

}
