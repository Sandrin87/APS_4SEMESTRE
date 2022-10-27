package model;

public class Author {

    private int author_id;
    private String lastName;
    private String firstNane;

    public Author(int id, String lastName, String firstNane) {
        this.author_id = id;
        this.lastName = lastName;
        this.firstNane = firstNane;
    }

    public Author(String lastName, String firstNane) {
        this.lastName = lastName;
        this.firstNane = firstNane;
    }
    public Author(){}

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstNane;
    }

    public void setFirstNane(String firstNane) {
        this.firstNane = firstNane;
    }

    @Override
    public String toString() {
        return getFirstName() +" "+ getLastName();
    }
    
}
