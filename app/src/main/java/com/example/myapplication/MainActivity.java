package com.example.myapplication;

import static com.example.myapplication.Costant.BASE_URL;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.myapplication.adapter.CategoryAdapter;
import com.example.myapplication.adapter.FoodAdapter;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.model.Category;
import com.example.myapplication.model.Food;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private int page = 1;
    Retrofit retrofit;
    private FoodAdapter foodAdapter;
    private RecyclerView rvFoods;
    MyApi api;
    private AppDatabase db;
    List<Category> categories = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchFoodsFromServer();

        init();

    }
    private void loadFoodsFromDb(){
        List<Food> dbFoods = db.foodDao().getAll();

        if (foodAdapter == null) {
            foodAdapter = new FoodAdapter(dbFoods) {
                @Override
                public void onEndOfScreenViewed() {
                    page++;
                    fetchFoodsFromServer();
                    if (page > 5) {
                        page = 1;
                    }
                }

                @Override
                public void onFoodDetails(Food food) {
                    FragmentManager frgManager = getSupportFragmentManager();
                    frgManager.beginTransaction()
                            .add(R.id.fl_container, new FoodDetailsFragment(food))
                            .addToBackStack(null)
                            .commit();

                }
            };

            rvFoods.setAdapter(foodAdapter);
        } else {
            foodAdapter.notifyDataSetChanged();
        }
    }

    private void fetchFoodsFromServer() {
        api.getFoods(page).enqueue(new Callback<GetFoodsResponse>() {
            @Override
            public void onResponse(Call<GetFoodsResponse> call, Response<GetFoodsResponse> response) {
                List<Food> foods = response.body().getFoods();

                db.foodDao().insert(foods);
                loadFoodsFromDb();
            }
            @Override
            public void onFailure(Call<GetFoodsResponse> call, Throwable t) {
                loadFoodsFromDb();
            }
        });
    }
    private void init(){
        rvFoods = findViewById(R.id.rv_food);
        rvFoods.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(MyApi.class);
        db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "foods")
                .allowMainThreadQueries()
                .build();
        RecyclerView rvcategort = findViewById(R.id.rv_category);
        categories = new ArrayList<>();
        categories.add(new Category(1, "All"));
        categories.add(new Category(2, "Burger"));
        categories.add(new Category(3, "Rice"));
        categories.add(new Category(4, "Soup"));
        categories.add(new Category(4, "Pasta"));
        categories.add(new Category(4, "Pizza"));
        rvcategort.setAdapter(new CategoryAdapter(categories));

    }

    @Override
    public void onBackPressed() {
        FragmentManager frgManager = getSupportFragmentManager();
        if (frgManager.getBackStackEntryCount() > 0){
            frgManager.popBackStackImmediate();

            return;
        }

        super.onBackPressed();
    }
}




