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
 * Created by Pranaw on 22-07-2017.
 */

public class ClientAdapter extends BaseAdapter
{
    private List<ClientDetail> clientlist;
    private LayoutInflater lf=null;
    Context ctx=null;

    public ClientAdapter(Activity activity, List<ClientDetail>clientlist)
    {
        ctx=activity.getApplicationContext();
        this.clientlist=clientlist;
        lf=LayoutInflater.from(activity);
    }


    @Override
    public int getCount() {
        return clientlist.size();
    }

    @Override
    public Object getItem(int position) {
        return clientlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Toast.makeText(ctx,"client detailed created",Toast.LENGTH_LONG).show();
        if(convertView==null)
        {
            convertView=lf.inflate(R.layout.clientcustom,parent,false);

        }
        TextView tv1=(TextView) convertView.findViewById(R.id.txtclientname);
         TextView tv2=(TextView) convertView.findViewById(R.id.txtclientphone);


        ImageView im=(ImageView) convertView.findViewById(R.id.img);

        ClientDetail c=clientlist.get(position);

        tv1.setText(c.getClientname());

        tv2.setText(c.getClientphone());

        byte[]arr=c.getClientpic();
        ByteArrayInputStream bis=new ByteArrayInputStream(arr);
        Bitmap bm= BitmapFactory.decodeStream(bis);
        im.setImageBitmap(bm);
        //   im.setImageResource(d.getId());

        return convertView;
    }
}
