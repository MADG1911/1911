package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MyApi {
    @GET("/foods")
    Call<GetFoodsResponse> getFoods(
            @Query("page") int page
    );
    @GET("/foods")
    Call<GetFoodsResponse> getFoodsByTag(
            @Query("tag") String tag
    );

}
