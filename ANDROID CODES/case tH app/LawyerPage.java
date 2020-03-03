package com.example.pranaw.casetrackinghandlingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.pranaw.casetrackinghandlingapp.R.id.spinnerCase;


public class LawyerPage extends AppCompatActivity

{
    Spinner spinnerClerk,spinnerClient,spinnerCase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lawyer_page);

        spinnerClerk=(Spinner)findViewById(R.id.spinnerClerk);
        spinnerClient=(Spinner)findViewById(R.id.spinnerClient);
        spinnerCase=(Spinner)findViewById(R.id.spinnerCase);

        spinnerClerk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 1:
                        Intent i=new Intent(LawyerPage.this,AddClerk.class);
                        startActivity(i);
                        Toast.makeText(LawyerPage.this,"add is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Intent i1=new Intent(LawyerPage.this,DeleteClerk.class);
                        startActivity(i1);
                        Toast.makeText(LawyerPage.this,"deleted is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Intent i2=new Intent(LawyerPage.this,FetchClerk.class);
                        startActivity(i2);
                        Toast.makeText(LawyerPage.this,"fetch is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Intent i3=new Intent(LawyerPage.this,UpdateClerk.class);
                        startActivity(i3);
                        Toast.makeText(LawyerPage.this,"update is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Intent i4=new Intent(LawyerPage.this,ViewClerk.class);
                        startActivity(i4);
                        Toast.makeText(LawyerPage.this,"view is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Intent i5=new Intent(LawyerPage.this,CallClerk.class);
                        startActivity(i5);
                        Toast.makeText(LawyerPage.this,"Calling....",Toast.LENGTH_LONG).show();
                        break;
                    case 7:
                        Intent i6=new Intent(LawyerPage.this,MessgaeClerk.class);
                        startActivity(i6);
                        Toast.makeText(LawyerPage.this,"Please send message",Toast.LENGTH_LONG).show();
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
                        Intent i=new Intent(LawyerPage.this,AddClient.class);
                        startActivity(i);
                        Toast.makeText(LawyerPage.this,"add is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Intent i1=new Intent(LawyerPage.this,UpdateClient.class);
                        startActivity(i1);
                        Toast.makeText(LawyerPage.this,"update is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Intent i2=new Intent(LawyerPage.this,ViewClient.class);
                        startActivity(i2);
                        Toast.makeText(LawyerPage.this,"view is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Intent i5=new Intent(LawyerPage.this,CallClient.class);
                        startActivity(i5);
                        Toast.makeText(LawyerPage.this,"Calling....",Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Intent i6=new Intent(LawyerPage.this,MessageClient.class);
                        startActivity(i6);
                        Toast.makeText(LawyerPage.this,"Please send message",Toast.LENGTH_LONG).show();
                        break;

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerCase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        Intent i=new Intent(LawyerPage.this,AddCase.class);
                        startActivity(i);
                        Toast.makeText(LawyerPage.this,"add is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Intent i1=new Intent(LawyerPage.this,DeleteCase.class);
                        startActivity(i1);
                        Toast.makeText(LawyerPage.this,"delete is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Intent i2=new Intent(LawyerPage.this,UpdateCase.class);
                        startActivity(i2);
                        Toast.makeText(LawyerPage.this,"update is selected",Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Intent i5=new Intent(LawyerPage.this,FetchCase.class);
                        startActivity(i5);
                        Toast.makeText(LawyerPage.this,"fetch case ",Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Intent i6=new Intent(LawyerPage.this,ViewCase.class);
                        startActivity(i6);
                        Toast.makeText(LawyerPage.this," case is viewed",Toast.LENGTH_LONG).show();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

}