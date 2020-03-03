/*
package com.example.pranaw.casetrackinghandlingapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

import java.io.ByteArrayOutputStream;

public class Add extends AppCompatActivity {

    CaseManager cm;
    SQLiteDatabase sb;
   Bitmap bm;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        cm=new CaseManager(this);
        sb=cm.openDb();
    }

    public void add(View v) {
        String name = "pranaw";
        String id = "1";
        String address = "bbd";
        String gender = "male";

        String phone1 = "8574235051";
        String pass = "123";

        bm = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] imgarr = bos.toByteArray();


        ContentValues cv = new ContentValues();
        cv.put(CaseConstant.CLERK_ID, id);
        cv.put(CaseConstant.CLERK_NAME, name);
        cv.put(CaseConstant.CLERK_ADDRESS, address);
        cv.put(CaseConstant.CLERK_GENDER, gender);
        cv.put(CaseConstant.CLERK_PASS, pass);
        cv.put(CaseConstant.CLERK_PHONE, phone1);
        cv.put(CaseConstant.CLERK_PIC, imgarr);


        long rw = sb.insert(CaseConstant.TBL_NAME, null, cv);

        if (rw > 0) {
            Toast.makeText(this, "row inserted" + rw, Toast.LENGTH_LONG).show();
        }

*/
/*

   String caseid="1";
        String clientid="2";
        String casename="rape";
        String judgement="abcd";
        String decesion="pending";

        ContentValues cv=new ContentValues();
        cv.put(CaseConstant.CASE_ID,caseid);
        cv.put(CaseConstant.CCLIENT_ID,clientid);
        cv.put(CaseConstant.CASE_NAME,casename);
        cv.put(CaseConstant.CASE_JUGDEMENT,judgement);
        cv.put(CaseConstant.CASE_DECESION,decesion);

        long rw=sb.insert(CaseConstant.CASE_TBL_NAME,null,cv);

        if(rw>0)
        {
            Toast.makeText(this,"row inserted"+rw,Toast.LENGTH_LONG).show();
        }

   String id="1";
        String name="pk";
        String address="srmcem";
        String phone="857456156";
        String gender="male";

        bm= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG,100,bos);
        byte[]imgarr= bos.toByteArray();

        ContentValues cv=new ContentValues();
        cv.put(CaseConstant.CLIENT_ID,id);
        cv.put(CaseConstant.CLIENT_NAME,name);
        cv.put(CaseConstant.CLIENT_ADDRESS,address);
        cv.put(CaseConstant.CLIENT_PHONE,phone);
        cv.put(CaseConstant.CLIENT_GENDER,gender);

        cv.put(CaseConstant.CLIENT_PIC,imgarr);


        long rw=sb.insert(CaseConstant.CLIENT_TBL_NAME,null,cv);

        if(rw>0)
        {
            Toast.makeText(this,"row inserted"+rw,Toast.LENGTH_LONG).show();
        }


*//*



    }


}
*/
