package model;

public class Book {

    private String title;
    private String isbn;
    private double price;
    private int publisher_id;

    public Book(String title, String isbn, double price, int publisher_id) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.publisher_id = publisher_id;
    }

    public Book(){

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
}
