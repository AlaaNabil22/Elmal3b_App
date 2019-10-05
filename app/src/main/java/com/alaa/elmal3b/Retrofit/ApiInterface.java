package com.alaa.elmal3b.Retrofit;

import com.alaa.elmal3b.Model.ApiResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiInterface {


    @GET("top-headlines?country=eg&category=sports")
    Call<ApiResponse> getArt(@QueryMap Map<String, String> queryMap);
}
