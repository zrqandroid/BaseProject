package com.maowubian.baseproject.component.home.ui;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.audiofx.Visualizer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.game.ui.GameFragment;
import com.maowubian.baseproject.component.home.adapter.HomeVpAdapter;
import com.maowubian.baseproject.component.home.events.NavigationPageHandler;
import com.maowubian.baseproject.component.movie.ui.MovieFragment;
import com.maowubian.baseproject.component.music.media.MediaConn;
import com.maowubian.baseproject.component.music.media.PlayControler;
import com.maowubian.baseproject.component.music.media.PlayerEvent;
import com.maowubian.baseproject.component.music.media.service.MediaPalyerService;
import com.maowubian.baseproject.component.music.ui.MusicFragment;
import com.maowubian.baseproject.databinding.HomeDatabinding;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuruqiao on 16/8/3.
 */
public class HomePageActivity extends AppCompatActivity {

    private HomeDatabinding databinding;

    private List<Fragment> fragments = new ArrayList<>();

    private Context mContext;
    private MediaConn conn;
    private NavigationPageHandler processer;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fullScreenWithTitleBar();
        mContext = this;
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_home_page);
        conn = new MediaConn();
        bindService(new Intent(mContext, MediaPalyerService.class), conn, Service.BIND_AUTO_CREATE);
        PlayControler.init(conn);
        init();
    }

    private void init() {


        MusicFragment musicFragment = new MusicFragment();
        MovieFragment movieFragment = new MovieFragment();
        GameFragment gameFragment = new GameFragment();

        fragments.add(musicFragment);
        fragments.add(movieFragment);
        fragments.add(gameFragment);

        databinding.vp.setAdapter(new HomeVpAdapter(getSupportFragmentManager(), fragments));


    }

    private void fullScreenWithTitleBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
