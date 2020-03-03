package com.example.pranaw.casetrackinghandlingapp;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

import java.util.ArrayList;

public class ViewClerk extends AppCompatActivity
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
        lv.setAdapter(ad);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final ClerkDetail mv=clerkDetailList.get(position);

                String cname=mv.getName();

                final String cno=mv.getPhone();
               // CharSequence ChooseOption[]=new CharSequence[]{"Call","Message"};
               // String cno=mv.getPhone();
                final SmsManager sm=SmsManager.getDefault();

                Intent obj=new Intent(getApplicationContext(),ViewClerk.class);
                final PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),2,obj,PendingIntent.FLAG_ONE_SHOT);

                AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
                View v=getLayoutInflater().inflate(R.layout.message,null);
                final EditText msg1=(EditText)v.findViewById(R.id.msg1);
                Button send=(Button)v.findViewById(R.id.send);
                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       //   ClerkDetail mv=clerkDetailList.get(position);

                       // String cname=mv.getName();

                        sm.sendTextMessage(cno,null, String.valueOf(msg1),pi,null);
                        Toast.makeText(getApplicationContext(),"message sent",Toast.LENGTH_LONG).show();


                    }
                });
                builder.setView(v);
                AlertDialog dialog=builder.create();
                dialog.show();





                  /*  String msg="hello friend this is the message ";

                    SmsManager sm=SmsManager.getDefault();

                    Intent obj=new Intent(getApplicationContext(),ViewClerk.class);

                    PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),2,obj,PendingIntent.FLAG_ONE_SHOT);

                    sm.sendTextMessage(cno,null,msg,pi,null);
                    Toast.makeText(getApplicationContext(),"message sent",Toast.LENGTH_LONG).show();


*/

        /*        Intent i = new Intent(Intent.ACTION_CALL);
                Uri u = Uri.parse("tel:" + cno);
                i.setData(u);
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }

                startActivity(i);*/
            }

    });




    }

    public void fillList()
    {
        Cursor c=sb.query(CaseConstant.TBL_NAME,null,null,null,null,null,null);

        if(c!=null &&c.moveToFirst())
        {
            do{

                //  int id=c.getInt(c.getColumnIndex(StudentConstant.PIC_COL_ID));
                String name2=c.getString(c.getColumnIndex(CaseConstant.CLERK_NAME));

                String phone2=c.getString(c.getColumnIndex(CaseConstant.CLERK_PHONE));
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
                cd.setPhone(phone2);
                clerkDetailList.add(cd);
            }while(c.moveToNext());
            cm.closeDb();
        }
    }

}
