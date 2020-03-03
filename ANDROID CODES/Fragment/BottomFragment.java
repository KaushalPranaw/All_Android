package com.example.pranaw.fragmentdemo;

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

    EditText txtname;
    Button btnshow;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.bottomfragment,container,false);
        txtname=(EditText)v.findViewById(R.id.txtname);
        btnshow=(Button)v.findViewById(R.id.btnshow);

        btnshow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name=txtname.getText().toString();
                Toast.makeText(getContext(),"hello "+name,Toast.LENGTH_LONG).show();
            }
        }
        );

        return v;
    }
}
