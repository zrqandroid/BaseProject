package com.maowubian.baseproject.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by zhuruqiao on 16/8/5.
 */
public class RequestEventViewPager extends ViewPager {

    public RequestEventViewPager(Context context) {
        super(context);
    }

    public RequestEventViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }
}
