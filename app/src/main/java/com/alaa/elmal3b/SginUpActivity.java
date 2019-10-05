package com.alaa.elmal3b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

public class SginUpActivity extends AppCompatActivity {

    EditText mail , password ,Repasword;
    ImageView back_login;
    Button Sginbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgin_up);




        find_Id();






        Sginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // check To Sgin Up



                if (mail.getText().toString().isEmpty()){




                    Snackbar snackbar = Snackbar
                            .make(view, " خطأ البريد الالكتروني", Snackbar.LENGTH_LONG);
                    snackbar.show();





                }
                else if(password.getText().toString().isEmpty()){

                    Snackbar snackbar = Snackbar
                        .make(view, " يجب كتابة كلمة مرور", Snackbar.LENGTH_LONG);
                    snackbar.show();

                }

                else  if (!password.getText().toString().equals(Repasword.getText().toString())){

                    Snackbar snackbar = Snackbar
                            .make(view, " خطأ كلمة المرور", Snackbar.LENGTH_LONG);
                    snackbar.show();

                }


               else {


                    SharedPreferences sp = getSharedPreferences("Users_info", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Mail",mail.getText().toString() );
                    editor.putString("Pass",password.getText().toString() );
                    editor.commit();

                    Snackbar snackbar = Snackbar
                            .make(view, " تم التسجيل بنجاح", Snackbar.LENGTH_LONG);
                    snackbar.show();



                }
            }
        });




  back_login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Intent i = new Intent(SginUpActivity.this,LoginActivity.class);
        startActivity(i);
    }
  });


    }


    public void find_Id(){

        mail =findViewById(R.id.email_profile);
        password =findViewById(R.id.pass_pro);
        Repasword =findViewById(R.id.cpass);
        back_login =findViewById(R.id.back);
        Sginbtn =findViewById(R.id.sginbtn);

    }
}
