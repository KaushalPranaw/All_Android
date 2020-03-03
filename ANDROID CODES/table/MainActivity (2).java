package com.example.pranaw.studentapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pranaw.studentapp.student.dbutil.StudentConstant;
import com.example.pranaw.studentapp.student.dbutil.StudentManager;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View v)
    {
        Intent i = new Intent(this, Add.class);
        startActivity(i);

    }
    public void delete(View v)
    {
        Intent i = new Intent(this, DeleteStudent.class);
        startActivity(i);

    }
    public void update(View v)
    {
        Intent i = new Intent(this, UpdateStudent.class);
        startActivity(i);

    }
    public void search(View v)
    {
        Intent i = new Intent(this, SearchStudent.class);
        startActivity(i);

    }

    public void view1(View v)
    {
        Intent i = new Intent(this, ViewAllStudents.class);
        startActivity(i);

    }


}
