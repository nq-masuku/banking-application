package banking.application.banking.strategy;

import java.io.Serializable;

public class SavingInterestStrategy implements AccountInterestStrategy, Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1300996199371082132L;

	@Override
    public double calculateInterest(double balance) {
    	return 0.25 * balance;
    }
}
