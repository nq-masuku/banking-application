package banking.application.framework.models;

import java.time.LocalDate;

public class CompanyCustomer extends Customer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6255370638015680987L;

	public CompanyCustomer(String customerId,String name, String email, Address address, LocalDate birthDate) {
        super(customerId,name, email, address, birthDate);
    }
}
