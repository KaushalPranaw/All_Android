package com.example.pranaw.imagedb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by Pranaw on 13-07-2017.
 */

public class MyAdapter extends BaseAdapter
{
    private List<Department> mylist;
    private LayoutInflater lf=null;
    Context ctx=null;

    public MyAdapter(Activity activity, List<Department>mylist)
    {
        ctx=activity.getApplicationContext();
        this.mylist=mylist;
        lf=LayoutInflater.from(activity);
    }


    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Toast.makeText(ctx,"view created",Toast.LENGTH_LONG).show();
        if(convertView==null)
        {
            convertView=lf.inflate(R.layout.mycustom,parent,false);

        }
        TextView tv=(TextView) convertView.findViewById(R.id.tv);
        ImageView im=(ImageView) convertView.findViewById(R.id.img1);

        Department d=mylist.get(position);

        tv.setText(d.getName());

        byte[]arr=d.getHodpic();
        ByteArrayInputStream bis=new ByteArrayInputStream(arr);
        Bitmap bm= BitmapFactory.decodeStream(bis);
        im.setImageBitmap(bm);
     //   im.setImageResource(d.getId());

        return convertView;
    }
}
