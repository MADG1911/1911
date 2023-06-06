package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {
    boolean isshowpassword = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       ImageView ivshowpassword = findViewById(R.id.iv_show_password);
        EditText etpassword = findViewById(R.id.et_password);
               ivshowpassword.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       if (isshowpassword) {
                           ivshowpassword.setImageResource(R.drawable.ice_eye);
                           etpassword.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);

                       }
                       else {
                           ivshowpassword.setImageResource(R.drawable.eyeoff);
                           etpassword.setInputType(InputType.TYPE_CLASS_TEXT);

                   }
                       isshowpassword = !isshowpassword;


               //  Log.d("AAA","on show password clioc!!!" );
                   }
               });
Button btnsingin= findViewById(R.id.btn_sing_in);
btnsingin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        SharedPreferences pref = getSharedPreferences("uni-project", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("is_login",true);
        editor.apply();


        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        AfterSplash AF = new AfterSplash() ;
        AF.finish();


    }
});
        ImageView Imageback = findViewById(R.id.Back_image);
        Imageback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, AfterSplash.class);
                startActivity(intent);


            }


        });
    }
}
