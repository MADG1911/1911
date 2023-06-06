package com.example.myapplication;

import static com.example.myapplication.Costant.API_KEY;
import static com.example.myapplication.Costant.BASE_URL;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.CategoryAdapter;
import com.example.myapplication.adapter.FoodAdapter;
import com.example.myapplication.model.Category;
import com.example.myapplication.model.Food;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity {

    List<Category> categories = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchCategoriesFromServer();
        fetchFoodsFromServer();

        init();

    }
    private void fetchCategoriesFromServer(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi api = retrofit.create(MyApi.class);
        api.getCategories(API_KEY).enqueue(new Callback<GetCategoriesResponse>() {
            @Override
            public void onResponse(Call<GetCategoriesResponse> call, Response<GetCategoriesResponse> response) {
                categories = response.body().getCategories();
                Log.d("category", categories.toString());
            }

            @Override
            public void onFailure(Call<GetCategoriesResponse> call, Throwable t) {
                Log.d("AAA", "onrespones");

            }
        });
    }

    private void fetchFoodsFromServer() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyApi api = retrofit.create(MyApi.class);
        api.getFoods(API_KEY).enqueue(new Callback<GetFoodsResponse>() {
            @Override
            public void onResponse(Call<GetFoodsResponse> call, Response<GetFoodsResponse> response) {
                Log.d("AAA", "onrespones");
            }

            @Override
            public void onFailure(Call<GetFoodsResponse> call, Throwable t) {
                Log.d("AAA", "onrespones");

            }
        });
    }
    private void init(){
        RecyclerView rvfood2 = findViewById(R.id.rv_food2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvfood2.setLayoutManager(layoutManager);
        List<Food> foods = new ArrayList<>();
        foods.add(new Food("MAO", 6f, 50.00f, "https://images7.alphacoders.com/977/977986.jpg"));
        foods.add(new Food("pizza", 66f, 56.00f, "https://images.immediate.co.uk/production/volatile/sites/30/2015/02/Top-10-foods-to-try-in-Spain-1d2b4ef.jpg"));
        foods.add(new Food("kabab", 6f, 50.00f, "https://assets.lightspeedhq.com/img/2019/07/8aac85b2-blog_foodpresentationtipsfromtopchefs.jpg"));
        foods.add(new Food("joje", 69f, 50.00f, "https://www.healthfitnessrevolution.com/wp-content/uploads/2016/09/iStock-119483507.jpg"));
        rvfood2.setAdapter(new FoodAdapter((foods)));


        RecyclerView rvfood3 = findViewById(R.id.rv_food3);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        rvfood3.setLayoutManager(layoutManager1);
        foods.add(new Food("MAO", 6f, 50.00f, "https://images7.alphacoders.com/977/977986.jpg"));
        foods.add(new Food("pizza", 66f, 56.00f, "https://images.immediate.co.uk/production/volatile/sites/30/2015/02/Top-10-foods-to-try-in-Spain-1d2b4ef.jpg"));
        foods.add(new Food("kabab", 6f, 50.00f, "https://assets.lightspeedhq.com/img/2019/07/8aac85b2-blog_foodpresentationtipsfromtopchefs.jpg"));
        foods.add(new Food("joje", 69f, 50.00f, "https://www.healthfitnessrevolution.com/wp-content/uploads/2016/09/iStock-119483507.jpg"));
        rvfood3.setAdapter(new FoodAdapter((foods)));

        RecyclerView rvfood = findViewById(R.id.rv_food);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);
        rvfood.setLayoutManager(layoutManager2);
        foods.add(new Food("khorak", 6f, 50.00f, "https://images7.alphacoders.com/977/977986.jpg"));
        foods.add(new Food("pizza", 66f, 56.00f, "https://images.immediate.co.uk/production/volatile/sites/30/2015/02/Top-10-foods-to-try-in-Spain-1d2b4ef.jpg"));
        foods.add(new Food("kabab", 6f, 50.00f, "https://assets.lightspeedhq.com/img/2019/07/8aac85b2-blog_foodpresentationtipsfromtopchefs.jpg"));
        foods.add(new Food("joje", 69f, 50.00f, "https://www.healthfitnessrevolution.com/wp-content/uploads/2016/09/iStock-119483507.jpg"));
        rvfood.setAdapter(new FoodAdapter((foods)));

        RecyclerView rvcategort = findViewById(R.id.rv_category);
        List<Category> Categories = new ArrayList<>();
        Categories.add(new Category(1, "All"));
        Categories.add(new Category(2, "Irani"));
        Categories.add(new Category(3, "fast food"));
        Categories.add(new Category(4, "italian"));
        rvcategort.setAdapter(new CategoryAdapter(Categories));

    }
}




