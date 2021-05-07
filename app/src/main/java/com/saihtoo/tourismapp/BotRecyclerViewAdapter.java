package com.saihtoo.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BotRecyclerViewAdapter extends RecyclerView.Adapter<BotRecyclerViewAdapter.BotViewHolder>
{
    List<Destinations> myList;
    Context context;
    OnRowClickListener clickListener;

    public BotRecyclerViewAdapter(List<Destinations> botList, Context botContext, OnRowClickListener clickListener) {
        this.myList = botList;
        this.context = botContext;
        this.clickListener = clickListener;
    }

    @NonNull
    @NotNull
    @Override
    public BotViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bot_row, parent, false);
        return new BotViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BotRecyclerViewAdapter.BotViewHolder holder, int position) {
        holder.botImage.setImageResource(myList.get(position).getImage());
        holder.botText.setText(myList.get(position).getDescription());
        holder.botTitle.setText(myList.get(position).getTitle());
    }

    @Override
    public int getItemCount()
    {
        return myList.size();
    }

    public class BotViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView botImage;
        TextView botTitle, botText;
        OnRowClickListener clickListener;

        public BotViewHolder(@NonNull @NotNull View itemView, OnRowClickListener clickListener) {
            super(itemView);
            botImage = itemView.findViewById(R.id.botImageView);
            botText = itemView.findViewById(R.id.bot_Text);
            botTitle = itemView.findViewById(R.id.bot_Name);
            this.clickListener = clickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(getAdapterPosition());
        }
    }
    public interface OnRowClickListener { void onClick(int position);}
}
