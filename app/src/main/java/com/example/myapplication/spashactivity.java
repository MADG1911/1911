package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

public class spashactivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SharedPreferences pref = getSharedPreferences("uni-project", MODE_PRIVATE);
        boolean isLogin = pref.getBoolean("is_login", false);

        if (isLogin) {
            goMain();
        } else {
            goLogin();
        }
    }



    private void goMain(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(spashactivity.this, mainactivity.class);
                startActivity(intent);
                finish();
                // کدی که می خواهید با تاخیر اجرا شود
            }
        }, 2000); // تاخیر به میلی ثانیه

    }
    private void goLogin(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(spashactivity.this, loginactivity.class);
                startActivity(intent);
                finish();
                // کدی که می خواهید با تاخیر اجرا شود
            }
        }, 2000); // تاخیر به میلی ثانیه

    }
}
