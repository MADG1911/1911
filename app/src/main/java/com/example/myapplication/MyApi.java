package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MyApi {
    @GET("categories/list")
    Call<GetCategoriesResponse> getCategories(
            @Header("X-RapidAPI-Key") String API_KEY
    );

    @GET("feeds/list")
    Call<GetFoodsResponse> getFoods(
            @Header("X-RapidAPI-Key") String API_KEY
    );

}
