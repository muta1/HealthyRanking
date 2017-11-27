package com.example.anggarisky.pandalogin.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.example.anggarisky.pandalogin.R;

/**
 * Created by mutao on 26/11/17.
 */

public class SimpleMutaoImageAdapter extends ArrayAdapter {

        private Context context;
        private LayoutInflater inflater;

        private String[] imageUrls;

        public SimpleMutaoImageAdapter(Context context, String[] imageUrls) {
            super(context, R.layout.listview_item_image, imageUrls);

            this.context = context;
            this.imageUrls = imageUrls;

            inflater = LayoutInflater.from(context);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (null == convertView) {
                convertView = inflater.inflate(R.layout.listview_item_image, parent, false);
            }

            Glide
                    .with(context)
                    .load(imageUrls[position])
                    .into((ImageView) convertView);


            return convertView;
        }

}
