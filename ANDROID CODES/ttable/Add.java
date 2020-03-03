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

public class Add extends AppCompatActivity {

    EditText txtid,txtname,txtemail;

    StudentManager sm;
    SQLiteDatabase sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        txtid=(EditText) findViewById(R.id.txtid);
        txtname=(EditText) findViewById(R.id.txtname);
        txtemail=(EditText) findViewById(R.id.txtemail);

        sm=new StudentManager(this);
        sb=sm.openDb();
    }

    public void insertData(View v)
    {
        String id1=txtid.getText().toString();
        int id=Integer.parseInt(id1);

        String name=txtname.getText().toString();
        String email=txtemail.getText().toString();

        ContentValues cv=new ContentValues();

        cv.put(StudentConstant.COL_ID,id);
        cv.put(StudentConstant.COL_NAME,name);
        cv.put(StudentConstant.COL_EMAIL,email);


        long rw=sb.insert(StudentConstant.TBL_NAME,null,cv);


        if(rw>0)
        {
            Toast.makeText(this,"row inserted"+rw,Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if(sm!=null)
        {
            sm.closeDb();
        }
    }

}
