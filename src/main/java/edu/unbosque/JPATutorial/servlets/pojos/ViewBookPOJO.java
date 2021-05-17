package edu.unbosque.JPATutorial.servlets.pojos;

public class ViewBookPOJO {

    private int book_id;

    private String title;

    private int isbn_number;

    private int author_id;

    private String genre;

    public ViewBookPOJO() { }

    public ViewBookPOJO(int book_id, String title, int isbn_number, int author_id, String genre) {
        this.book_id = book_id;
        this.title = title;
        this.isbn_number = isbn_number;
        this.author_id = author_id;
        this.genre = genre;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsbn_number() {
        return isbn_number;
    }

    public void setIsbn_number(int isbn_number) {
        this.isbn_number = isbn_number;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
