package edu.unbosque.JPATutorial.servlets.pojos;

public class BookPOJO {

    private Integer book_id;

    private String title;

    private String isbn_number;

    private Integer author_id;

    private String genre;

    public BookPOJO(Integer book_id, String title, String isbn_number, Integer author_id, String genre) {
        this.book_id = book_id;
        this.title = title;
        this.isbn_number = isbn_number;
        this.author_id = author_id;
        this.genre = genre;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn_number() {
        return isbn_number;
    }

    public void setIsbn_number(String isbn_number) {
        this.isbn_number = isbn_number;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
