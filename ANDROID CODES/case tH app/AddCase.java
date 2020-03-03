package com.example.pranaw.casetrackinghandlingapp;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class AddCase extends AppCompatActivity
{
    EditText txtclientid,txtcasename,txtcaseid, txtjudgement,txtdecision;


    CaseManager cm;
    SQLiteDatabase sb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_case);

        txtclientid=(EditText) findViewById(R.id.txtclientid);
        txtcasename=(EditText) findViewById(R.id.txtcasename);
        txtcaseid=(EditText) findViewById(R.id.txtcaseid);
        txtjudgement=(EditText) findViewById(R.id.txtjudgement);
        txtdecision=(EditText) findViewById(R.id.txtdecision);

        cm=new CaseManager(this);
        sb=cm.openDb();


    }

    public void add(View v) {
        String clientid = txtclientid.getText().toString();
        String name=txtcasename.getText().toString();
        String caseid=txtcaseid.getText().toString();

        String decision=txtdecision.getText().toString();
        String judge=txtjudgement.getText().toString();




        ContentValues cv = new ContentValues();
        cv.put(CaseConstant.CCLIENT_ID, clientid);
        cv.put(CaseConstant.CASE_ID, caseid);
        cv.put(CaseConstant.CASE_NAME, name);
        cv.put(CaseConstant.CASE_JUGDEMENT, judge);
        cv.put(CaseConstant.CASE_DECESION, decision);


        long rw = sb.insert(CaseConstant.CASE_TBL_NAME, null, cv);

        if (rw > 0) {
            String id = txtclientid.getText().toString();
            String[]args={id};
            Cursor c= sb.query(CaseConstant.CLIENT_TBL_NAME,null,CaseConstant.CLIENT_ID+"=?",args,null,null,null,null);
            String phone=null;
            if(c!=null &&c.moveToFirst())
            {
                phone=c.getString(c.getColumnIndex(CaseConstant.CLIENT_PHONE));
            }

            SmsManager sm=SmsManager.getDefault();
            Intent obj=new Intent(this,AddCase.class);
            PendingIntent pi=PendingIntent.getActivity(this,1,obj,PendingIntent.FLAG_ONE_SHOT);
            sm.sendTextMessage(phone,null,"This case is aasigned me."+"Your Case id is "+caseid+
                    " And case name is "+name+" successfully recorded. Decision of case is"+decision
                    +"judgement is "+judge,pi,null);
            Toast.makeText(this,"case added", Toast.LENGTH_LONG).show();
            Toast.makeText(this,"message sent", Toast.LENGTH_LONG).show();
        }

    }

}
