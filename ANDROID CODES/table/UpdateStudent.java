package com.example.pranaw.studentapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pranaw.studentapp.student.dbutil.StudentConstant;
import com.example.pranaw.studentapp.student.dbutil.StudentManager;

public class UpdateStudent extends AppCompatActivity
{
    EditText txtid,txtname,txtemail;

    StudentManager sm;
    SQLiteDatabase sb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        sm=new StudentManager(this);
        sb=sm.openDb();

        txtid=(EditText) findViewById(R.id.txtid);
        txtname=(EditText) findViewById(R.id.txtname);
        txtemail=(EditText) findViewById(R.id.txtemail);

    }

    public void updateData(View v)
    {

        String id=txtid.getText().toString();
        String name=txtname.getText().toString();
        String email=txtemail.getText().toString();

/*
        String id="10";
        String email="pk@gmail.com";*/


        String[] args={id};

        ContentValues cv=new ContentValues();
        cv.put(StudentConstant.COL_EMAIL,email);
        cv.put(StudentConstant.COL_NAME,name);
        long l=sb.update(StudentConstant.TBL_NAME,cv,StudentConstant.COL_ID+" =?",args);


        if(l>0)
        {
            Toast.makeText(this,"update data",Toast.LENGTH_LONG).show();
        }
    }


}
