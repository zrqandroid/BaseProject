package com.maowubian.baseproject.component.glide.ui;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.maowubian.baseproject.R;
import com.maowubian.baseproject.databinding.GlideBinding;


/**
 * Created by zhuruqiao on 16/8/1.
 */
public class GlideAtivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PATH="http://p0.so.qhimg.com/t010095cc3100644a10.jpg";

    private GlideBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = DataBindingUtil.setContentView(this, R.layout.activity_glide);
        binding.bt.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        ViewTarget<ImageView, GlideDrawable> imageViewDrawableViewTarget = new ViewTarget<ImageView, GlideDrawable>(binding.iv1) {


            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                this.view.setImageDrawable(resource);

            }

            @Override
            public void onLoadStarted(Drawable placeholder) {
                this.view.setImageResource(R.mipmap.ic_launcher);
            }
        };
        Glide.with(this).load(PATH).into(imageViewDrawableViewTarget);

    }
}
