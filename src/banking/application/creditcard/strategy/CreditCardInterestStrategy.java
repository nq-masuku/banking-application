package banking.application.creditcard.strategy;

import java.io.Serializable;

import banking.application.banking.strategy.AccountInterestStrategy;

public class CreditCardInterestStrategy implements AccountInterestStrategy, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6367049569701077724L;

	@Override
    public double calculateInterest(double balance) {
    	return 0;
    }
}
