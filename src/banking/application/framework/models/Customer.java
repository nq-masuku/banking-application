package banking.application.framework.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3976822307390661373L;
	private String customerId;
    private String name;
    private String email;
    private Address address;
    private LocalDate birthLocalDate;

    public Customer(String cust,String name, String email, Address address, LocalDate birthLocalDate) {
    	this.customerId = cust;
        this.name = name;
        this.email = email;
        this.address = address;
        this.birthLocalDate = birthLocalDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getBirthLocalDate() {
        return birthLocalDate;
    }

    public void setBirthLocalDate(LocalDate birthLocalDate) {
        this.birthLocalDate = birthLocalDate;
    }

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
    
    
}
