package edu.unbosque.JPATutorial.jpa.repositories;

import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.jpa.entities.Library;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class EditionRepositoryImpl implements EditionRepository{
    private EntityManager entityManager;
    public EditionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Edition> findById(Integer edition_Id) {
        Edition edition = entityManager.find(Edition.class, edition_Id);
        return edition != null ? Optional.of(edition) : Optional.empty();
    }

    @Override
    public List<Edition> findAll() {
        return entityManager.createQuery("from Edition ").getResultList();
    }

    @Override
    public Optional<Edition> save(Edition edition) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(edition);
            entityManager.getTransaction().commit();
            return Optional.of(edition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {
    Edition edition = entityManager.find(Edition.class, id);

            if(edition != null){
                try {

                    entityManager.getTransaction().begin();

                    edition.getRents().forEach(rent -> {
                        entityManager.remove(edition);
                    });

                    entityManager.remove(edition);
                    entityManager.getTransaction().commit();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }

    @Override
    public void editEdition(Integer id, String description, Date relaseYear, Integer book_Id) {
        Edition edition = entityManager.find(Edition.class, id);
        if(edition != null) {
            try {
                entityManager.getTransaction().begin();
                edition.setDescription(description);
                edition.setReleaseYear(relaseYear);
                entityManager.getTransaction().commit();
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void associate(Integer libraryID,Integer editionID) {
        Edition edition = entityManager.find(Edition.class, editionID);
        Library library = entityManager.find(Library.class, libraryID);
        if(edition != null) {
            try {
                entityManager.getTransaction().begin();
                library.addEdition(edition);
                entityManager.persist(library);
                entityManager.getTransaction().commit();
            } catch (Exception e) {

            }
        }
    }


    @Override
    public void disassociate(Integer libraryID,Integer editionID) {
        Edition edition = entityManager.find(Edition.class, editionID);
        System.out.println("edicion a desasociar we -----> "+edition);
        Library library = entityManager.find(Library.class,libraryID);
        System.out.println("libreria a desasociar we -----> "+library);
        if(edition != null && library != null){
            try {
                entityManager.getTransaction().begin();
                edition.getLibraries().remove(library);
                library.getEditions().remove(edition);
                entityManager.getTransaction().commit();
            }catch (Exception e){

            }
        }
    }
}
