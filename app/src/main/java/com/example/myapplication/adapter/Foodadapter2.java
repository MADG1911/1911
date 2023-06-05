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
import com.example.myapplication.model.food2;

import java.util.List;

public class Foodadapter2 extends RecyclerView.Adapter<Foodadapter2.Foodviewholder2>{
    List<food2> foods2;
    public Foodadapter2(List<food2> foods2){
      this.foods2 = foods2;

    }
    @NonNull
    @Override
    public Foodviewholder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View itemView = inflater.inflate(R.layout.item_food2, parent, false);
        return new Foodviewholder2(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Foodviewholder2 holder, int position) {
bind(holder, foods2.get(position));


    }
void bind (Foodviewholder2 holder, food2 foood2){
    holder.tvNAME.setText(foood2.getFood_name());
    holder.TvPrice.setText(String.valueOf(foood2.getPrice()));
    Glide.with(holder.itemView.getContext()).load(foood2.getImageUrl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(14))).into(holder.ivCover);


}

    @Override
    public int getItemCount() {
        return foods2.size();
    }



    class Foodviewholder2 extends RecyclerView.ViewHolder{
        TextView tvNAME,TvPrice, TVTime;
        ImageView ivCover;
        public Foodviewholder2 (@NonNull View itemView) {
            super(itemView);

         tvNAME = itemView.findViewById(R.id.tv_name);
         TvPrice =  itemView.findViewById(R.id.tv_price);

         ivCover = itemView.findViewById(R.id.iv_cover);
        }
    }
    }

