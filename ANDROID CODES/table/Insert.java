package com.example.pranaw.imagedb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pranaw.imagedb.com.dbutil.StudentConstant;
import com.example.pranaw.imagedb.com.dbutil.StudentManager;

import java.io.ByteArrayOutputStream;

public class Insert extends AppCompatActivity
{
    StudentManager sm;
    SQLiteDatabase sb;

    ImageView img;
    Bitmap bm;
    EditText edtdep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        sm=new StudentManager(this);
        sb=sm.openDb();

        img=(ImageView) findViewById(R.id.img);

        edtdep=(EditText)findViewById(R.id.edtdep);
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
    public void insertPic(View v){

        // bm= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG,100,bos);
        byte[]imgarr= bos.toByteArray();

        ContentValues cv=new ContentValues();
        String name=edtdep.getText().toString();

        cv.put(StudentConstant.PIC_COL_NAME,name);
        cv.put(StudentConstant.PIC_COL_PIC,imgarr);

        long l=sb.insert(StudentConstant.PIC_TBL_NAME,null,cv);
        if(l>0)
            Toast.makeText(this,String.valueOf(l),Toast.LENGTH_LONG).show();


    }

}
