package com.example.pranaw.studentapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pranaw.studentapp.student.dbutil.StudentConstant;
import com.example.pranaw.studentapp.student.dbutil.StudentManager;

import java.io.ByteArrayInputStream;

public class Fetch extends AppCompatActivity
{
    EditText deptid,name;

    StudentManager sm;
    SQLiteDatabase sb;
    ImageView image;
    Bitmap bm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);

        deptid=(EditText) findViewById(R.id.deptid);

        name=(EditText) findViewById(R.id.name);

        sm=new StudentManager(this);
        sb=sm.openDb();
        image=(ImageView)findViewById(R.id.image);
        
    }

    public void fetch(View v)
    {
        String id=deptid.getText().toString();
        String[]args={id};

        Cursor c= sb.query(StudentConstant.PIC_TBL_NAME,null,StudentConstant.PIC_COL_ID+"=?",args,null,null,null,null);
        String dname=null;byte[]im=null;
        if(c!=null &&c.moveToFirst())
        {

            dname=c.getString(c.getColumnIndex(StudentConstant.PIC_COL_NAME));
            name.setText(dname);
            //Toast.makeText(this,dname,Toast.LENGTH_LONG).show();
            im=   c.getBlob(c.getColumnIndex(StudentConstant.PIC_COL_PIC));


        }

        ByteArrayInputStream ba=new ByteArrayInputStream(im);
        Bitmap b=BitmapFactory.decodeStream(ba);
        image.setImageBitmap(b);

        //c.close();




    }


}
