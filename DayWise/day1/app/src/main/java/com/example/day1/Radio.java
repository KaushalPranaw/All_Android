package com.example.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Radio extends AppCompatActivity {

    Button button;
    RadioGroup rg;
    RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        rg=(RadioGroup) findViewById(R.id.rg);

    }

    public void check(View v)
    {
        int selectId=rg.getCheckedRadioButtonId();
        rb=(RadioButton) findViewById(selectId);
        if(selectId==-1)
        {
            Toast.makeText(this,"Nothing Selected",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,rb.getText(),Toast.LENGTH_LONG).show();
        }
    }
}
