package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.CategoryAdapter;
import com.example.myapplication.adapter.Foodadapter;
import com.example.myapplication.adapter.Foodadapter2;
import com.example.myapplication.model.Categoryy;
import com.example.myapplication.model.food;
import com.example.myapplication.model.food2;

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
    RecyclerView rvfood2 = findViewById(R.id.rv_food2);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
    rvfood2.setLayoutManager(layoutManager);

    List<food2> foods2 = new ArrayList<>();

    foods2.add(new food2("MAO", 6f, 50.00f, "https://images7.alphacoders.com/977/977986.jpg"));
    foods2.add(new food2("pizza", 66f, 56.00f, "https://images.immediate.co.uk/production/volatile/sites/30/2015/02/Top-10-foods-to-try-in-Spain-1d2b4ef.jpg"));
    foods2.add(new food2("kabab", 6f, 50.00f, "https://assets.lightspeedhq.com/img/2019/07/8aac85b2-blog_foodpresentationtipsfromtopchefs.jpg"));
    foods2.add(new food2("joje", 69f, 50.00f, "https://www.healthfitnessrevolution.com/wp-content/uploads/2016/09/iStock-119483507.jpg"));
    rvfood2.setAdapter(new Foodadapter2((foods2)));

    RecyclerView rvfood = findViewById(R.id.rv_food);
        rvfood.setLayoutManager(new LinearLayoutManager(this));
        List<food> foods = new ArrayList<>();
        foods.add(new food("khorak", 6f, 50.00f, "https://images7.alphacoders.com/977/977986.jpg"));
        foods.add(new food("pizza", 66f, 56.00f, "https://images.immediate.co.uk/production/volatile/sites/30/2015/02/Top-10-foods-to-try-in-Spain-1d2b4ef.jpg"));
        foods.add(new food("kabab", 6f, 50.00f, "https://assets.lightspeedhq.com/img/2019/07/8aac85b2-blog_foodpresentationtipsfromtopchefs.jpg"));
        foods.add(new food("joje", 69f, 50.00f, "https://www.healthfitnessrevolution.com/wp-content/uploads/2016/09/iStock-119483507.jpg"));
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





