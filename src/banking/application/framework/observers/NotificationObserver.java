package banking.application.framework.observers;

import banking.application.framework.models.AccountEntry;

public interface NotificationObserver {
    public void update(AccountEntry accountEntry);
}
