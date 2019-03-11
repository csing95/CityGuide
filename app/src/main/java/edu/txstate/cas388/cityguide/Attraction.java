package edu.txstate.cas388.cityguide;

public class Attraction {
    private int id;
    private String name;
    private double cost;
    private String url;
    private int image;

    public Attraction() {
    }

    public Attraction(int id, String name, double cost, String url, int image) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.url = url;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
