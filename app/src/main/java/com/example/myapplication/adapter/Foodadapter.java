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
import com.example.myapplication.model.food;

import java.util.List;

public class Foodadapter extends RecyclerView.Adapter<Foodadapter.Foodviewholder>{
    List<food> foods;
    public Foodadapter(List<food> foods){
        this.foods = foods;

    }
    @NonNull
    @Override
    public Foodviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View itemView = inflater.inflate(R.layout.item_food, parent, false);
        return new Foodviewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Foodviewholder holder, int position) {
bind(holder,foods.get(position));


    }
void bind (Foodviewholder holder, food foood){
    holder.tvNAME.setText(foood.getFood_name());
    holder.TvPrice.setText(String.valueOf(foood.getPrice()));
    holder.TVTime.setText(String.valueOf(foood.getTime()));
    Glide.with(holder.itemView.getContext()).load(foood.getImageUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(14))).into(holder.ivCover);


}

    @Override
    public int getItemCount() {
        return foods.size();
    }



    class Foodviewholder extends RecyclerView.ViewHolder{
        TextView tvNAME,TvPrice, TVTime;
        ImageView ivCover;
        public Foodviewholder(@NonNull View itemView) {
            super(itemView);

         tvNAME = itemView.findViewById(R.id.tv_name);
         TvPrice =  itemView.findViewById(R.id.tv_price);
         TVTime = itemView.findViewById(R.id.tv_time);
         ivCover = itemView.findViewById(R.id.iv_cover);
        }
    }
    }

