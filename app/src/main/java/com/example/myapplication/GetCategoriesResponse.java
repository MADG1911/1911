package com.example.myapplication;

import com.example.myapplication.model.Category;

import java.util.List;

public class GetCategoriesResponse {
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
