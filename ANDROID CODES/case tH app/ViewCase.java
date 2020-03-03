package com.example.pranaw.casetrackinghandlingapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseConstant;
import com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case.CaseManager;

import java.util.ArrayList;

public class ViewCase extends AppCompatActivity {
    CaseManager cm;
    SQLiteDatabase sb;

    CaseDetail cd;

    ListView lv;
    ArrayList<CaseDetail> caseDetailList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_case);


        lv=(ListView) findViewById(R.id.lv);

        cm=new CaseManager(this);
        sb= cm.openDb();



        caseDetailList=new ArrayList<CaseDetail>();
        fillList();
        CaseAdapter ad=new CaseAdapter(this,caseDetailList);
        lv.setAdapter(ad);




    }
    public void fillList()
    {
        Cursor c=sb.query(CaseConstant.CASE_TBL_NAME,null,null,null,null,null,null);

        if(c!=null &&c.moveToFirst())
        {
            do{


                String name2=c.getString(c.getColumnIndex(CaseConstant.CASE_NAME));
                String id=c.getString(c.getColumnIndex(CaseConstant.CCLIENT_ID));
                String judgement=c.getString(c.getColumnIndex(CaseConstant.CASE_JUGDEMENT));
                String decision=c.getString(c.getColumnIndex(CaseConstant.CASE_DECESION));


                    cd=new CaseDetail();

                cd.setCasename(name2);

                cd.setClientid(id);
                cd.setJudgement(judgement);
                cd.setDecision(decision);
                caseDetailList.add(cd);
            }while(c.moveToNext());


            cm.closeDb();


        }
    }



}
