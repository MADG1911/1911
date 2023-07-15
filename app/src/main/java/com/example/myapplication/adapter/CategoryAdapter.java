package com.example.myapplication.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Category;

import java.util.List;
import java.util.Locale;

public abstract class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> Categories;
    public CategoryAdapter(List<Category> Categories){
        this.Categories = Categories;

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
        holder.bind(Categories.get(position));
        holder.llCategory.setSelected(holder.llCategory.isSelected());
    }

    @Override
    public int getItemCount() {
        return Categories.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView tvtitle;
        private LinearLayout llCategory;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvtitle = itemView.findViewById(R.id.tv_title);
            llCategory = itemView.findViewById(R.id.ll_category);
        }
            void bind(Category category){
            tvtitle.setText(category.getName());
            }
        }
    }


