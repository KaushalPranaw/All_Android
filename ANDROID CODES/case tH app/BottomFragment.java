package com.example.pranaw.casetrackinghandlingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Pranaw on 15-07-2017.
 */

public class BottomFragment extends Fragment
{

     Button clerkshow;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.bottomfragment,container,false);

        clerkshow=(Button)v.findViewById(R.id.clerkshow);

        clerkshow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i= new Intent(getContext(),ClerkLogin.class);
                startActivity(i);
                Toast.makeText(getContext(),"Welcome to clerk login page",Toast.LENGTH_LONG).show();
            }
        }
        );

        return v;
    }
}
