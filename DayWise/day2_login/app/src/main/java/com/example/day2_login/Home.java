package com.example.day2_login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements  AdapterView.OnItemClickListener {

    ListView textLv;
    ArrayList<Employee> empList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textLv=findViewById(R.id.textList);
        empList=new ArrayList<>();

        getEmpList();
       /* ArrayAdapter<Employee> ad=new ArrayAdapter<Employee>(this,R.layout.support_simple_spinner_dropdown_item,empList);
        textLv.setAdapter(ad);
        textLv.setOnItemClickListener((AdapterView.OnItemClickListener) this);*/
        ArrayAdapter<Employee> ad = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, empList);
        textLv.setAdapter(ad);
        textLv.setOnItemClickListener((AdapterView.OnItemClickListener) this);
    }

    public void getEmpList()
    {
        empList.add(new Employee(1,"Rahul",10000,"7905186093"));
        empList.add(new Employee(2,"Pranaw",10000,"8574235051"));
        empList.add(new Employee(3,"shubham",10000,"9589440973"));
        empList.add(new Employee(4,"Rejo",10000,"9961144955"));
        empList.add(new Employee(5,"pranawkaushal",10000,"8787029692"));

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       /* Contact mv=contactList.get(position);

        String cname=mv.getName();
        String cno=mv.getContact();
*/
        Employee e=empList.get(position);
        int id1=e.getId();
        String name=e.getName();
        double sal=e.getSalary();
        String contact=e.getContactNumber();
        Intent i = new Intent(Intent.ACTION_CALL);
        Uri u = Uri.parse("tel:" + contact);
        Toast.makeText(this,contact,Toast.LENGTH_SHORT).show();
        i.setData(u);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(i);

    }


}
