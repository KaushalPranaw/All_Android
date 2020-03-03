package com.example.pranaw.studentapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pranaw.studentapp.student.dbutil.StudentConstant;
import com.example.pranaw.studentapp.student.dbutil.StudentManager;

import java.util.ArrayList;

public class ViewAllStudents extends AppCompatActivity
{

    ListView lv;
    SQLiteDatabase sb;
    StudentManager sm;

    StudentBean s;

    ArrayList<StudentBean> studentlist;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_students);

        lv=(ListView) findViewById(R.id.lv);

        sm=new StudentManager(this);
        sb=sm.openDb();

        studentlist=new ArrayList<>();

        fillList();

        ArrayAdapter<StudentBean> ad=new ArrayAdapter<StudentBean>(this,android.R.layout.simple_expandable_list_item_1,studentlist);

        lv.setAdapter(ad);


    }



public void fillList()
{
    Cursor c=sb.query(StudentConstant.TBL_NAME,null,null,null,null,null,null);

    if(c!=null &&c.moveToFirst())
    {
        do{
            String name=c.getString(c.getColumnIndex(StudentConstant.COL_NAME));
            String email=c.getString(c.getColumnIndex(StudentConstant.COL_EMAIL));

            int stid=c.getInt(c.getColumnIndex(StudentConstant.COL_ID));

            s=new StudentBean();
            s.setId(stid);
            s.setName(name);
            s.setEmail(email);
            studentlist.add(s);



        }while(c.moveToNext());

    }


}

}
