package banking.application.banking.strategy;

import java.io.Serializable;

public class CheckingInterestStrategy implements AccountInterestStrategy, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1605723347573277854L;

	@Override
    public double calculateInterest(double balance) {
        return 0.15 * balance;
    }
}
