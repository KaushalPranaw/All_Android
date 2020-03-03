package com.example.pranaw.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }
    public void showDLG(View v)
    {
        new CustomDialog().show(getSupportFragmentManager(),"my dialog"); //or

       /*  CustomDialog cd=new CustomDialog();
        FragmentManager fm=getSupportFragmentManager();
        cd.show(fm,"my dialog");
*/
    }

}
