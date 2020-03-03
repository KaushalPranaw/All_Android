package com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Pranaw on 14-07-2017.
 */

public class CaseHelper extends SQLiteOpenHelper
{
    Context context;

    public CaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       db.execSQL(CaseConstant.TBL_QUERY);
        Toast.makeText(context,"table clerk created",Toast.LENGTH_LONG).show();



       db.execSQL(CaseConstant.CASE_TBL_QUERY);
        Toast.makeText(context,"Table case created",Toast.LENGTH_LONG).show();



        db.execSQL(CaseConstant.CLIENT_TBL_QUERY);
        Toast.makeText(context,"table client created",Toast.LENGTH_LONG).show();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
