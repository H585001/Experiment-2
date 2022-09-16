package no.hvl.dat250.jpa.assignment2.driver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.dat250.jpa.assignment2.Address;
import no.hvl.dat250.jpa.assignment2.Bank;
import no.hvl.dat250.jpa.assignment2.CreditCard;
import no.hvl.dat250.jpa.assignment2.Person;
import no.hvl.dat250.jpa.assignment2.Pincode;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Bank bank = new Bank("Pengebank");
        Pincode pin = new Pincode("123", 1);
        CreditCard card = new CreditCard(12345, -5000, -10000, pin, bank);
        CreditCard card2 = new CreditCard(123, 1, 2000, pin, bank);
        
        Person max = new Person("Max Mustermann");
        Address address = new Address("Inndalsveien", 28);
        max.addAddress(address);
        max.addCreditCard(card);
        max.addCreditCard(card2);
        
        em.getTransaction().begin();
        em.persist(max);
        em.getTransaction().commit();
        em.close();
        
    }
}
