package com.alaa.elmal3b.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alaa.elmal3b.R;

/**
 * Alaa Nabil.
 *
 *
 */
public class ProfileFragment extends Fragment {

    EditText mail , password;


    public ProfileFragment() {
        // Required empty public constructor
    }


    EditText getMail,getPassword;
    Button Edite;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);


         getMail =view.findViewById(R.id.email_profile);
         getPassword =view.findViewById(R.id.pass_pro);
         Edite  =view.findViewById(R.id.edit_prof);

         //SharedPreferences code
        SharedPreferences sp = getActivity().getSharedPreferences("Users_info", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();
        getMail.setText(sp.getString("Mail", ""));
        getPassword.setText(sp.getString("Pass", ""));

        Edite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("Mail",getMail.getText().toString() );
                editor.putString("Pass",getPassword.getText().toString() );
                editor.commit();

                Toast.makeText(getActivity(), "تم التعديل", Toast.LENGTH_SHORT).show();
            }
        });










        return view;
    }

}
