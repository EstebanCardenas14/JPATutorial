package edu.unbosque.JPATutorial.servlets.pojos;

import java.util.Date;

public class EditionPOJO {

    private int edition_id;

    private String description;

    private Date release_year;

    private int book_id;

    public EditionPOJO(int edition_id, String description, Date release_year, int book_id) {
        this.edition_id = edition_id;
        this.description = description;
        this.release_year = release_year;
        this.book_id = book_id;
    }

    public int getEdition_id() {
        return edition_id;
    }

    public void setEdition_id(int edition_id) {
        this.edition_id = edition_id;
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

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
}
