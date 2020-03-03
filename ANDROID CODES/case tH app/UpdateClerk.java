package com.example.pranaw.casetrackinghandlingapp;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
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

public class UpdateClerk extends AppCompatActivity {

    EditText txtclerkid,txtclerkname,txtclerkaddress,txtclerkpass,txtclerkphone,txtclerkgender;


    CaseManager cm;
    SQLiteDatabase sb;
    Bitmap bm;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_clerk);

        cm=new CaseManager(this);
        sb= cm.openDb();

        txtclerkid=(EditText) findViewById(R.id.txtclerkid);
        txtclerkname=(EditText) findViewById(R.id.txtclerkname);
        txtclerkaddress=(EditText) findViewById(R.id.txtclerkaddress);
        txtclerkpass=(EditText) findViewById(R.id.txtclerkpass);
        txtclerkphone=(EditText) findViewById(R.id.txtclerkphone);
        txtclerkgender=(EditText) findViewById(R.id.txtclerkgender);

        img=(ImageView) findViewById(R.id.img);
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

    public void updateClerk(View v)
    {

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


        String[] args={id};

        ContentValues cv=new ContentValues();
        cv.put(CaseConstant.CLERK_ID, id);
        cv.put(CaseConstant.CLERK_NAME, name);
        cv.put(CaseConstant.CLERK_ADDRESS, address);
        cv.put(CaseConstant.CLERK_GENDER, gender);
        cv.put(CaseConstant.CLERK_PASS, pass);
        cv.put(CaseConstant.CLERK_PHONE, phone1);
        cv.put(CaseConstant.CLERK_PIC, imgarr);


        long l=sb.update(CaseConstant.TBL_NAME,cv,CaseConstant.CLERK_ID+" =?",args);


        if(l>0)
        {
            SmsManager sm=SmsManager.getDefault();
            Intent obj=new Intent(this,UpdateClerk.class);
            PendingIntent pi=PendingIntent.getActivity(this,1,obj,PendingIntent.FLAG_ONE_SHOT);
            sm.sendTextMessage(phone1,null,"Your id is "+id+"And password is "+pass+"successfully updated",pi,null);
            Toast.makeText(this,"updated", Toast.LENGTH_LONG).show();
            Toast.makeText(this,"message sent", Toast.LENGTH_LONG).show();

        }
    }

}
