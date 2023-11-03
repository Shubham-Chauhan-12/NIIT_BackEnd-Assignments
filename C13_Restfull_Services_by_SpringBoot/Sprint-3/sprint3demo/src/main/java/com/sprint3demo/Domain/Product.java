package com.sprint3demo.Domain;

public class Product {

    private String prodName;
    private String prodDescription;

    public Product() {
    }

    public Product(String prodName, String prodDescription) {
        this.prodName = prodName;
        this.prodDescription = prodDescription;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }
}
