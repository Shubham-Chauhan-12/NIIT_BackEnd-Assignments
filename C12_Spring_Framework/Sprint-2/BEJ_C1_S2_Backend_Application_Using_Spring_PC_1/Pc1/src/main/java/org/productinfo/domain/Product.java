package org.productinfo.domain;

public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private float rating;


    public Product(int productId, String name, String category, double price, float rating) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
