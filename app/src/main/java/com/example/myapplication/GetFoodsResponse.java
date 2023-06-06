package com.example.myapplication;

import com.example.myapplication.model.Food;

import java.util.List;

public class GetFoodsResponse {
    private List<Food> foods;

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

}
