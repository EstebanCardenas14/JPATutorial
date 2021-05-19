package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Customer;
import edu.unbosque.JPATutorial.jpa.entities.Rent;
import edu.unbosque.JPATutorial.jpa.repositories.*;
import edu.unbosque.JPATutorial.servlets.pojos.RentPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Stateless
public class RentService {

    CustomerRepository customerRepository;
    RentRepository rentRepository;
    EditionRepository editionRepository;

    public void saveRent(String email, Date renting_Date, Integer edition_id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);
        rentRepository = new RentRepositoryImpl(entityManager);
        editionRepository = new EditionRepositoryImpl(entityManager);

        Optional<Customer> customer = customerRepository.findByEmail(email);
        customer.ifPresent(a -> {
            a.addRents(new Rent(renting_Date));
            customerRepository.save(a);
        });


        entityManager.close();
        entityManagerFactory.close();


    }

    public List<RentPOJO> listRent(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        List<Rent> rents = rentRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<RentPOJO> rentPOJOS = new ArrayList<>();
        for (Rent rent : rents){
            rentPOJOS.add(new RentPOJO(rent.getRent_id(), rent.getCustomer().getEmail(),rent.getEdition().getEditionId(),rent.getRenting_Date()));
        }
        return rentPOJOS;
    }

    public void deleteRent(Integer rentId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        rentRepository.deleteById(rentId);

        entityManager.close();
        entityManagerFactory.close();
    }

    public List<RentPOJO> rangeDateRent(Date startDate, Date endDate, String email){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);
        rentRepository = new RentRepositoryImpl(entityManager);

        List<Rent> rents = rentRepository.findByDateAndEmail(startDate, endDate,email);

        List<RentPOJO> rentPOJOS = new ArrayList<>();
        for (Rent rent : rents){
            rentPOJOS.add(new RentPOJO(rent.getRent_id(), rent.getCustomer().getEmail(),rent.getEdition().getEditionId(),rent.getRenting_Date()));
        }
        return rentPOJOS;
    }

}
