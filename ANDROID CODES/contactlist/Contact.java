package com.example.pranaw.contactlist;

/**
 * Created by Pranaw on 26-06-2017.
 */

public class Contact {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    String name;
    String contact;
    public String toString()
    {
        return name+""+contact;

    }
}

