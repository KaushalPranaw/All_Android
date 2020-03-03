package com.example.pranaw.studentapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pranaw.studentapp.student.dbutil.StudentConstant;
import com.example.pranaw.studentapp.student.dbutil.StudentManager;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;


public class ViewPicList extends AppCompatActivity {

    StudentManager sm;
    SQLiteDatabase sb;

    Department d;

    ListView lv;
    ArrayList<Department> deptlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pic_list);

        lv=(ListView) findViewById(R.id.lv);

        sm=new StudentManager(this);
        sb=sm.openDb();

        deptlist=new ArrayList<Department>();
        fillList();

        MyAdapter ad=new MyAdapter(this,deptlist);
        lv.setAdapter(ad);




    }
    public void fillList()
    {
        Cursor c=sb.query(StudentConstant.PIC_TBL_NAME,null,null,null,null,null,null);

        if(c!=null &&c.moveToFirst())
        {
            do{

               // int id=c.getInt(c.getColumnIndex(StudentConstant.PIC_COL_ID));
                String name=c.getString(c.getColumnIndex(StudentConstant.PIC_COL_NAME));
                byte[] pic=c.getBlob(c.getColumnIndex(StudentConstant.PIC_COL_PIC));
           //     ByteArrayInputStream bis=new ByteArrayInputStream(pic);
            //   Bitmap bm= BitmapFactory.decodeStream(bis);




                d=new Department();
             //   d.setId(id);
                d.setName(name);
                d.setHodpic(pic);

                deptlist.add(d);



            }while(c.moveToNext());

        }
       c.close();



    }

}
