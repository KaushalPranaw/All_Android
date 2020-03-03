package com.example.pranaw.calling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pranaw.calling_messaging.R;

public class EventHandling extends AppCompatActivity implements View.OnClickListener{
    Button btnclick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handling);

        btnclick=(Button) findViewById(R.id.btnclick);

        btnclick.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this,"button clicked",Toast.LENGTH_LONG).show();
    }
}
