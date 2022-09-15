package banking.application.framework.observers;

import banking.application.framework.models.AccountEntry;

public interface DisplayNotification {
    void display(AccountEntry accountEntry);
}
