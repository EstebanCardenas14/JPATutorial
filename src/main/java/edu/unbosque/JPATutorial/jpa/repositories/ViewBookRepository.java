package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Author;
import edu.unbosque.JPATutorial.jpa.entities.Book;

import java.util.List;
import java.util.Optional;

public interface ViewBookRepository {

    Optional<Book> findById(Integer id);

    List<Book> findAll();

    Optional<Book> save(Book author);

    void deleteById(Integer id);

}
