package com.maowubian.baseproject.component.home.events;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.design.ui.TestWindowActivity;
import com.maowubian.baseproject.databinding.HeaderBinding;
import com.orhanobut.logger.Logger;

/**
 * Created by zhuruqiao on 16/8/12.
 */
public class SideBarEvent {

    private static int loop = 0;
    private static final int LOOP_LOOP = 0;
    private static final int LOOP_ORDER = 1;
    private static final int LOOP_ONE = 2;
    private static final int LOOP_SHUFFLE = 3;
    private Context mContext;

    private static SideBarEvent sideBarEvent;

    public SideBarEvent(NavigationView sideBar) {

        View headerView = sideBar.getHeaderView(0);
        mContext=headerView.getContext();
        doMenuItemClick(sideBar.getMenu());
        HeaderBinding bind = DataBindingUtil.bind(headerView);

    }

    public static void init(NavigationView sideBar) {

        sideBarEvent = new SideBarEvent(sideBar);

    }

    private void doMenuItemClick(Menu menu) {
        for (int i = 0; i < menu.size(); i++) {

            Logger.i("哈哈");
            MenuItem item = menu.getItem(i);
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.music:
                            doMusic();
                            break;
                        case R.id.movie:
                            doMovie();
                            break;
                        case R.id.game:
                            doGame();
                            break;
                        case R.id.study:
                            doAbout();
                            break;
                        case R.id.about:
                            doAdvice();
                            break;

                    }

                    return true;
                }
            });

        }

    }

    private void doMusic() {
        mContext.startActivity(new Intent(mContext, TestWindowActivity.class));

    }

    private void doMovie() {

    }

    private void doGame() {

    }

    private void doAbout() {

    }

    private void doAdvice() {

    }

    public static void loop(View view) {
        ImageButton bt = (ImageButton) view;
        loop++;
        switch (loop % 4) {
            case LOOP_LOOP:
                bt.setImageResource(R.drawable.loop_loop);
                break;
            case LOOP_ORDER:
                bt.setImageResource(R.drawable.loop_order);
                break;
            case LOOP_ONE:
                bt.setImageResource(R.drawable.loop_one);
                break;
            case LOOP_SHUFFLE:
                bt.setImageResource(R.drawable.loop_shuffle);
                break;

        }


    }

    public static void pre(View view) {


    }

    public static void next(View view) {


    }

    public static void playOrPause(View view) {


    }

    public static void favourite(View view) {


    }
}
