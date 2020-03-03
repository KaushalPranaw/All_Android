package com.example.pranaw.casetrackinghandlingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ArrayList<String> mylist=(ArrayList<String>)getIntent().getSerializableExtra("cno");

    }
}
