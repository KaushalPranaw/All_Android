package com.example.day2_login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    SharedPreferences sp;
    EditText textUserName,textUserPass;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        textUserName=findViewById(R.id.textUserName);
        textUserPass=findViewById(R.id.textUserPass);

        sp=getSharedPreferences("loginDetails",MODE_PRIVATE);

    }

    public void login(View v)
    {
        String id=textUserName.getText().toString();
        String pass=textUserPass.getText().toString();
        String spid=sp.getString("userName","");
        String sppass=sp.getString("userPass","");
        if(id.equals(spid)&&pass.equals(sppass))
        {
            startActivity(new Intent(this,CustomList.class));
            Toast.makeText(this,"Successfully logged in",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"invalid credential",Toast.LENGTH_LONG).show();
        }

    }
}
