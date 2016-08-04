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
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.game.ui.GameFragment;
import com.maowubian.baseproject.component.home.adapter.HomeVpAdapter;
import com.maowubian.baseproject.component.home.events.HomeEvents;
import com.maowubian.baseproject.component.movie.ui.MovieFragment;
import com.maowubian.baseproject.component.music.ui.MusicFragment;
import com.maowubian.baseproject.databinding.HomeDatabinding;

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
        fullScreenWithTitleBar();
        mContext = this;
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_home_page);
        HomeEvents.onNavigationCLick(databinding.nv);
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


}
