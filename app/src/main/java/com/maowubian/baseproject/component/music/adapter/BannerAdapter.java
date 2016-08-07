package com.maowubian.baseproject.component.music.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.wrapper.GlideWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuruqiao on 16/8/4.
 */
public class BannerAdapter extends PagerAdapter {

    private List<View> views;
    private Context mContext;

    public BannerAdapter(Context mContext){
        this.mContext=mContext;
        views=new ArrayList<>();
        for (int i =0;i<6;i++){
            View inflate = View.inflate(mContext, R.layout.banner, null);
            views.add(inflate);
        }

    }


    @Override
    public View instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        ImageView viewById = (ImageView) view.findViewById(R.id.banner);
        container.addView(view);
        if (position%2==0){
            viewById.setBackgroundColor(Color.GREEN);
        }else {
            viewById.setBackgroundColor(Color.BLUE);
        }
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));


    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

}
