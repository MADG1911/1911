package com.example.myapplication.model;

public class food {
    private String food_name;
    private Float time;
    private Float price;
    private String imageUrl;

    public food(String food_name, Float time, Float price, String imageUrl) {
        this.food_name = food_name;
        this.time = time;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
