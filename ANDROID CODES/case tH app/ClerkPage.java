package com.example.pranaw.casetrackinghandlingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class ClerkPage extends AppCompatActivity
{
    Spinner spinnerClient,spinnerCase;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clerk_page);

        spinnerCase=(Spinner)findViewById(R.id.spinnerCase);
        spinnerClient=(Spinner)findViewById(R.id.spinnerClient);

        spinnerCase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 1:
                        Intent i=new Intent(ClerkPage.this,ViewCase.class);
                        startActivity(i);
                        Toast.makeText(ClerkPage.this,"add is selected",Toast.LENGTH_LONG).show();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerClient.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 1:
                        Intent i=new Intent(ClerkPage.this,AddClient.class);
                        startActivity(i);
                        Toast.makeText(ClerkPage.this,"add is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Intent i1=new Intent(ClerkPage.this,DeleteClient.class);
                        startActivity(i1);
                        Toast.makeText(ClerkPage.this,"delete is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Intent i2=new Intent(ClerkPage.this,UpdateClient.class);
                        startActivity(i2);
                        Toast.makeText(ClerkPage.this,"update is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Intent i3=new Intent(ClerkPage.this,FetchClient.class);
                        startActivity(i3);
                        Toast.makeText(ClerkPage.this,"fetch is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Intent i4=new Intent(ClerkPage.this,ViewClient.class);
                        startActivity(i4);
                        Toast.makeText(ClerkPage.this,"view is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Intent i5=new Intent(ClerkPage.this,CallClient.class);
                        startActivity(i5);
                        Toast.makeText(ClerkPage.this,"Calling...",Toast.LENGTH_LONG).show();
                        break;
                    case 7:
                        Intent i6=new Intent(ClerkPage.this,MessageClient.class);
                        startActivity(i6);
                        Toast.makeText(ClerkPage.this,"messaging...",Toast.LENGTH_LONG).show();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
