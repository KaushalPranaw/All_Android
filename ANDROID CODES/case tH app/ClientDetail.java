package com.example.pranaw.casetrackinghandlingapp;

/**
 * Created by Pranaw on 22-07-2017.
 */

public class ClientDetail
{


    public String getClientphone() {
        return clientphone;
    }

    public void setClientphone(String clientphone) {
        this.clientphone = clientphone;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public byte[] getClientpic() {
        return clientpic;
    }

    public void setClientpic(byte[] clientpic) {
        this.clientpic = clientpic;
    }

    private String clientphone;
    private String clientname;
    byte[] clientpic;


    @Override
    public String toString() {
        return  clientpic+"  "+clientname+"  "+clientphone;
    }


}
