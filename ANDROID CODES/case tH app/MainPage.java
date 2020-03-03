package com.example.pranaw.casetrackinghandlingapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainPage extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        FragmentManager fm=getSupportFragmentManager();

        FragmentTransaction ft=fm.beginTransaction();

        ft.replace(R.id.top,new TopFragment());

        getSupportFragmentManager().beginTransaction().replace(R.id.bottm,new BottomFragment()).commit();//sahi tarika h ye

        // ft.replace(R.id.bottm,new BottomFragment());//galat hai ye

        ft.commit();
    }
}

