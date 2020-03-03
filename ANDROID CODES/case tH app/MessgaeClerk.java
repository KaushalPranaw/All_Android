package com.example.pranaw.casetrackinghandlingapp;

import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

import java.util.ArrayList;

public class MessgaeClerk extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    CaseManager cm;
    SQLiteDatabase sb;

    ClerkDetail cd;
    ListView lv;
    ArrayList<ClerkDetail> clerkDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_clerk);

        lv=(ListView) findViewById(R.id.lv);

        cm=new CaseManager(this);
        sb= cm.openDb();



        clerkDetailList=new ArrayList<ClerkDetail>();
        fillList();
        ClerkAdapter ad=new ClerkAdapter(this,clerkDetailList);

        lv.setOnItemClickListener(this);
        lv.setAdapter(ad);


/*
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                ClerkDetail mv = clerkDetailList.get(position);
              final  String cno=mv.getPhone();

              *//*  String cname = mv.getName();
                ArrayList<String> list=new ArrayList<String>();
                getIntent().putExtra("cno",list);
                Intent i=new Intent(getApplicationContext(),Message.class);
                startActivity(i);*//*

               AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
//                  view.getLayoutInflater().inflate(R.layout.message, null);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        ClerkDetail mv = clerkDetailList.get(position);
                        String cno=mv.getPhone();
                        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        view.getLayoutInflater().inflate(R.layout.message, null);
                        EditText msg1 = (EditText) findViewById(R.id.msg1);
                        Button send = (Button) findViewById(R.id.send);


                    }
                });
                final EditText msg1 = (EditText) view.findViewById(R.id.msg1);
                final Button send = (Button) view.findViewById(R.id.send);


                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //   ClerkDetail mv=clerkDetailList.get(position);

                        // String cname=mv.getName();
                        Intent obj = new Intent(getApplicationContext(), MessgaeClerk.class);
                        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 2, obj, PendingIntent.FLAG_ONE_SHOT);
                        SmsManager sm = SmsManager.getDefault();
                        // String cno="8574235051";

                        sm.sendTextMessage(cno, null, String.valueOf(msg1), pi, null);
                        Toast.makeText(getApplicationContext(), "message sent", Toast.LENGTH_LONG).show();
            }
                });
                builder.setView(v);
                AlertDialog dialog = builder.create();
                dialog.show();

                    *//*String msg="hello friend this is the message ";
                    SmsManager sm=SmsManager.getDefault();
                    Intent obj=new Intent(getApplicationContext(),MessgaeClerk.class);
                    PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),2,obj,PendingIntent.FLAG_ONE_SHOT);
                    sm.sendTextMessage(cno,null,msg,pi,null);
                    Toast.makeText(getApplicationContext(),"message sent",Toast.LENGTH_LONG).show();*//*
            }
        });*/
    }
    public void fillList()
    {
        Cursor c=sb.query(CaseConstant.TBL_NAME,null,null,null,null,null,null);

        if(c!=null &&c.moveToFirst())
        {
            do{

                //  int id=c.getInt(c.getColumnIndex(StudentConstant.PIC_COL_ID));
                String name2=c.getString(c.getColumnIndex(CaseConstant.CLERK_NAME));

                String phone3=c.getString(c.getColumnIndex(CaseConstant.CLERK_PHONE));
            /*    String gender2=c.getString(c.getColumnIndex(CaseConstant.CLERK_GENDER));
                String address2=c.getString(c.getColumnIndex(CaseConstant.CLERK_ADDRESS));
*/

                byte[] pic=c.getBlob(c.getColumnIndex(CaseConstant.CLERK_PIC));


                cd=new ClerkDetail();
                //   d.setId(id);
                cd.setName(name2);
                cd.setClerkpic(pic);
              /*  cd.setAddress(address2);
                cd.setGender(gender2);*/
                cd.setPhone(phone3);
                clerkDetailList.add(cd);
            }while(c.moveToNext());
            cm.closeDb();
        }
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        cd=clerkDetailList.get(position);
        String phone2=cd.getPhone();
        String msg="hello friend this is the message ";
        SmsManager sm=SmsManager.getDefault();
        Intent obj=new Intent(this,MessgaeClerk.class);
        PendingIntent pi=PendingIntent.getActivity(this,1,obj,PendingIntent.FLAG_ONE_SHOT);
        sm.sendTextMessage(phone2,null,msg,pi,null);
        Toast.makeText(this,"message sent",Toast.LENGTH_LONG).show();
    }
}
