package model;

public class Publisher {

    private String name;
    private String url;
    private int publisher_id;

    public Publisher(String name, String url, int publisher_id) {
        this.name = name;
        this.url = url;
        this.publisher_id = publisher_id;
    }
    public Publisher(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl(String url) {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }



}
