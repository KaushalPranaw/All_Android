package com.example.day1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    SharedPreferences sp;
    EditText textUserName,textUserPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textUserName=findViewById(R.id.textUserName);
        textUserPass=findViewById(R.id.textUserPass);
        sp= getSharedPreferences("loginInfo",MODE_PRIVATE);
    }

    public void submit(View v)
    {
        String userId=textUserName.getText().toString();
        String userPass=textUserPass.getText().toString();
        userId=sp.getString("userid",null);
        userPass=sp.getString("userpass",null);

        Toast.makeText(this,"submitted",Toast.LENGTH_SHORT).show();
    }
}
