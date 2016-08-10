package com.maowubian.baseproject.component.home.events;

import android.databinding.DataBindingUtil;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.music.data.PlayerStatus;
import com.maowubian.baseproject.component.music.media.MediaConn;
import com.maowubian.baseproject.component.music.media.PlayControler;
import com.maowubian.baseproject.databinding.HeaderBinding;
import com.maowubian.baseproject.factory.StoreConfigFactory;


import java.io.File;

/**
 * Created by zhuruqiao on 16/8/3.
 */
public class HomeEvents {


    public static void onNavigationCLick(NavigationView nv, MediaConn conn) {

        doMenuItemClick(nv.getMenu());

        View headerView = nv.getHeaderView(0);
        HeaderBinding bind = DataBindingUtil.bind(headerView);
        PlayerStatus playerStatus = new PlayerStatus();
        ImageView bg = (ImageView) headerView.findViewById(R.id.bg);


        Glide.with(bg.getContext()).load(new File(StoreConfigFactory.getStorePath(StoreConfigFactory.DIR_DOWNLOAD), "xuekaiqi.jpeg")).into(bg);


    }

    private static void doMenuItemClick(Menu menu) {
        for (int i = 0; i < menu.size(); i++) {

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

    private static void doMusic() {

    }

    private static void doMovie() {

    }

    private static void doGame() {

    }

    private static void doAbout() {

    }


    private static void doAdvice() {

    }
}
