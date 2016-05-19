package com.lucas.antevere.brechlivre.contracts;

public class Product {
    private String ID;
    private String title;
    private String category;
    private String imageUrl;

    public Product(String id, String title, String category, String imageUrl){
        this.ID = id;
        this.title = title;
        this.category = category;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
