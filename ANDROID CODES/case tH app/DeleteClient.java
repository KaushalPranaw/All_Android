package com.example.pranaw.casetrackinghandlingapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

public class DeleteClient extends AppCompatActivity {


    CaseManager cm;
    SQLiteDatabase sb;

    EditText txtclientid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_client);

        txtclientid=(EditText) findViewById(R.id.txtclientid);


        cm=new CaseManager(this);
        sb= cm.openDb();
    }

    public void deleteClient(View v)
    {
        String id1=txtclientid.getText().toString();

        int id=Integer.parseInt(id1);

        String std=String.valueOf(id);
        String[] args={std};

        int rw=sb.delete(CaseConstant.CLIENT_TBL_NAME,CaseConstant.CLIENT_ID+" =?" ,args);
        if(rw>0){
            Toast.makeText(this,"client deleted",Toast.LENGTH_LONG).show();
        }
    }

}
