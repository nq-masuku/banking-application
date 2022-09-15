package banking.application.creditcard.strategy;

import java.io.Serializable;

public class BronzeBillingStrategy implements CreditCardBillingStrategy, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8459261032087826549L;

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
        return 0.1;
    }

    @Override
    public double getMinimumPayment() {
        return 0.14;
    }


}
