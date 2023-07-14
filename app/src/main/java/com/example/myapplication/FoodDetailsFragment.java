package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.example.myapplication.database.AppDatabase;
import com.example.myapplication.model.Food;

public class FoodDetailsFragment extends Fragment {

    private View rootView;
    private Food food;

    public FoodDetailsFragment(Food food){
        this.food = food;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_food_details, container, false);

        init();

        return rootView;
    }

    private void init() {
        ((TextView) rootView.findViewById(R.id.tv_movie_name)).setText(food.getName());
        ((TextView) rootView.findViewById(R.id.tv_imdb)).setText("IMDB " + food.getPrice());
        ((TextView) rootView.findViewById(R.id.tv_story)).setText(food.getDescription());

        ImageView ivCover = rootView.findViewById(R.id.iv_cover);
        Glide.with(this)
                .load(food.getImageUrl())
                .into(ivCover);


        RecyclerView rvGenres = rootView.findViewById(R.id.rv_genres);

        AppDatabase db = Room.databaseBuilder(getContext(),
                        AppDatabase.class, "my-db-name")
                .allowMainThreadQueries()
                .build();
    }
}

