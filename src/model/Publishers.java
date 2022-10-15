package model;

public class Publishers {

    private String name;
    private String url;


    public Publishers(String name, String url) {
        setName(name);
        setUrl(url);
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


}
