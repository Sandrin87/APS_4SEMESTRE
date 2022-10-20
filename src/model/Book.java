package model;

import java.util.List;



public class Book {

    private String title;
    private Integer isbn;
    private double price;
    private Publisher publishers;
    private List<Author> author;


    public Book(String title, int isbn, Publisher publisher, List<Author> author, double price){
        setTitle(title);
        setIsbn(isbn);
        setPrice(price);
        setPublishers(publisher);
        setAuthor(author);
    }

    public String getTitle() {
        return title;
    }

    public  void setTitle(String title) {
        this.title = title;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public  void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public  void setPrice(double price) {
        this.price = price;
    }

    public Publisher getPublishers() {
        return publishers;
    }

    public void setPublishers(Publisher publishers) {
        this.publishers = publishers;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public  void  setAuthor(List<Author> author) {
        this.author = author;
    }






}
