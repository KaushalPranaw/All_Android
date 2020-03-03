package com.example.pranaw.studentapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pranaw.studentapp.student.dbutil.StudentConstant;
import com.example.pranaw.studentapp.student.dbutil.StudentManager;

public class StudentData extends AppCompatActivity
{
    StudentManager sm;
    SQLiteDatabase sb;

    TextView txtname;
    TextView txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);

        txtemail=(TextView)findViewById(R.id.txtemail);
        txtname=(TextView)findViewById(R.id.txtname);

        sm=new StudentManager(this);
        sb=sm.openDb();

        Intent i= getIntent();
        String id=i.getStringExtra("id");
        String args[]={id};

        Cursor c=sb.query(StudentConstant.TBL_NAME,null,StudentConstant.COL_ID+" =?",args,null,null,null,null);

        String name=null,email=null;

        if(c!=null &&c.moveToFirst())
        {
            name=c.getString(c.getColumnIndex(StudentConstant.COL_NAME));//(2)
            email=c.getString(c.getColumnIndex(StudentConstant.COL_EMAIL));

            c.close();
        }
        txtname.setText(name);
        txtemail.setText(email);



    }




}
