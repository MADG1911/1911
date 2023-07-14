package com.example.myapplication.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.myapplication.model.Food;

@Database(entities = { Food.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FoodDao foodDao();
}