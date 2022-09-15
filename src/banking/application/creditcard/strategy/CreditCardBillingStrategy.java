package banking.application.creditcard.strategy;

public interface CreditCardBillingStrategy {
    double minimumPayment(double withdrawalAmount); //withdraw
        //to calculate Minimum Payment
    double monthlyPayment(double amountOwing, double amountPaying); //deposit
        //to calculate Monly Payment
    double getMonthlyInterest();
    double getMinimumPayment();

}
