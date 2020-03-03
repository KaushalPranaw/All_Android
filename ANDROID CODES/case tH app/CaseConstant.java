package com.example.pranaw.casetrackinghandlingapp.com.dbutil.Case;

/**
 * Created by Pranaw on 14-07-2017.
 */

public class CaseConstant
{
    public static final String DB_NAME="CaseTracking";
    public static final int DB_VERSION=1;

   public static final String TBL_NAME="clerk";


    public static final String CLERK_ID="clerkid";
    public static final String CLERK_PASS="clerkpass";
    public static final String CLERK_NAME="clerkname";
    public static final String CLERK_ADDRESS="clerkaddress";
    public static final String CLERK_PHONE="clerkphone";
    public static final String CLERK_GENDER="gender";
    public static final String CLERK_PIC="clerkpic";

    public static final String CASE_TBL_NAME="caseTable";

    public static final String CASE_ID="caseid";
    public static final String CCLIENT_ID="clientid";
    public static final String CASE_NAME="casename";
    public static final String CASE_JUGDEMENT="casejudgement";
    public static final String CASE_DECESION="casedecesion";


  public static final String CLIENT_TBL_NAME="client";

    public static final String CLIENT_ID="clientid";
    public static final String CLIENT_NAME="clientname";
    public static final String CLIENT_ADDRESS="clientaddress";
    public static final String CLIENT_PHONE="clientphone";
    public static final String CLIENT_GENDER="clientgender";
    public static final String CLIENT_PIC="clientpic";


   //  create Table clerk(clerkid text primary key,clerkpaas text,
    //                   clerkname text,clerkaddress text,clerkphone integer,gender text,clerkpic blob);

  public static final
    String TBL_QUERY="create table "+TBL_NAME+"("+CLERK_ID+" text primary key,"+CLERK_PASS+" text,"+CLERK_NAME+" text,"+CLERK_ADDRESS+" text,"+CLERK_PHONE+" text,"+CLERK_GENDER+" text,"+CLERK_PIC+" blob)";


    public static final
    String CASE_TBL_QUERY="create table "+CASE_TBL_NAME+"("+CASE_ID+" text primary key,"+CCLIENT_ID+" text,"+CASE_NAME+" text,"+CASE_JUGDEMENT+" text,"+CASE_DECESION+" text,foreign key("+CCLIENT_ID+") references "+CLIENT_TBL_NAME+"("+CLIENT_ID+"));";

    public static final
    String CLIENT_TBL_QUERY="create table "+CLIENT_TBL_NAME+"("+CLIENT_ID+" text primary key,"+CLIENT_NAME+" text,"+CLIENT_ADDRESS+" text,"+CLIENT_PHONE+" text,"+CLIENT_GENDER+" text,"+CLIENT_PIC+" blob)";

}
