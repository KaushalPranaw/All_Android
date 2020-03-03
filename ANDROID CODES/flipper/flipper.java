package com.example.pranaw.oeosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class flipper extends AppCompatActivity implements View.OnClickListener{
Button next,prev;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper);

        viewFlipper=(ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper.setOnClickListener(this);
        next=(Button) findViewById(R.id.next);
        prev=(Button) findViewById(R.id.prev);

        next.setOnClickListener(this);
        prev.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
       // viewFlipper.startFlipping();
        //viewFlipper.setFlipInterval(1000);
        if(v==next)
        {
            viewFlipper.showNext();
        }
        else if(v==prev)
        {
            viewFlipper.showPrevious();
        }

    }
}
