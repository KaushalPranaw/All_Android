package com.example.pranaw.studentapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pranaw.studentapp.student.dbutil.StudentConstant;
import com.example.pranaw.studentapp.student.dbutil.StudentManager;

public class DeleteStudent extends AppCompatActivity
{
    StudentManager sm;
    SQLiteDatabase sb;

    EditText txtid;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        txtid=(EditText) findViewById(R.id.txtid);


        sm=new StudentManager(this);
        sb=sm.openDb();

    }

    public void deleteData(View v)
    {
        String id1=txtid.getText().toString();

        int id=Integer.parseInt(id1);

        String std=String.valueOf(id);
        String[] args={std};

        int rw=sb.delete(StudentConstant.TBL_NAME,StudentConstant.COL_ID+" =?" ,args);
        if(rw>0){
            Toast.makeText(this,"data delete",Toast.LENGTH_LONG).show();
        }
    }



}
