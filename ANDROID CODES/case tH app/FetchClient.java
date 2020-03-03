package com.example.pranaw.casetrackinghandlingapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

import java.io.ByteArrayInputStream;

public class FetchClient extends AppCompatActivity
{

    EditText txtclientid,txtclientname,txtclientaddress, txtclientphone,txtclientgender;


    CaseManager cm;
    SQLiteDatabase sb;
    Bitmap bm;
    ImageView clientimg;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_client);
        txtclientid=(EditText) findViewById(R.id.txtclientid);
        txtclientname=(EditText) findViewById(R.id.txtclientname);
        txtclientaddress=(EditText) findViewById(R.id.txtclientaddress);
        txtclientphone=(EditText) findViewById(R.id.txtclientphone);
        txtclientgender=(EditText) findViewById(R.id.txtclientgender);

        clientimg=(ImageView) findViewById(R.id.clientimg);
        cm=new CaseManager(this);
        sb=cm.openDb();

    }

    public void fetchClient(View v)
    {
        String id = txtclientid.getText().toString();



        String[]args={id};

        Cursor c= sb.query(CaseConstant.CLIENT_TBL_NAME,null,CaseConstant.CLIENT_ID+"=?",args,null,null,null,null);
        String name1=null;
        byte[]img1=null;
        String address1=null;
        String phone=null;
        String gender1=null;
        if(c!=null &&c.moveToFirst())
        {

            name1=c.getString(c.getColumnIndex(CaseConstant.CLIENT_NAME));
            txtclientname.setText(name1);
            address1=c.getString(c.getColumnIndex(CaseConstant.CLIENT_ADDRESS));
            txtclientaddress.setText(address1);
             gender1=c.getString(c.getColumnIndex(CaseConstant.CLIENT_GENDER));
            txtclientgender.setText(gender1);
            phone=c.getString(c.getColumnIndex(CaseConstant.CLIENT_PHONE));
            txtclientphone.setText(phone);



            //Toast.makeText(this,dname,Toast.LENGTH_LONG).show();
            img1=   c.getBlob(c.getColumnIndex(CaseConstant.CLIENT_PIC));


        }

        ByteArrayInputStream ba=new ByteArrayInputStream(img1);
        Bitmap b= BitmapFactory.decodeStream(ba);
        clientimg.setImageBitmap(b);

        //c.close();




    }
}
