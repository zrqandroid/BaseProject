package com.maowubian.baseproject.component.music.adapter;

import android.content.Context;
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

    public BannerAdapter(Context mContext){
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
        GlideWrapper.show(viewById);
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
