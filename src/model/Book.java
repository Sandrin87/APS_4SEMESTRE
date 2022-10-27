package model;

import java.util.List;

public class Book {

    private String title;
    private String isbn;
    private List<Author> authors;
    private double price;
    private int publisher_id;

    public Book(String title, String isbn, List<Author> authors, double price, int publisher_id) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.authors = authors;
        this.publisher_id = publisher_id;
    }

    public Book(){

    }

    public List<Author> getAuthors() {
        return authors;
    }
    
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    @Override
    public String toString() {
        return getTitle(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
