package com.example.pranaw.imagedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void insert(View v){
        Intent i= new Intent(this,Insert.class);
        startActivity(i);
    }
    public void fetch(View v){
        Intent i= new Intent(this,Fetch.class);
        startActivity(i);}

    public void view1(View v){
        Intent i= new Intent(this,ViewPicList.class);
        startActivity(i);}





}
