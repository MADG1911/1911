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

import com.bumptech.glide.Glide;
import com.example.myapplication.model.Food;

public class FoodDetailFragment extends Fragment {

    private View rootView;
    private Food food;

    public FoodDetailFragment(Food food){
        this.food = food;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.food_detail, container, false);

        init();

        return rootView;
    }

    private void init() {
        ((TextView) rootView.findViewById(R.id.tv_name)).setText(food.getName());
        ((TextView) rootView.findViewById(R.id.tv_price)).setText(String.valueOf(food.getPrice()));
        ((TextView) rootView.findViewById(R.id.tv_desc)).setText(food.getDescription());

        ImageView ivCover = rootView.findViewById(R.id.iv_cover);
        Glide.with(this)
                .load(food.getImageUrl())
                .into(ivCover);



    }
}
