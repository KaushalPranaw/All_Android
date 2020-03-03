package com.example.pranaw.fragmentdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Pranaw on 15-07-2017.
 */

public class CustomDialog extends DialogFragment
{
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder ad=new AlertDialog.Builder(getContext());

        ad.setTitle("fragment dialog");
        ad.setMessage("android fragments");
        ad.setPositiveButton("ok",null);
        ad.setNegativeButton("cancel",null);
        ad.setIcon(R.drawable.background);
        AlertDialog adl=ad.create();
        return adl;
    }
}

