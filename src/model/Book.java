package model;

public class Book {

    private String title;
    private String isbn;
    private double price;
    private String publishers;


    public Book(String title, String isbn, double price, String publishers){
        setTitle(title);
        setIsbn(isbn);
        setPrice(price);
        setPublishers(publishers);
    }

    public Book(){
    }

    public String getTitle() {
        return title;
    }

    public  void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public  void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public  void setPrice(double price) {
        this.price = price;
    }

    public String getPublishers() {
        return publishers;
    }

    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }







}
