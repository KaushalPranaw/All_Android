package com.example.pranaw.imagedb;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.pranaw.imagedb.com.dbutil.StudentConstant;
import com.example.pranaw.imagedb.com.dbutil.StudentHelper;
import com.example.pranaw.imagedb.com.dbutil.StudentManager;

/**
 * Created by Pranaw on 14-07-2017.
 */

public class CustomProvider extends ContentProvider
{
    StudentManager sm;
   // StudentHelper sh;
    SQLiteDatabase sb;

    @Override
    public boolean onCreate()
    {

        sm=new StudentManager(getContext());
        sb=sm.openDb();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder)
    {
        Cursor c=sb.query(StudentConstant.PIC_TBL_NAME,null,null,null,null,null,null);

        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri)
    {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values)
    {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs)
    {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs)
    {
        return 0;
    }
}
