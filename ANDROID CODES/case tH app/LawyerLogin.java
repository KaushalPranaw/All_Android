package com.example.pranaw.casetrackinghandlingapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LawyerLogin extends AppCompatActivity
{
    SharedPreferences sp;
    EditText txtuserid;
    EditText txtuserpass;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_login);

        txtuserid=(EditText) findViewById(R.id.txtuserid);
        txtuserpass=(EditText) findViewById(R.id.txtuserpass);

        sp=getSharedPreferences("lawyer",MODE_PRIVATE);




    }

    public void sumbit(View v)
    {
        String userid=txtuserid.getText().toString();
        String userpass=txtuserpass.getText().toString();

      /*  userid=sp.getString("userid",null);
        userpass=sp.getString("userpass",null);*/
        if(userid.equals(sp.getString("userid",null))&&userpass.equals(sp.getString("userpass",null))) {
            Toast.makeText(this, "submitted", Toast.LENGTH_LONG).show();

            Intent i = new Intent(this, LawyerPage.class);
            startActivity(i);
        }
        else
        { Toast.makeText(this, "wrong id and password", Toast.LENGTH_LONG).show();}

    }





}
