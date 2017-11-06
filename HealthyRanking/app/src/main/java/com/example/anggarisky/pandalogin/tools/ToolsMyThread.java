package com.example.anggarisky.pandalogin.tools;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by mutao on 05/11/17.
 */

public class ToolsMyThread extends Thread {

    //    private Bitmap bitmap;
//    private ImageView imageView;
    private Bitmap bit;
    private String path;
    private Bitmap bitmap;
    private ImageView imageView;
    private Handler handler = new Handler();

//    public ToolsMyThread(ImageView imageView,String path) {
//        this.path = path;
//        this.bitmap = bitmap;
//        this.imageView = imageView;
//    }

    public ToolsMyThread(String path,ImageView imageview) {
        this.path = path;
        this.imageView = imageview;
    }

    public Bitmap getBit(){
        return this.bit;
    }

    @Override
    public void run() {

        try {
            Bitmap bitmap = ToolsBitmap.getBitmapFromURL(this.path);
            this.bit = ToolsBitmap.getResizedBitmap(bitmap, 1154, 1734);
        } catch (Exception e) {
            Log.i("Exception -> ", "oooo :  " + e.getMessage());
        }



        if(this.imageView != null && this.bit!=null){
            handler.post(new MyRunnable(this.imageView,this.bitmap));
        }
    }
        class MyRunnable implements Runnable {
        private ImageView iv;
        private Bitmap bt;

        public MyRunnable(ImageView iv,Bitmap bt) {
            this.iv = iv;
            this.bt = bt;
        }

        @Override
        public void run() {

            if(iv !=null){
                iv.setImageBitmap(bt);
            }else{
                Log.i("Exception ", "Classe que deu problema: " + this.getClass().getSimpleName());
            }
        }
    }


}
