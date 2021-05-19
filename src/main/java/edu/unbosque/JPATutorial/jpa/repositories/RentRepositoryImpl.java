package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.entities.Rent;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RentRepositoryImpl implements RentRepository{

    private EntityManager entityManager;

    public RentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Rent> findById(String id) {
        Rent rent = entityManager.find(Rent.class, id);
        return rent != null ? Optional.of(rent) : Optional.empty();
    }


    @Override
    public Optional<Rent> findByDate(Date renting_Date) {
        Rent rent = entityManager.createNamedQuery("Rent.findByDate", Rent.class)
                .setParameter("renting_Date", renting_Date)
                .getSingleResult();
        return rent != null ? Optional.of(rent) : Optional.empty();
    }

    @Override
    public List<Rent> findByDateAndEmail(Date startDate, Date endDate, String email) {
        List <Rent> allRentsInDate;
        allRentsInDate = entityManager.createQuery("SELECT e FROM Rent e WHERE e.renting_Date BETWEEN :startDate AND :endDate order by e.renting_Date").getResultList();
        return allRentsInDate;
    }

    public List<Rent> findByEmail(String email) {
        Query rentQ = entityManager.createQuery("SELECT c FROM Rent c WHERE c.customer.id = :email");
        rentQ.setParameter("email",email);
        List<Rent> rent =rentQ.getResultList();
        return rent ;
    }

    public List<Rent> findByEdition(Integer editionId) {
        Query rentQ = entityManager.createQuery("SELECT s FROM Rent s WHERE s.edition.id= :editionId ");
        rentQ.setParameter("editionId",editionId);
        List<Rent> rent =rentQ.getResultList();
        return rent ;
    }

    @Override
    public List<Rent> findAll() {
        return entityManager.createQuery("from Rent ").getResultList();
    }

    @Override
    public Optional<Rent> save(Rent rent) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(rent);
            entityManager.getTransaction().commit();
            return Optional.of(rent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer Id) {
        Rent rent = entityManager.find(Rent.class, Id);
        if(rent != null){
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(rent);
                entityManager.getTransaction().commit();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void editRent(Integer id, String email, Integer edition_Id, Date renting_date) {

    }
}
