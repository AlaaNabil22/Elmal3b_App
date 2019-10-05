package com.alaa.elmal3b.Retrofit;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *Created by Alaa Nabil on 2019.
 ***/

public class ApiClient {


    public final String BASE_URL = "https://newsapi.org/v2/";
    public final static String IMAGE_PATH = "";;

    private Retrofit retrofit = null;
    private Context context;

    public ApiClient(Context context)
    {
        this.context = context;
    }


    public Retrofit getClient()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .build();

        if(retrofit == null)
        {
            String url;

            url = BASE_URL;

            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
