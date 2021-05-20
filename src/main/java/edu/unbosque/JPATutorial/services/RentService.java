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

    public void saveRent(String email, Date renting_Date,Integer edition_id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepositoryImpl(entityManager);
        rentRepository = new RentRepositoryImpl(entityManager);
        editionRepository = new EditionRepositoryImpl(entityManager);

        Rent rent = new Rent(renting_Date);
        Optional<Customer> customer = customerRepository.findByEmail(email);

        if (!customer.isPresent())
            System.out.println("El id del cliente ingresado no existe!");
        Optional<Edition> edition = editionRepository.findById(edition_id);

        if (!edition.isPresent())
            System.out.println("El id del edición ingresado no existe!");
        customer.ifPresent(a -> {
            a.addRents(rent);
            customerRepository.save(a);
        });
        edition.ifPresent(e -> {
            e.addRents(rent);
            editionRepository.save(e);
        });
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("Se ha guardado exitosamente");

    }

    public List<RentPOJO> listRent(String email){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        rentRepository = new RentRepositoryImpl(entityManager);
        List<Rent> rents = rentRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<RentPOJO> rentPOJOList = new ArrayList<>();

        for (Rent rent : rents) {
            if (rent.getCustomer().getEmail().equals(email)) {
                rentPOJOList.add(new RentPOJO(
                        rent.getRent_id(),
                        rent.getCustomer().getEmail(),
                        rent.getEdition().getEditionId(),
                        rent.getRenting_Date()));
            }

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
