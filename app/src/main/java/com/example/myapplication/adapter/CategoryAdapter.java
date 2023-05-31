package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Categoryy;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Categoryy>Categoriess;
    public CategoryAdapter(List<Categoryy>Categoriess){
        this.Categoriess = Categoriess;

    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_category, parent, false);
        return new CategoryAdapter.CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

holder.bind(Categoriess.get(position));
    }

    @Override
    public int getItemCount() {
        return Categoriess.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView tvtitle;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvtitle = itemView.findViewById(R.id.tv_title);
        }
            void bind(Categoryy categoryy){
                tvtitle.setText(categoryy.getTitle());
            }
        }
    }


