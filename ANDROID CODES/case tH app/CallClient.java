package com.example.pranaw.casetrackinghandlingapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

import java.util.ArrayList;

public class CallClient extends AppCompatActivity {

    CaseManager cm;
    SQLiteDatabase sb;

    ClientDetail cd;

    ListView lv;
    ArrayList<ClientDetail> clientDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_client);

        lv=(ListView) findViewById(R.id.lv);

        cm=new CaseManager(this);
        sb= cm.openDb();



        clientDetailList=new ArrayList<ClientDetail>();
        fillList();
        ClientAdapter ad=new ClientAdapter(this,clientDetailList);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClientDetail mv=clientDetailList.get(position);

               // String cname=mv.getName();
                String cno=mv.getClientphone();

                Intent i = new Intent(Intent.ACTION_CALL);
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

                startActivity(i);
            }

        });



    }
    public void fillList()
    {
        Cursor c=sb.query(CaseConstant.CLIENT_TBL_NAME,null,null,null,null,null,null);

        if(c!=null &&c.moveToFirst())
        {
            do{

                //  int id=c.getInt(c.getColumnIndex(StudentConstant.PIC_COL_ID));
                String name2=c.getString(c.getColumnIndex(CaseConstant.CLIENT_NAME));

                String phone2=c.getString(c.getColumnIndex(CaseConstant.CLIENT_PHONE));



                byte[] pic=c.getBlob(c.getColumnIndex(CaseConstant.CLIENT_PIC));


                cd=new ClientDetail();
                //   d.setId(id);
                cd.setClientname(name2);
                cd.setClientpic(pic);

                cd.setClientphone(phone2);
                clientDetailList.add(cd);
            }while(c.moveToNext());


            cm.closeDb();


        }
    }


}
