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

public class AddClient extends AppCompatActivity {

    EditText txtclientid,txtclientname,txtclientaddress, txtclientphone,txtclientgender;


    CaseManager cm;
    SQLiteDatabase sb;
    Bitmap bm;
    ImageView clientimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        txtclientid=(EditText) findViewById(R.id.txtclientid);
        txtclientname=(EditText) findViewById(R.id.txtclientname);
        txtclientaddress=(EditText) findViewById(R.id.txtclientaddress);
         txtclientphone=(EditText) findViewById(R.id.txtclientphone);
        txtclientgender=(EditText) findViewById(R.id.txtclientgender);

        clientimg=(ImageView) findViewById(R.id.clientimg);
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
        clientimg.setImageBitmap(bm);
    }

    public void add(View v) {
        String id = txtclientid.getText().toString();
        String name=txtclientname.getText().toString();
        String address=txtclientaddress.getText().toString();

        String phone1=txtclientphone.getText().toString();
        String gender=txtclientgender.getText().toString();



        //  bm = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] imgarr = bos.toByteArray();


/*

cm.closeDb();
*/

        ContentValues cv = new ContentValues();
        cv.put(CaseConstant.CLIENT_ID, id);
        cv.put(CaseConstant.CLIENT_NAME, name);
        cv.put(CaseConstant.CLIENT_ADDRESS, address);
        cv.put(CaseConstant.CLIENT_GENDER, gender);
         cv.put(CaseConstant.CLIENT_PHONE, phone1);
        cv.put(CaseConstant.CLIENT_PIC, imgarr);


        long rw = sb.insert(CaseConstant.CLIENT_TBL_NAME, null, cv);

        if (rw > 0) { SmsManager sm=SmsManager.getDefault();
            Intent obj=new Intent(this,AddClient.class);
            PendingIntent pi=PendingIntent.getActivity(this,1,obj,PendingIntent.FLAG_ONE_SHOT);
            sm.sendTextMessage(phone1,null,"Hello Mr. "+name+"Your id is "+id+" And  record is successfully inserted.Your case is taken by us.",pi,null);
            Toast.makeText(this,"Added", Toast.LENGTH_LONG).show();
            Toast.makeText(this,"message sent", Toast.LENGTH_LONG).show();
        }
    }
}
