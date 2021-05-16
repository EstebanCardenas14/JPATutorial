package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.entities.Rent;
import edu.unbosque.JPATutorial.jpa.repositories.CustomerRepository;
import edu.unbosque.JPATutorial.jpa.repositories.CustomerRepositoryImpl;
import edu.unbosque.JPATutorial.jpa.repositories.RentRepository;
import edu.unbosque.JPATutorial.jpa.repositories.RentRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Optional;

public class RentService {

    CustomerRepository customerRepository;
    RentRepository rentRepository;

    public void saveRent(String email, Date renting_Date){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);
        rentRepository = new RentRepositoryImpl(entityManager);

        Optional<Customer> customer = customerRepository.findByEmail(email);
        customer.ifPresent(a -> {
            a.addRents(new Rent(renting_Date));
            customerRepository.save(a);
        });

        entityManager.close();
        entityManagerFactory.close();


    }



}
