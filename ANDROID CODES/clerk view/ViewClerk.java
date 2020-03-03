package com.example.pranaw.casetrackinghandlingapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

import java.util.ArrayList;

public class ViewClerk extends AppCompatActivity
{
    CaseManager cm;
    SQLiteDatabase sb;

    ClerkDetail cd;

    ListView lv;
    ArrayList<ClerkDetail> clerkDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_clerk);

        lv=(ListView) findViewById(R.id.lv);

        cm=new CaseManager(this);
       sb= cm.openDb();



        clerkDetailList=new ArrayList<ClerkDetail>();
        fillList();
        ClerkAdapter ad=new ClerkAdapter(this,clerkDetailList);
        lv.setAdapter(ad);




    }

    public void fillList()
    {
        Cursor c=sb.query(CaseConstant.TBL_NAME,null,null,null,null,null,null);

        if(c!=null &&c.moveToFirst())
        {
            do{

                //  int id=c.getInt(c.getColumnIndex(StudentConstant.PIC_COL_ID));
                String name2=c.getString(c.getColumnIndex(CaseConstant.CLERK_NAME));
                String address2=c.getString(c.getColumnIndex(CaseConstant.CLERK_ADDRESS));
                String phone2=c.getString(c.getColumnIndex(CaseConstant.CLERK_PHONE));
                String gender2=c.getString(c.getColumnIndex(CaseConstant.CLERK_GENDER));


                byte[] pic=c.getBlob(c.getColumnIndex(CaseConstant.CLERK_PIC));


                cd=new ClerkDetail();
                //   d.setId(id);
                cd.setName(name2);
                cd.setClerkpic(pic);
                cd.setAddress(address2);
                cd.setGender(gender2);
                cd.setPhone(phone2);
                clerkDetailList.add(cd);
            }while(c.moveToNext());


            cm.closeDb();


        }
    }
}
