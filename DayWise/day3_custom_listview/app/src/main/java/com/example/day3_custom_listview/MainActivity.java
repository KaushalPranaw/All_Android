package com.example.day3_custom_listview;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pojos.Employee;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    ListView listView;
    ArrayList<Employee> employees;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        employees=new ArrayList<>();
        employees.add(new Employee(R.drawable.ic_launcher_background,"abc","8574235051"));
        employees.add(new Employee(R.drawable.ic_launcher_background,"abcd","8574235051"));
        employees.add(new Employee(R.drawable.ic_launcher_background,"abcde","8574235051"));

        MyAdapter myAdapter=new MyAdapter(this,employees);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                Employee employee = employees.get(position);

                String cname = employee.getName();

                String cno = employee.getPhoneno();
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


}
