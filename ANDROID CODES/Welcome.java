package com.example.pranaw.casetrackinghandlingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class  Welcome extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor se;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        sp=getSharedPreferences("lawyer",MODE_PRIVATE);
        se=sp.edit();

        se= se.putString("userid","pranaw");
        se.commit();

        se=se.putString("userpass","1234");
        se.commit();


        Handler h=new Handler();
        h.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent i=new Intent(Welcome.this,MainPage.class);
                startActivity(i);
                Welcome.this.finish(); //for new activity open we have done this


            }
        },2000);
    }
}
