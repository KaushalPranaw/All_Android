package com.example.pranaw.imagedb.com.dbutil;

/**
 * Created by Pranaw on 08-07-2017.
 */

public class StudentConstant
{
    public static final String DB_NAME="inst";
    public static final int DB_VERSION=1;
    public static final String PIC_TBL_NAME="studentpic";
    public static final String PIC_COL_ID="id";
    public static final String PIC_COL_NAME="name";
    public static final String PIC_COL_PIC="picname";

    public static final
    String PIC_TBL_QUERY="create table "+PIC_TBL_NAME+"("+PIC_COL_ID+"" +
            " integer primary key autoincrement,"+PIC_COL_NAME+" text,"+PIC_COL_PIC+" blob)";

}
