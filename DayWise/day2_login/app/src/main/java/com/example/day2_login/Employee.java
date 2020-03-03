package com.example.day2_login;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String contactNumber;

//    public Employee(int ic_launcher_background, String pranaw, String s) {
//    }
    public Employee(int id, String name,  String contactNumber) {
        this.id = id;
        this.name = name;
      //  this.salary = salary;
        this.contactNumber = contactNumber;
    }

    public Employee(int id, String name, double salary, String contactNumber) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }



//    public Employee(String name,String contactNumber) {
//     //   this.id = id;
//        this.name = name;
//
//        this.contactNumber = contactNumber;
//    }

    @Override
    public String toString() {
        return
                 id +
                " " + name +

                " " + contactNumber ;
    }
}
