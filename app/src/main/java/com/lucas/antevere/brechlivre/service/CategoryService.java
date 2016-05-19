package com.lucas.antevere.brechlivre.service;

import com.lucas.antevere.brechlivre.contracts.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    public List<Category> Get(int id){
        List<Category> lst = new ArrayList<>();
        lst.add(new Category(1, "Livros", "#555555", "ic_book_24dp"));

        return lst;
    }
}
