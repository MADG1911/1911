package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.model.Food;

import java.util.List;

public abstract class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{
    List<Food> foods;
    public FoodAdapter(List<Food> foods){
        this.foods = foods;

    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        bind(holder,foods.get(position));

        if (position == getItemCount() - 1) {
            onEndOfScreenViewed();
        }

    }

    public abstract void onEndOfScreenViewed();

    void bind (FoodViewHolder holder, Food food){
    holder.tvNAME.setText(food.getName());
    holder.TvPrice.setText("Price: " + String.valueOf(food.getPrice()));
    holder.tvDesc.setText(food.getDescription());
    Glide.with(holder.itemView.getContext()).load(food.getImageUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(14))).into(holder.ivCover);

}

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{
        TextView tvNAME,TvPrice, tvDesc;
        ImageView ivCover;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNAME = itemView.findViewById(R.id.tv_name);
            TvPrice =  itemView.findViewById(R.id.tv_price);
            ivCover = itemView.findViewById(R.id.iv_cover);
            tvDesc = itemView.findViewById(R.id.tv_desc);
        }
    }
}

