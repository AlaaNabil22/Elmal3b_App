package com.alaa.elmal3b.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alaa.elmal3b.Adapters.HomeAdapter;
import com.alaa.elmal3b.Model.ApiResponse;
import com.alaa.elmal3b.Model.Listner;
import com.alaa.elmal3b.R;
import com.alaa.elmal3b.Retrofit.ApiCalling;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements Listner {


    public HomeFragment() {
        // Required empty public constructor
    }


    ApiCalling apiCalling;
    RecyclerView adsRv;
    HomeAdapter homeAdapter;
    LinearLayoutManager linearLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        adsRv = view.findViewById(R.id.rv);
        apiCalling = new ApiCalling(getActivity());
        apiCalling.getNewsListner(this);
        return view;
    }

    @Override
    public void getNewsListner(boolean status, ApiResponse apiResponse) {


        if(status == true)
        {

            homeAdapter = new HomeAdapter(apiResponse.getArticles() , getActivity());
            linearLayoutManager = new LinearLayoutManager(getActivity() ,
                    LinearLayoutManager.VERTICAL,false);
            adsRv.setAdapter(homeAdapter);
            adsRv.setLayoutManager(linearLayoutManager);
        }

    }
}
