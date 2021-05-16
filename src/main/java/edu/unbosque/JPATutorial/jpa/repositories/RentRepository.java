package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Rent;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RentRepository {

    Optional<Rent> findByEmail(String email);

    Optional<Rent> findByDate(Date renting_Date);

    List<Rent> findByDateAndEmail(Date startDate, Date endDate, String email);

    List<Rent> findAll();

    Optional<Rent> save(Rent rent);

}
