package com.alaa.elmal3b;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.alaa.elmal3b.Model.Article;
import com.alaa.elmal3b.Retrofit.ApiClient;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class DetailsActivity extends AppCompatActivity {
    ImageView img;
    TextView title , content , imgurl;

    String tit,desc,imageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
         Intent intent =getIntent();
        getId();

        imageUrl = intent.getStringExtra("image");
        tit  = intent.getStringExtra("title");
        desc  = intent.getStringExtra("content");


        Glide.with(this)
            .load(ApiClient.IMAGE_PATH+imageUrl)
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
            .into(img);
        title.setText(tit);
        content.setText(desc);


    }
    void getId(){

        img =findViewById(R.id.photo);
        title =findViewById(R.id.TITLE);
        content =findViewById(R.id.des);



    }
}
