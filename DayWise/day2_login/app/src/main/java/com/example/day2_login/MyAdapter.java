package com.example.day2_login;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<Employee> employeeList;
    private LayoutInflater lf=null;
    Context context=null;

    public MyAdapter(Activity activity,List<Employee> list)
    {
        context=activity.getApplicationContext();
        this.employeeList=list;
        lf=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Toast.makeText(context,"view created",Toast.LENGTH_SHORT).show();

        if(convertView==null) {
            convertView = lf.inflate(R.layout.cust, parent,false);
        }
        TextView name=(TextView) convertView.findViewById(R.id.textName);
        TextView contact=(TextView) convertView.findViewById(R.id.textContact);
        ImageView im=(ImageView) convertView.findViewById(R.id.img);

        Employee e=employeeList.get(position);

        name.setText(e.getName());
        contact.setText(e.getContactNumber());
       // contact.setId(R.drawable.ic_launcher_background);
        im.setImageResource(e.getId());


                            /* byte[]arr=   f.getHodPic();
                            ByteArrayInputStream bs=new ByteArrayInputStream(arr);

                            Bitmap bm=BitmapFactory.decodeStream(bs);
                            im.setImageBitmap(bm);*/
     //   im.setImageResource(e.getId());


        return convertView;

    }
}
