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
import com.example.myapplication.model.food2;
import com.example.myapplication.model.food3;

import java.util.List;

public class Foodadapter3 extends RecyclerView.Adapter<Foodadapter3.Foodviewholder3>{
    List<food3> foods3;
    public Foodadapter3(List<food3> foods3){
      this.foods3 = foods3;

    }
    @NonNull
    @Override
    public Foodviewholder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View itemView = inflater.inflate(R.layout.item_food3, parent, false);
        return new Foodviewholder3(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Foodviewholder3 holder, int position) {
bind(holder, foods3.get(position));


    }
void bind (Foodviewholder3 holder, food3 foood3){
    holder.tvNAME.setText(foood3.getFood_name());
    holder.TvPrice.setText(String.valueOf(foood3.getPrice()));
    Glide.with(holder.itemView.getContext()).load(foood3.getImageUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(14))).into(holder.ivCover);


}

    @Override
    public int getItemCount() {
        return foods3.size();
    }



    class Foodviewholder3 extends RecyclerView.ViewHolder{
        TextView tvNAME,TvPrice, TVTime;
        ImageView ivCover;
        public Foodviewholder3 (@NonNull View itemView) {
            super(itemView);

         tvNAME = itemView.findViewById(R.id.tv_name);
         TvPrice =  itemView.findViewById(R.id.tv_price);

         ivCover = itemView.findViewById(R.id.iv_cover);
        }
    }
    }

