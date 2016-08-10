package com.maowubian.baseproject.component.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.maowubian.baseproject.R;

/**
 * Created by zhuruqiao on 16/8/8.
 */
public  abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    public Activity mContext;
    public T dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        dataBinding= DataBindingUtil.setContentView(mContext, getLayout());
        init();
    }

    protected abstract void init();

    public abstract int getLayout();
}
