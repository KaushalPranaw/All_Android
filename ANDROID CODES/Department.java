package com.example.pranaw.imagedb;

/**
 * Created by Pranaw on 13-07-2017.
 */

public class Department
{
    private int id;
    private  String name;
    byte[] hodpic;

    public int getId()
    {return id;}

    public void setId(int id)
    {this.id = id;}

    public String getName()
    {return name;}

    public void setName(String name)
    {this.name = name;}

    public byte[] getHodpic()
    {return hodpic;}

    public void setHodpic(byte[] hodpic)
    {this.hodpic = hodpic;}

    @Override
    public String toString() {
        return  name+"        "+hodpic;
    }
}
