package com.example.pranaw.loginwithsp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginInfo extends AppCompatActivity {
    SharedPreferences sp;
    EditText txtuserid;
    EditText txtuserpass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_info);

        txtuserid=(EditText) findViewById(R.id.txtuserid);
        txtuserpass=(EditText) findViewById(R.id.txtuserpass);

        sp=getSharedPreferences("loginInfo",MODE_PRIVATE);

    }
    public void sumbit(View v)
    {
        String userid=txtuserid.getText().toString();
        String userpass=txtuserpass.getText().toString();

        userid=sp.getString("userid",null);
        userpass=sp.getString("userpass",null);
        Toast.makeText(this,"submitted",Toast.LENGTH_LONG).show();

    }
}
