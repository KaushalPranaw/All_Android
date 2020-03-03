package com.example.pranaw.calling_msg;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class Messaging extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);
    }


    public void sendmsg(View v){

        String phone="8574235051";
        String msg="hello friend this is the message ";

        SmsManager sm=SmsManager.getDefault();

        Intent obj=new Intent(this,Messaging.class);

        PendingIntent pi=PendingIntent.getActivity(this,2,obj,PendingIntent.FLAG_ONE_SHOT);

        sm.sendTextMessage(phone,null,msg,pi,null);
        
        Toast.makeText(this,"message sent",Toast.LENGTH_LONG).show();


    }
}
