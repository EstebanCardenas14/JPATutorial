package edu.unbosque.JPATutorial.servlets.pojos;

import java.util.Date;

public class EditionPOJO {

     private Integer edition_Id;

     private String description;

     private Date release_year;

     private Integer book_id;

    public EditionPOJO(Integer edition_Id, String description, Date release_year, Integer book_id) {
        this.edition_Id = edition_Id;
        this.description = description;
        this.release_year = release_year;
        this.book_id = book_id;
    }

    public Integer getEdition_Id() {
        return edition_Id;
    }

    public void setEdition_Id(Integer edition_Id) {
        this.edition_Id = edition_Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Date release_year) {
        this.release_year = release_year;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }
}
