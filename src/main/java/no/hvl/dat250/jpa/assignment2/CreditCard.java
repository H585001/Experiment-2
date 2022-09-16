package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer number;
    private Integer balance;
    private Integer limit;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Pincode pincode;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Bank owningBank;
    
    public CreditCard(Integer number, Integer balance, Integer limit, Pincode pincode, Bank bank) {
    	this.number = number;
    	this.balance = balance;
    	this.limit = limit;
    	this.pincode = pincode;
    	this.owningBank = bank;
    }
    
    public CreditCard() {
    	
    }
    
    public Integer getNumber() {
        return number;
    }

    public Integer getBalance() {
    	return balance;
    }

    public Integer getLimit() {
    	return limit;
    }

    public Pincode getPincode() {
    	return pincode;
    }

    public Bank getOwningBank() {
    	return owningBank;
    }
}
