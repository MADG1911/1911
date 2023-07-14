package com.example.myapplication.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.model.Food;

import java.util.List;

@Dao
public interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Food food);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Food> foods);

    @Query("SELECT * FROM foods")
    List<Food> getAll();

}
