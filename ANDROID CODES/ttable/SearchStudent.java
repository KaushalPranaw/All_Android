package com.example.pranaw.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchStudent extends AppCompatActivity {
    EditText txtid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_student);

        txtid=(EditText) findViewById(R.id.txtid);
    }

    public void searchData(View v)
    {
        String id=txtid.getText().toString();
        /*
        int id1=50;
        String id= String.valueOf(id1);*/
        Intent i=new Intent(this,StudentData.class);
        i.putExtra("id",id);
        startActivity(i);
    }
}
