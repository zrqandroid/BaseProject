package com.maowubian.baseproject.component.design.ui;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.base.BaseActivity;
import com.maowubian.baseproject.databinding.TestDataBinding;

/**
 * Created by zhuruqiao on 16/8/12.
 */
public class TestWindowActivity extends BaseActivity<TestDataBinding> {
    private WindowManager windowManager;
    @Override
    protected void init() {
         windowManager = getWindowManager();

        dataBinding.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView textView = new TextView(mContext);
                textView.setLayoutParams(new WindowManager.LayoutParams(100, 100));
                textView.setText("哈哈");
                textView.setTextColor(Color.RED);
                textView.setBackgroundColor(Color.TRANSPARENT);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0f, 1f, 0f);
                        scaleAnimation.setDuration(1000);
                        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                windowManager.removeViewImmediate(textView);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        textView.startAnimation(scaleAnimation);


                    }
                });


                windowManager.addView(textView, new WindowManager.LayoutParams());


            }
        });

    }

    @Override
    public int getLayout() {
        return R.layout.activity_window_test;

    }
}
