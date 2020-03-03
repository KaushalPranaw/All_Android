package com.example.pranaw.casetrackinghandlingapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

public class ClerkLogin extends AppCompatActivity
{

    EditText txtclerkid,txtclerkpass;
    CaseManager cm;
    SQLiteDatabase sb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clerk_login);

        txtclerkid=(EditText)findViewById(R.id.txtclerkid);
        txtclerkpass=(EditText)findViewById(R.id.txtclerkpass);

        cm=new CaseManager(this);
        sb= cm.openDb();


    }

    public void sumbit(View v)
    {
        String userid=txtclerkid.getText().toString();
        String userpass=txtclerkpass.getText().toString();

        String[]args={userid};

        Cursor c= sb.query(CaseConstant.TBL_NAME,null,CaseConstant.CLERK_ID+"=?",args,null,null,null,null);

        if(c!=null &&c.moveToNext())
        {

          String  id1=c.getString(c.getColumnIndex(CaseConstant.CLERK_ID));

          String  pass1=c.getString(c.getColumnIndex(CaseConstant.CLERK_PASS));

            if(id1.equals(userid)&&pass1.equals(userpass))
            {
                Intent i= new Intent(this,ClerkPage.class);
                startActivity(i);
                Toast.makeText(this,"successfully login",Toast.LENGTH_LONG).show();


            }
            else
            {
                Toast.makeText(this,"wrong id and password",Toast.LENGTH_LONG).show();

            }






        }
  }

}
