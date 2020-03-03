package com.example.day2_login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences.Editor se;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("loginDetails", MODE_PRIVATE);
        se = sp.edit();
        se = se.putString("userName", "pranaw");
        se.commit();
        se = se.putString("userPass", "1234");
        se.commit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, LoginPage.class);
                startActivity(i);
                MainActivity.this.finish();
            }
        }, 2000);
    }
}
