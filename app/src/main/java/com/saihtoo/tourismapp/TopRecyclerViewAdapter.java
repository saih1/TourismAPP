package com.saihtoo.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TopRecyclerViewAdapter extends RecyclerView.Adapter<TopRecyclerViewAdapter.TopViewHolder> {
    List<Destinations> myList;
    Context context;

    public TopRecyclerViewAdapter(List<Destinations> topList, Context topContext) {
        this.myList = topList;
        this.context = topContext;
    }

    @NonNull
    @NotNull
    @Override
    public TopViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_row, parent, false);
        return new TopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TopRecyclerViewAdapter.TopViewHolder holder, int position) {
        holder.topImage.setImageResource(myList.get(position).getImage());
    }

    @Override
    public int getItemCount()
    {
        return myList.size();
    }

    public class TopViewHolder extends RecyclerView.ViewHolder {
        ImageView topImage;
        public TopViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            topImage = itemView.findViewById(R.id.topImageView);
        }
    }
}
