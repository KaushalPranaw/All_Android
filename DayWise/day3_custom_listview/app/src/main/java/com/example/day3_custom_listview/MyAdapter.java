package com.example.day3_custom_listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pojos.Employee;

import java.util.List;

public class MyAdapter extends BaseAdapter
{
    private List<Employee> myList;
    private LayoutInflater lf=null;
    Context context=null;

    public MyAdapter(Activity activity,List<Employee> myList)
    {
        context=activity.getApplicationContext();
        this.myList=myList;
        lf=LayoutInflater.from(activity);
    }


    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parentView) {
        Toast.makeText(context,"view Created",Toast.LENGTH_LONG).show();
        if(convertView==null)
        {
            convertView=lf.inflate(R.layout.custom_list,parentView,false);

        }

        TextView tv=convertView.findViewById(R.id.tv);
        ImageView img=convertView.findViewById(R.id.img);
        TextView phoneno=convertView.findViewById(R.id.phoneno);

        Employee employee=myList.get(position);
        tv.setText(employee.getName());
        img.setImageResource(employee.getId());
        phoneno.setText(employee.getPhoneno());

        return convertView;
    }
}
