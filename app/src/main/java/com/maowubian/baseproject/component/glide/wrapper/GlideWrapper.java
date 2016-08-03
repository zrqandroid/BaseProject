package com.maowubian.baseproject.component.glide.wrapper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by zhuruqiao on 16/8/1.
 */
public class GlideWrapper {

    public static void show(String url, ImageView view){
        Context context = view.getContext();
        Glide.with(context).load(url).into(view);
    }
    public static void show(int resourceId, ImageView view){
        Context context = view.getContext();
        Glide.with(context).load(resourceId).into(view);
    }
    public static void show(File file, ImageView view){
        Context context = view.getContext();
        Glide.with(context).load(file).into(view);
    }

}
