package com.example.alex.myapplication;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Alex on 10/30/2017.
 */

public class PVnRTTools {
    public static ArrayAdapter<String> AddUnknown(int arrayid, Context context) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(context.getResources().
                getStringArray(arrayid)));
        list.add("Unknown (unknown)");
        String[] array = list.toArray(new String[list.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (context, R.layout.spinner_item,
                        array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return adapter;
    }
    public static boolean checkFields(LinearLayout linearLayout) {
        boolean full = true;
        for (int x = 0; x < linearLayout.getChildCount(); x++) {
            View horiz = linearLayout.getChildAt(x);
            if (horiz instanceof LinearLayout) {
                full = PVnRTTools.checkFields(((LinearLayout) horiz));
                if (!full) {
                    return full;
                }
            }
            else if (horiz instanceof EditText){
                if (((EditText) horiz).getText().toString().trim().length() == 0 && horiz.isEnabled()) {
                    full = false;
                    return full;
                }

            }
        }
        return full;
    }
    public static double checkUnknown(EditText value) {
        try {
            double dbl = Double.parseDouble(value.getText().toString());
            return dbl;
        }
        catch (NumberFormatException e) {
            double unknowndbl = 0.0;
            return unknowndbl;
        }
    }
}
