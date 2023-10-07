package com.example.sharedprefdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.etusr);
        e2 = findViewById(R.id.etpwd);

        btn1 = findViewById(R.id.btn_login);
//its code use for session manage
        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        boolean islogged = sharedPreferences.getBoolean("isLogin",false);
        if (islogged)
        {
            startActivity(new Intent(MainActivity.this,HomePage.class));
        }


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("username",e1.getText().toString());
                editor.putString("userpassword",e2.getText().toString());
                editor.putBoolean("isLogin",true);
                editor.commit();
                Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,HomePage.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}