package com.example.pranaw.casetrackinghandlingapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

public class DeleteCase extends AppCompatActivity {

    CaseManager cm;
    SQLiteDatabase sb;

    EditText txtcaseid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_case);

        txtcaseid=(EditText) findViewById(R.id.txtcaseid);


        cm=new CaseManager(this);
        sb= cm.openDb();
    }

    public void deleteCase(View v)
    {
        String id1=txtcaseid.getText().toString();

        int id=Integer.parseInt(id1);

        String std=String.valueOf(id);
        String[] args={std};

        int rw=sb.delete(CaseConstant.CASE_TBL_NAME,CaseConstant.CASE_ID+" =?" ,args);
        if(rw>0){
            Toast.makeText(this,"case deleted",Toast.LENGTH_LONG).show();
        }
    }

}
