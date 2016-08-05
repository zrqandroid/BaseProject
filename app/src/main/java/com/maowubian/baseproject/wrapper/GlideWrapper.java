package com.maowubian.baseproject.wrapper;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.maowubian.baseproject.factory.StoreConfigFactory;

import java.io.File;

/**
 * Created by zhuruqiao on 16/8/5.
 */
public class GlideWrapper {

    public static  void show(ImageView imageView){

        Glide.with(imageView.getContext()).load(new File(StoreConfigFactory.getStorePath(StoreConfigFactory.DIR_DOWNLOAD),"xuekaiqi.jpeg")).into(imageView);
    }
}
