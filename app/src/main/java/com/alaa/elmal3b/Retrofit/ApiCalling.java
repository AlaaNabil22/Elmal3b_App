package com.alaa.elmal3b.Retrofit;

import android.content.Context;
import android.widget.Toast;

import com.alaa.elmal3b.Model.ApiResponse;
import com.alaa.elmal3b.Model.Listner;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCalling {

    private ApiClient apiClient;
    private ApiInterface apiInterface;
    private Context context;

    public ApiCalling(Context context )
    {
        this.context = context;
        apiClient = new ApiClient(context);
        apiInterface = apiClient.getClient().create(ApiInterface.class);

    }

    public void getNewsListner(final Listner listner) {

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("country", "eg");
        queryMap.put("category", "sports");
        queryMap.put("apiKey", "a97906dc339f481dbf69cea1442b1b6a");



        Call<ApiResponse> call = apiInterface.getArt(queryMap);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {

                   // Toast.makeText(context, "Successful", Toast.LENGTH_SHORT).show();
                    listner.getNewsListner(true, response.body());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(context, "تاكد من الاتصال بالانترنت", Toast.LENGTH_SHORT).show();
                listner.getNewsListner(false, null);
            }
        });


    }}
