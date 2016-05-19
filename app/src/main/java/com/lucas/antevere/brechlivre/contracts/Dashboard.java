package com.lucas.antevere.brechlivre.contracts;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {
    private List<Category> categories;
    private List<Carrousel> carrousels;

    public Dashboard(){
        categories = new ArrayList<>();
        carrousels = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Carrousel> getCarrousels() {
        return carrousels;
    }

    public void setCarrousels(List<Carrousel> carrousels) {
        this.carrousels = carrousels;
    }
}
