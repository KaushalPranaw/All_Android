package com.example.pranaw.casetrackinghandlingapp;

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
 * Created by Pranaw on 20-07-2017.
 */

public class ClerkAdapter extends BaseAdapter {

    private List<ClerkDetail> clerklist;
    private LayoutInflater lf=null;
    Context ctx=null;

    public ClerkAdapter(Activity activity, List<ClerkDetail>clerklist)
    {
        ctx=activity.getApplicationContext();
        this.clerklist=clerklist;
        lf=LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return clerklist.size();
    }

    @Override
    public Object getItem(int position) {
        return clerklist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Toast.makeText(ctx,"clerk detailed created",Toast.LENGTH_LONG).show();
        if(convertView==null)
        {
            convertView=lf.inflate(R.layout.clerkcustom,parent,false);

        }
        TextView tv1=(TextView) convertView.findViewById(R.id.txtclerkname);


        TextView tv4=(TextView) convertView.findViewById(R.id.txtclerkphone);


        ImageView im=(ImageView) convertView.findViewById(R.id.img);

        ClerkDetail c=clerklist.get(position);
        tv1.setText(c.getName());
      /*  tv2.setText(c.getAddress());
        tv3.setText(c.getGender());*/
        tv4.setText(c.getPhone());

        byte[]arr=c.getClerkpic();
        ByteArrayInputStream bis=new ByteArrayInputStream(arr);
        Bitmap bm= BitmapFactory.decodeStream(bis);
        im.setImageBitmap(bm);
        //   im.setImageResource(d.getId());

        return convertView;
    }


}
