package com.example.pranaw.casetrackinghandlingapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

public class DeleteClerk extends AppCompatActivity
{
    CaseManager cm;
    SQLiteDatabase sb;

    EditText txtid;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_clerk);


        txtid=(EditText) findViewById(R.id.txtid);


        cm=new CaseManager(this);
       sb= cm.openDb();
    }

    public void deleteClerk(View v)
    {
        String id1=txtid.getText().toString();

        int id=Integer.parseInt(id1);

        String std=String.valueOf(id);
        String[] args={std};

        int rw=sb.delete(CaseConstant.TBL_NAME,CaseConstant.CLERK_ID+" =?" ,args);
        if(rw>0){
            Toast.makeText(this,"clerk deleted",Toast.LENGTH_LONG).show();
        }
    }

}
