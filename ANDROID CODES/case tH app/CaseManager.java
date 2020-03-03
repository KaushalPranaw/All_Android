package com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Pranaw on 14-07-2017.
 */

public class CaseManager
{

    Context context;
    CaseHelper ch;
    SQLiteDatabase sb;

    public CaseManager(Context context)
    {
        this.context=context;
        ch=new CaseHelper(context,CaseConstant.DB_NAME,null,CaseConstant.DB_VERSION);
    }

    public SQLiteDatabase openDb()
    {
        sb=ch.getWritableDatabase();
        return sb;

    }

    public  void closeDb()

    {

        ch.close();
    }

}
