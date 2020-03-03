package com.example.pranaw.casetrackinghandlingapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

import java.io.ByteArrayInputStream;

public class FetchCase extends AppCompatActivity
{

    EditText txtclientid,txtcasename,txtcaseid, txtjudgement,txtdecision;


    CaseManager cm;
    SQLiteDatabase sb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_case);

        txtclientid=(EditText) findViewById(R.id.txtclientid);
        txtcasename=(EditText) findViewById(R.id.txtcasename);
        txtcaseid=(EditText) findViewById(R.id.txtcaseid);
        txtjudgement=(EditText) findViewById(R.id.txtjudgement);
        txtdecision=(EditText) findViewById(R.id.txtdecision);

        cm=new CaseManager(this);
        sb=cm.openDb();

    }
    public void fetchCase(View v)
    {
        String id = txtcaseid.getText().toString();



        String[]args={id};

        Cursor c= sb.query(CaseConstant.CASE_TBL_NAME,null,CaseConstant.CASE_ID+"=?",args,null,null,null,null);
        String name1=null;
        String judge=null;
        String decision=null;
        String clientid=null;
        if(c!=null &&c.moveToFirst())
        {

            clientid=c.getString(c.getColumnIndex(CaseConstant.CCLIENT_ID));
            txtclientid.setText(clientid);
            name1=c.getString(c.getColumnIndex(CaseConstant.CASE_NAME));
            txtcasename.setText(name1);
            judge=c.getString(c.getColumnIndex(CaseConstant.CASE_JUGDEMENT));
            txtjudgement.setText(judge);
            decision=c.getString(c.getColumnIndex(CaseConstant.CASE_DECESION));
            txtdecision.setText(decision);


        }

    }


}
