package com.example.pranaw.company;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pranaw.company.company.dbutil.CompanyConstant;
import com.example.pranaw.company.company.dbutil.CompanyManager;

public class MainActivity extends AppCompatActivity {

    CompanyManager cm;
    SQLiteDatabase sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cm=new CompanyManager(this);
        sb=cm.openDb();

    }

   public void insertData(View v)
    {
        String name="pranaw";
        int id=67;

        ContentValues cv=new ContentValues();

        cv.put(CompanyConstant.COL_ID,id);

        cv.put(CompanyConstant.COL_NAME,name);

        long rw=sb.insert(CompanyConstant.TBL_NAME,null,cv);

        if(rw>0)
        {
            Toast.makeText(this,"rowinserted"+rw,Toast.LENGTH_LONG).show();
        }
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(cm!=null)
        {
            cm.closeDb();
        }


    }
}
