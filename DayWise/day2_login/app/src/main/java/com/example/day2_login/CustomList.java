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

public class CustomList extends AppCompatActivity /*implements  AdapterView.OnItemClickListener*/ {


    ListView textLv;
    ArrayList<Employee> empList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        textLv=(ListView) findViewById(R.id.list);
        empList=new ArrayList<>();

        empList.add(new Employee(R.drawable.ic_launcher_background,"Rahul","7905186093"));
        empList.add(new Employee(R.drawable.ic_launcher_background,"Pranaw","8574235051"));
        empList.add(new Employee(R.drawable.ic_launcher_background,"shubham","9589440973"));
        empList.add(new Employee(R.drawable.ic_launcher_background,"Rejo","9961144955"));
        empList.add(new Employee(R.drawable.ic_launcher_background,"pranawkaushal","8787029692"));

        MyAdapter ad=new MyAdapter(this,empList);

        textLv.setAdapter(ad);
        textLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                Employee employee = empList.get(position);

                String cname = employee.getName();

                String cno = employee.getContactNumber();
                Intent i = new Intent(Intent.ACTION_CALL);
                Uri u = Uri.parse("tel:" + cno);
                i.setData(u);
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        });




    }

    public void getEmpList(ArrayList<Employee> empList)
    {


    }


}
