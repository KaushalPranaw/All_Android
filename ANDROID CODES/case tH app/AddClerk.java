package com.example.pranaw.casetrackinghandlingapp;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

import java.io.ByteArrayOutputStream;

public class AddClerk extends AppCompatActivity
{

    EditText txtclerkid,txtclerkname,txtclerkaddress,txtclerkpass,txtclerkphone,txtclerkgender;


    CaseManager cm;
    SQLiteDatabase sb;
    Bitmap bm;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clerk);



        txtclerkid=(EditText) findViewById(R.id.txtclerkid);
        txtclerkname=(EditText) findViewById(R.id.txtclerkname);
        txtclerkaddress=(EditText) findViewById(R.id.txtclerkaddress);
        txtclerkpass=(EditText) findViewById(R.id.txtclerkpass);
        txtclerkphone=(EditText) findViewById(R.id.txtclerkphone);
        txtclerkgender=(EditText) findViewById(R.id.txtclerkgender);

        img=(ImageView) findViewById(R.id.img);
         cm=new CaseManager(this);
        sb=cm.openDb();



    }
    public void clickPhoto(View v){

        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle b = data.getExtras();
        b.get("data");
        bm = (Bitmap) b.get("data");
        img.setImageBitmap(bm);
    }

    public void submit(View v) {
        String id = txtclerkid.getText().toString();
        String name=txtclerkname.getText().toString();
        String address=txtclerkaddress.getText().toString();
        String pass=txtclerkpass.getText().toString();
        String phone1=txtclerkphone.getText().toString();
        String gender=txtclerkgender.getText().toString();



      //  bm = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] imgarr = bos.toByteArray();


/*

cm.closeDb();
*/

        ContentValues cv = new ContentValues();
        cv.put(CaseConstant.CLERK_ID, id);
        cv.put(CaseConstant.CLERK_NAME, name);
        cv.put(CaseConstant.CLERK_ADDRESS, address);
        cv.put(CaseConstant.CLERK_GENDER, gender);
        cv.put(CaseConstant.CLERK_PASS, pass);
        cv.put(CaseConstant.CLERK_PHONE, phone1);
        cv.put(CaseConstant.CLERK_PIC, imgarr);


        long rw = sb.insert(CaseConstant.TBL_NAME, null, cv);

        if (rw > 0) {
          /*  String cno= (String) cv.get(phone1);
            String id1= (String) cv.get(id);
            String pass1= (String) cv.get(pass);*/
            SmsManager sm=SmsManager.getDefault();
            Intent obj=new Intent(this,AddClerk.class);
            PendingIntent pi=PendingIntent.getActivity(this,1,obj,PendingIntent.FLAG_ONE_SHOT);
            sm.sendTextMessage(phone1,null,"Welcome to Case Tracking Handing App.Your id is "+id+"And password is "+pass,pi,null);
            Toast.makeText(this,"Added", Toast.LENGTH_LONG).show();
            Toast.makeText(this,"message sent", Toast.LENGTH_LONG).show();
        }

    }
}
