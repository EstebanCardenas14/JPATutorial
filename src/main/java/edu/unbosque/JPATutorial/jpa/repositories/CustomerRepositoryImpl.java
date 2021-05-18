package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Customer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

    private EntityManager entityManager;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        Customer customer = entityManager.createNamedQuery("Customer.findByEmail", Customer.class)
                .setParameter("email", email)
                .getSingleResult();
        return customer != null ? Optional.of(customer) : Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("from Customer ").getResultList();
    }

    @Override
    public Optional<Customer> save(Customer customer) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return Optional.of(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteByEmail(String email) {
        Customer customer = entityManager.find(Customer.class, email);
        if (customer != null) {
            try {

                entityManager.getTransaction().begin();

                customer.getRents().forEach(rent -> {
                    entityManager.remove(rent);
                });

                entityManager.remove(customer);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void editCustomer(String email, String first_n, String last_n, String gender, Integer age) {
        Customer customer = entityManager.find(Customer.class, email);
        if (customer != null) {
            try {
                entityManager.getTransaction().begin();
                customer.setEmail(email);
                customer.setFirst_name(first_n);
                customer.setLast_name(last_n);
                customer.setGender(gender);
                customer.setAge(age);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
