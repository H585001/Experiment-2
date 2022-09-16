package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String street;
    
    private Integer number;
    
    @ManyToMany(mappedBy = "addresses" , cascade=CascadeType.PERSIST)
    private Set<Person> owners;

    public Address(String string, Integer number) {
    	street = string;
    	this.number = number;
    	this.owners = new HashSet<Person>();
	}
    
    public Address() {
    	
    }

	public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }
    
    
    public Collection<Person> getOwners() {
    	return owners;
    }
}
