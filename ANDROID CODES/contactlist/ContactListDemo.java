package com.example.pranaw.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactListDemo extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView lv;
    ArrayList<Contact> contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list_demo);
        lv = (ListView) findViewById(R.id.lv);
        contactList = new ArrayList<>();//<>() called diamond syntax is added in jdk1.8
        fillList();


        ArrayAdapter<Contact> ad = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1, contactList);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(this);
    }
    public void fillList() {
        Contact c=new Contact();
        c.setContact("8574235051");
        c.setName("Pranaw");
        contactList.add(c);

        Contact c1=new Contact();
        c1.setContact("9838265653");
        c1.setName("Pankaj");
        contactList.add(c1);

        Contact c2=new Contact();
        c2.setContact("8670182381");
        c2.setName("Mummy");
        contactList.add(c2);

        Contact c3=new Contact();
        c3.setContact("56323");
        c3.setName("abc");
        contactList.add(c3);

        Contact c4=new Contact();
        c4.setContact("8574235051");
        c4.setName("Pranaw");
        contactList.add(c4);

        Contact c5=new Contact();
        c5.setContact("8574235051");
        c5.setName("Pranaw");
        contactList.add(c5);

        Contact c6=new Contact();
        c6.setContact("8574235051");
        c6.setName("Pranaw");
        contactList.add(c6);

        Contact c7=new Contact();
        c7.setContact("8574235051");
        c7.setName("Pranaw");
        contactList.add(c7);

        Contact c8=new Contact();
        c8.setContact("8574235051");
        c8.setName("Pranaw");
        contactList.add(c8);

        Contact c9=new Contact();
        c9.setContact("8574235051");
        c9.setName("Pranaw");
        contactList.add(c9);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contact mv=contactList.get(position);

        String cname=mv.getName();
        String cno=mv.getContact();




    }
}
