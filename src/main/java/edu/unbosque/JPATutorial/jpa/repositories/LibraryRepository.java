package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository {

    Optional<Library> findById(Integer id);

    List<Library> findAll();

    Optional<Library> save(Library library);

    void deleteById(Integer id);

    void editLibrary(Integer id, String name);
}
