package com.example.pranaw.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddStudentPic extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_pic);

    }

    public void insertPicData(View v)
    {
        Intent i= new Intent(this,Insert.class);
        startActivity(i);
    }

    public void fetchPicData(View v)
    {
        Intent i= new Intent(this,Fetch.class);
        startActivity(i);
    }

    public void viewPicData(View v)
    {
        Intent i=new Intent(this,ViewPicList.class);
        startActivity(i);
        
    }




}
