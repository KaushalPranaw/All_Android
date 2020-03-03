package com.example.pranaw.casetrackinghandlingapp;

import android.location.Address;

/**
 * Created by Pranaw on 20-07-2017.
 */

public class ClerkDetail
{
    private String id;
    private String phone;
    private String address;
    private String name;
    private String gender;
    byte[] clerkpic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte[] getClerkpic() {
        return clerkpic;
    }

    public void setClerkpic(byte[] clerkpic) {
        this.clerkpic = clerkpic;
    }
    @Override
    public String toString() {
        return  clerkpic+""+name+""+phone;
    }


}
