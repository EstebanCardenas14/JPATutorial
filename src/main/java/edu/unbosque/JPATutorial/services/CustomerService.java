package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.repositories.CustomerRepository;
import edu.unbosque.JPATutorial.jpa.repositories.CustomerRepositoryImpl;
import edu.unbosque.JPATutorial.servlets.pojos.CustomerPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerService {

    CustomerRepository customerRepository;

    public List<CustomerPOJO> listCustomer(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository  = new CustomerRepositoryImpl(entityManager);
        List<Customer> customers = customerRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<CustomerPOJO> customerPOJOS = new ArrayList<>();
        for (Customer customer : customers){
            customerPOJOS.add(new CustomerPOJO(customer.getEmail(), customer.getFirst_name(), customer.getLast_name(),customer.getGender(),customer.getAge()));
        }

        return customerPOJOS;

    }

    public Customer saveCustomer(String email,String first_name, String last_name, String gender, Integer age){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);

        Customer customer = new Customer(email,first_name,last_name,gender,age);
        Customer persistedCustomer = customerRepository.save(customer).get();

        entityManager.close();
        entityManagerFactory.close();

        return persistedCustomer;
    }

    public void deleteCustomer(String email){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);
        customerRepository.deleteByEmail(email);

        entityManager.close();
        entityManagerFactory.close();
    }

    public void  editCustomer(String email, String first_n, String last_n, String gender, Integer age){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);
        customerRepository.editCustomer(email,first_n,last_n,gender,age);

        entityManager.close();
        entityManagerFactory.close();
    }
}
