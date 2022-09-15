package banking.application.creditcard.strategy;

import java.io.Serializable;

public class SilverBillingStrategy implements CreditCardBillingStrategy, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1491362873155836937L;

	@Override
	public double minimumPayment(double withdrawalAmount) {
		return withdrawalAmount * getMinimumPayment();
	}

	@Override
	public double monthlyPayment(double amountOwing, double amountPaying) {
		return (amountOwing - amountPaying) * getMonthlyInterest();
	}

	@Override
	public double getMonthlyInterest() {
		return 0.08;
	}

	@Override
	public double getMinimumPayment() {
		return 0.12;
	}

}
