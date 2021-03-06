package edu.unbosque.JPATutorial.services;

import edu.unbosque.JPATutorial.jpa.entities.Book;
import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.entities.Library;
import edu.unbosque.JPATutorial.jpa.repositories.*;
import edu.unbosque.JPATutorial.servlets.pojos.EditionPOJO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Stateless
public class EditionService {

    BookRepository bookRepository;
    EditionRepository editionRepository;
    LibraryRepository libraryRepository;

    public void saveEdition(String descripion, Date releaseYear, Integer book_id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepositoryImpl(entityManager);
        editionRepository = new EditionRepositoryImpl(entityManager);

        Optional<Book> book = bookRepository.findById(book_id);
        book.ifPresent(a -> {
            a.addEditions(new Edition(descripion,releaseYear));
            bookRepository.save(a);
        });

        entityManager.close();
        entityManagerFactory.close();

    }

    public List<EditionPOJO> listEditions(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        List<Edition> editions = editionRepository.findAll();

        entityManager.close();
        entityManagerFactory.close();

        List<EditionPOJO> editionPOJOS = new ArrayList<>();

        for (Edition edition : editions){
            editionPOJOS.add(new EditionPOJO(edition.getEditionId(),edition.getDescription(),edition.getReleaseYear(),edition.getBook().getBookId()));
        }
        return editionPOJOS;
    }

    public void editEdition(Integer id, String description, Date relaseYear, Integer book_Id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        editionRepository.editEdition(id,description,relaseYear,book_Id);

        entityManager.close();
        entityManagerFactory.close();
    }

    public void deleteEdition(Integer editionID){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        editionRepository = new EditionRepositoryImpl(entityManager);
        editionRepository.deleteById(editionID);

        entityManager.close();
        entityManagerFactory.close();
    }

    public void associate(Integer libraryID,Integer editionID){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        editionRepository = new EditionRepositoryImpl(entityManager);
        editionRepository.associate(libraryID,editionID);
        entityManager.close();
        entityManagerFactory.close();
    }


    public void disassociate(Integer libraryID,Integer editionID){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tutorial");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        editionRepository = new EditionRepositoryImpl(entityManager);
        editionRepository.disassociate(libraryID,editionID);
        entityManager.close();
        entityManagerFactory.close();
    }

}
