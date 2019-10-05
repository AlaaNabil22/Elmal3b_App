package com.alaa.elmal3b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    TextView sginUpTv;
    EditText  Email ,Pass;
    Button  Logbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Ref_id();


        sginUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,SginUpActivity.class);
                startActivity(i);
            }




        });

  Logbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        SharedPreferences sp = getSharedPreferences("Users_info", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        // Get username, password from EditText
        String email = Email.getText().toString();
        String password = Pass.getText().toString();

        // Validate if username, password is filled

        if (email.isEmpty()||password.isEmpty()){

            Snackbar snackbar = Snackbar
                .make(view, " يجب كتابة البريد الالكتروني وكلمة المرور", Snackbar.LENGTH_LONG);
            snackbar.show();
        }

     else  if (email.equals(sp.getString("Mail", ""))&password.equals(  sp.getString("Pass", ""))){

            Intent i = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(i);
            finish();

            Toast.makeText(LoginActivity.this, "مرحبا بكم", Toast.LENGTH_SHORT).show();


        }
        else {

            Snackbar snackbar = Snackbar
                    .make(view, " خطأ البريد الالكتروني أو كلمة المرور", Snackbar.LENGTH_LONG);
            snackbar.show();

        }





    }
       });

    }








    // id
    public  void  Ref_id(){

        sginUpTv =findViewById(R.id.sginUp);
        Email =findViewById(R.id.mail);
        Pass =findViewById(R.id.pass_pro);
        Logbtn =findViewById(R.id.logbtn);


    }
}
