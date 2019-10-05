package com.alaa.elmal3b.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.alaa.elmal3b.DetailsActivity;
import com.alaa.elmal3b.Model.Article;
import com.alaa.elmal3b.R;
import com.alaa.elmal3b.Retrofit.ApiClient;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;


import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ItemHolder> {
    public List<Article> adsList;
    Context context;

    public HomeAdapter(List<Article> adsList , Context context)
    {
        this.adsList = adsList;
        this.context = context;

    }

    @NonNull
    @Override
    public HomeAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvhome, parent, false);
        final HomeAdapter.ItemHolder itemHolder = new HomeAdapter.ItemHolder(itemView);


        return itemHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int position) {



        // get data from list of response of ads
        final Article itemData = adsList.get(position);

        // set data of items of recycle view
        itemHolder.titleTv.setText(itemData.getTitle());
        itemHolder.dateTv.setText(itemData.getPublishedAt());

        itemHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("title" , itemData.getTitle());
                intent.putExtra("image" , ApiClient.IMAGE_PATH+itemData.getUrlToImage());
                intent.putExtra("date" , itemData.getPublishedAt());
                intent.putExtra("content" , itemData.getDescription());
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

                context.startActivity(intent);
            }
        });



        // download image from path and show it
        if (itemData.getUrlToImage() != null && itemData.getUrlToImage() != "")
        {

        Glide.with(context)
            .load(ApiClient.IMAGE_PATH+itemData.getUrlToImage())
            .listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                    Log.e("test***" , e.getMessage());
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    return false;
                }
            })
            .error(R.drawable.logo)
            .into(itemHolder.adIv);

          // Picasso.get().load(ApiClient.IMAGE_PATH+itemData.getUrlToImage()).error(R.drawable.logo).into(itemHolder.adIv);

        }


    }

    @Override
    public int getItemCount() {
        return adsList.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder
    {
        ImageView adIv ;
        TextView titleTv ,  dateTv;
        ConstraintLayout layout;

        public ItemHolder(View itemView)
        {
            super(itemView);
            layout  = itemView.findViewById(R.id.layout);
            adIv  = itemView.findViewById(R.id.img);
            titleTv  = itemView.findViewById(R.id.title);
            dateTv  = itemView.findViewById(R.id.date);
        }

    }

}
