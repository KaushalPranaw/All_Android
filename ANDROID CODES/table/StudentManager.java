package com.example.pranaw.imagedb.com.dbutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Pranaw on 08-07-2017.
 */

public class StudentManager
{
    Context context;
    SQLiteDatabase sb;
    StudentHelper sh;

    public StudentManager(Context context)
    {
        this.context=context;
        sh=new StudentHelper(context,StudentConstant.DB_NAME,null,StudentConstant.DB_VERSION);
    }

    public SQLiteDatabase openDb()
    {
        sb=sh.getWritableDatabase();
        return  sb;
    }

    public void closeDb()
    {
        sh.close();
    }

}
