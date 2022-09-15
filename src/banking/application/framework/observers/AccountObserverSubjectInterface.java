package banking.application.framework.observers;

import banking.application.framework.models.AccountEntry;

public interface AccountObserverSubjectInterface {
    void registerObserver(NotificationObserver observer);
    void removeObserver(NotificationObserver observer);
    void notifyObservers(AccountEntry accountEntry);
}
