package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
	@ManyToMany(cascade=CascadeType.PERSIST)
    private Collection<Address> addresses;
    
    @OneToMany(cascade=CascadeType.PERSIST)
    private Collection<CreditCard> creditCards;
    
    public Person(String name) {
		this.name = name;
		addresses = new HashSet<Address>();
		creditCards = new ArrayList<CreditCard>();
	}
    
    public Person() {
    	
    }

    public String getName() {
    	return name;
    }
    
    public void addAddress(Address a) {
    	addresses.add(a);
    }
    
    public void addCreditCard(CreditCard c) {
    	creditCards.add(c);
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public Collection<CreditCard> getCreditCards() {
    	return creditCards;
    }
}
