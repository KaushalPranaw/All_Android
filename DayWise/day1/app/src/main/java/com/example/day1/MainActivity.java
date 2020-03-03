package com.example.day1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   SharedPreferences sp;
   SharedPreferences.Editor se;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences("logininfo",MODE_PRIVATE);
        se=sp.edit();
        se=se.putString("userid","pranaw");
        se.commit();

        se=se.putString("userpass","pranaw");
        se.commit();

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,Login.class);
                startActivity(i);
                MainActivity.this.finish();
            }
        },2000);

    }



}
