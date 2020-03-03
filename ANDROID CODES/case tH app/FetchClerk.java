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

public class FetchClerk extends AppCompatActivity
{

    EditText txtclerkid,txtclerkname,txtclerkaddress,txtclerkpass,txtclerkphone,txtclerkgender;


    CaseManager cm;
    SQLiteDatabase sb;
    ImageView img;
    Bitmap bm;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_clerk);

        cm=new CaseManager(this);
       sb= cm.openDb();

        txtclerkid=(EditText) findViewById(R.id.txtclerkid);
        txtclerkname=(EditText) findViewById(R.id.txtclerkname);
        txtclerkaddress=(EditText) findViewById(R.id.txtclerkaddress);
        txtclerkpass=(EditText) findViewById(R.id.txtclerkpass);
        txtclerkphone=(EditText) findViewById(R.id.txtclerkphone);
        txtclerkgender=(EditText) findViewById(R.id.txtclerkgender);


        img=(ImageView)findViewById(R.id.img);


    }

    public void fetchClerk(View v)
    {
        String id = txtclerkid.getText().toString();
       /* String name=txtclerkname.getText().toString();
        String address=txtclerkaddress.getText().toString();
        String pass=txtclerkpass.getText().toString();
        String phone1=txtclerkphone.getText().toString();
        String gender=txtclerkgender.getText().toString();
*/



        String[]args={id};

        Cursor c= sb.query(CaseConstant.TBL_NAME,null,CaseConstant.CLERK_ID+"=?",args,null,null,null,null);
        String name1=null;
        byte[]img1=null;
        String address1=null;
        String pass1=null;
        String phone=null;
        String gender1=null;
        if(c!=null &&c.moveToFirst())
        {

           name1=c.getString(c.getColumnIndex(CaseConstant.CLERK_NAME));
            txtclerkname.setText(name1);
            address1=c.getString(c.getColumnIndex(CaseConstant.CLERK_ADDRESS));
            txtclerkaddress.setText(address1);
            pass1=c.getString(c.getColumnIndex(CaseConstant.CLERK_PASS));
            txtclerkpass.setText(pass1);
            gender1=c.getString(c.getColumnIndex(CaseConstant.CLERK_GENDER));
            txtclerkgender.setText(gender1);
            phone=c.getString(c.getColumnIndex(CaseConstant.CLERK_PHONE));
            txtclerkphone.setText(phone);



            //Toast.makeText(this,dname,Toast.LENGTH_LONG).show();
            img1=   c.getBlob(c.getColumnIndex(CaseConstant.CLERK_PIC));


        }

        ByteArrayInputStream ba=new ByteArrayInputStream(img1);
        Bitmap b= BitmapFactory.decodeStream(ba);
        img.setImageBitmap(b);

        //c.close();




    }
}
