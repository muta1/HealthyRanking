package com.example.anggarisky.pandalogin.tools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by mutao on 15/10/17.
 */

public class ToolsDroid {
    public static void msg(String msg, Context context){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
