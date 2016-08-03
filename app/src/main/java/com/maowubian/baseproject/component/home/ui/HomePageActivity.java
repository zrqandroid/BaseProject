package com.maowubian.baseproject.component.home.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.home.adapter.HomeVpAdapter;
import com.maowubian.baseproject.databinding.HomeDatabinding;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuruqiao on 16/8/3.
 */
public class HomePageActivity extends AppCompatActivity {

    private HomeDatabinding databinding;
    private List<Fragment> fragments = new ArrayList<>();
    private Context mContext;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        mContext = this;

        databinding = DataBindingUtil.setContentView(this, R.layout.activity_home_page);
        databinding.space.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,getStatusbarHeight()));


        AppFragment appFragment1 = new AppFragment();
        AppFragment appFragment2 = new AppFragment();
        AppFragment appFragment3 = new AppFragment();

        fragments.add(appFragment1);
        fragments.add(appFragment2);
        fragments.add(appFragment3);
        databinding.vp.setAdapter(new HomeVpAdapter(getSupportFragmentManager(), fragments));

        Menu menu = databinding.nv.getMenu();

        menu.getItem(0).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Snackbar bar = Snackbar.make(databinding.nv, "哈哈哈", Snackbar.LENGTH_SHORT);
                bar.show();
                View view = bar.getView();
                view.setBackgroundColor(0x55f44336);
                view.setAnimation(new AlphaAnimation(0, 1));

                return true;
            }
        });


    }

    private int getStatusbarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object o = c.newInstance();
            Field field = c.getField("status_bar_height");
            int i = Integer.parseInt(field.get(o).toString());
            return getResources().getDimensionPixelOffset(i);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
