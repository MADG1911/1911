package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class AfterSplash extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_splash);

            Button btnsignin = findViewById(R.id.btn_sing_in);
            btnsignin.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {

                    Intent intent = new Intent(AfterSplash.this, loginactivity.class);
                    startActivity(intent);
                }
            });


        TextView signupsplash = findViewById(R.id.signup_splash);
       signupsplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AfterSplash.this, Signuplayout.class);
                startActivity(intent);
               }


        });
        }
    }