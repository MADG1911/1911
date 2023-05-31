package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.CategoryAdapter;
import com.example.myapplication.adapter.Foodadapter;
import com.example.myapplication.model.Categoryy;
import com.example.myapplication.model.food;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class mainactivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callApi();


        init();

    }
    private void callApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.example.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi api = retrofit.create(MyApi.class);
                    api.getProducts().enqueue(new Callback<List<Product>>() {
                        @Override
                        public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                            Log.d("AAA", "onrespones");
                        }

                        @Override
                        public void onFailure(Call<List<Product>> call, Throwable t) {
                            Log.d("AAA", "onrespones");

                        }
                    });
    }
private void init(){
        RecyclerView rvfood = findViewById(R.id.rv_food);
        rvfood.setLayoutManager(new LinearLayoutManager(this));

        List<food> foods = new ArrayList<>();
        foods.add(new food("khorak", 6f, 50f, "https://images7.alphacoders.com/977/977986.jpg"));
        foods.add(new food("pizza", 66f, 56f, null));
        foods.add(new food("kabab", 6f, 50f, null));
        foods.add(new food("joje", 69f, 50f, null));

        rvfood.setAdapter(new Foodadapter((foods)));

        RecyclerView rvcategort = findViewById(R.id.rv_category);
        List<Categoryy> Categoriess = new ArrayList<>();
        Categoriess.add(new Categoryy(1, "All"));
        Categoriess.add(new Categoryy(2, "Irani"));
        Categoriess.add(new Categoryy(3, "fast food"));
        Categoriess.add(new Categoryy(4, "italian"));
        rvcategort.setAdapter(new CategoryAdapter(Categoriess));


}


    }





