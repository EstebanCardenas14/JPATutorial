package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.*;
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

    public void saveRent(Date date,Integer id, String email){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        customerRepository = new CustomerRepositoryImpl(entityManager);
        editionRepository = new EditionRepositoryImpl(entityManager);

        Optional<Customer>customer = customerRepository.findByEmail(email);
        customer.ifPresent(a -> {
            a.addRents(new Rent(date));
            customerRepository.save(a);
        });

        Optional<Edition>edition = editionRepository.findById(id);
        edition.ifPresent(a -> {
            a.addRents(new Rent(date));
            editionRepository.save(a);
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

        List<RentPOJO> rentPOJOList = new ArrayList<>();

        for (Rent rent : rents) {

                rentPOJOList.add(new RentPOJO(
                        rent.getRent_id(),
                        rent.getCustomer().getEmail(),
                        rent.getEdition().getEditionId(),
                        rent.getRenting_Date()));


        }
        return rentPOJOList;
    }

    public void deleteRent(Integer rentId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        rentRepository.deleteById(rentId);

        entityManager.close();
        entityManagerFactory.close();
    }


}
