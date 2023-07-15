package com.example.myapplication;

import static com.example.myapplication.Costant.BASE_URL;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.NonNull;
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
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<Food> allFoods = new ArrayList<>();
    List<Food> filteredFoods = new ArrayList<>();


    private int page = 1;
    private EditText etSearch;
    Retrofit retrofit;
    private FoodAdapter foodAdapter;
    private RecyclerView rvFoods;
    private MyApi api;
    private AppDatabase db;
    List<Category> categories = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        fetchFoodsFromServer();

    }
    @SuppressLint("NotifyDataSetChanged")
    private void loadFoodsFromDb(){
        List<Food> dbFoods = db.foodDao().getAll();

        allFoods.clear();
        allFoods.addAll(dbFoods);

        if (etSearch.getText().toString().isEmpty()) {
            filteredFoods.clear();
            filteredFoods.addAll(dbFoods);
        }


        if (foodAdapter == null) {
            foodAdapter = new FoodAdapter(filteredFoods) {
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
                            .add(R.id.fl_container, new FoodDetailFragment(food))
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
            public void onResponse(@NonNull Call<GetFoodsResponse> call, @NonNull Response<GetFoodsResponse> response) {
                List<Food> foods = null;
                if (response.body() != null) {
                    foods = response.body().getFoods();
                }
                if (foods != null) {
                    db.foodDao().insert(foods);
                }
                loadFoodsFromDb();
            }
            @Override
            public void onFailure(@NonNull Call<GetFoodsResponse> call, Throwable t) {
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
        etSearch = findViewById(R.id.et_search);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchTerm = etSearch.getText().toString();

                search(searchTerm);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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

    private void search(String searchTerm){
        filteredFoods.clear();

        for (int i=0 ; i< allFoods.size() ; i++){
            if(allFoods.get(i).getName().toLowerCase().contains(searchTerm.toLowerCase())){
                filteredFoods.add(allFoods.get(i));
            }
        }

        foodAdapter.notifyDataSetChanged();
    }

}




