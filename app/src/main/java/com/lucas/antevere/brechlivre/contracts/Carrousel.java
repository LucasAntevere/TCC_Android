package com.lucas.antevere.brechlivre.contracts;

import java.util.List;

public class Carrousel {
    private String title;
    private String subtitle;
    private List<Product> products;

    public Carrousel(String title, String subtitle, List<Product> products){
        this.title = title;
        this.subtitle = subtitle;
        this.products = products;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
