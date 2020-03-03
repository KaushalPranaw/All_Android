package com.example.pranaw.casetrackinghandlingapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Pranaw on 22-07-2017.
 */

public class CaseAdapter extends BaseAdapter
{
    private List<CaseDetail> caselist;
    private LayoutInflater lf=null;
    Context ctx=null;

    public CaseAdapter(Activity activity, List<CaseDetail>caselist)
    {
        ctx=activity.getApplicationContext();
        this.caselist=caselist;
        lf=LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return caselist.size();
    }

    @Override
    public Object getItem(int position) {
        return caselist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Toast.makeText(ctx,"case detailed created",Toast.LENGTH_LONG).show();
        if(convertView==null)
        {
            convertView=lf.inflate(R.layout.casecustom,parent,false);

        }
        TextView tv1=(TextView) convertView.findViewById(R.id.txtcasename);
        TextView tv2=(TextView) convertView.findViewById(R.id.txtclientid);
        TextView tv3=(TextView) convertView.findViewById(R.id.txtjudgement);
        TextView tv4=(TextView) convertView.findViewById(R.id.txtdecision);



        CaseDetail c=caselist.get(position);
        tv1.setText(c.getCasename());
        tv2.setText(c.getClientid());
        tv3.setText(c.getJudgement());
        tv4.setText(c.getDecision());


        return convertView;
    }

}
