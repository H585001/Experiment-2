package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @OneToMany(mappedBy = "owningBank", cascade=CascadeType.PERSIST)
    private Set<CreditCard> ownedCards;
    
    public Bank(String name) {
    	this.name = name;
    	ownedCards = new HashSet<CreditCard>();
    }
    
    public Bank() {
    	
    }

    public Long getId() {
        return id;
    }

    public String getName() {
    	return name;
    }
    
    public Set<CreditCard> getOwnedCards() {
    	return ownedCards;
    }
}
