package banking.application.framework.models;

import java.time.LocalDate;

public class IndividualCustomer extends Customer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1478367162624182655L;

	public IndividualCustomer(String customerId,String name, String email, Address address, LocalDate birthDate) {
        super(customerId,name, email, address, birthDate);
    }
}
