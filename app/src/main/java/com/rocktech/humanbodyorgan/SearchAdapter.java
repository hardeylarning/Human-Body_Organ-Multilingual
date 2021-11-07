package com.rocktech.humanbodyorgan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    Context context;
    Activity activity;
    List<Organ> organs;

    public SearchAdapter(Context context, Activity activity, List<Organ> organs) {
        this.context = context;
        this.activity = activity;
        this.organs = organs;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.organ, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        holder.title.setText(organs.get(position).getTitle());
        Glide.with(context).asBitmap()
                .load(organs.get(position).getImage_url())
                .centerCrop()
                .into(holder.image_url);
        holder.linearLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", organs.get(position).getTitle());
            intent.putExtra("description", organs.get(position).getDescription());
            intent.putExtra("image_url", organs.get(position).getImage_url());
            // intent.putExtra("id", organs.get(position).getId());
            activity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return organs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image_url;
        CardView linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image_url = itemView.findViewById(R.id.image);
            linearLayout = itemView.findViewById(R.id.holder);
        }
    }

}
