package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Edition;

import java.util.List;
import java.util.Optional;

public interface EditionRepository {

    Optional<Edition> findById(Integer edition_Id);

    List<Edition> findAll();

    Optional<Edition> save(Edition edition);

    void deleteById(Integer id);

    void editEdition(Integer id, String description, String relaseYear, Integer book_Id);
}
