package com.maowubian.baseproject.component.home.events;

import android.databinding.DataBindingUtil;
import android.support.design.widget.NavigationView;
import android.view.View;

import com.maowubian.baseproject.component.music.data.PlayerStatus;
import com.maowubian.baseproject.component.music.media.MediaConn;
import com.maowubian.baseproject.component.music.media.PlayerEvent;
import com.maowubian.baseproject.databinding.HeaderBinding;
import com.maowubian.baseproject.wrapper.GlideWrapper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by zhuruqiao on 16/8/5.
 */
public class NavigationPageHandler {
    private HeaderBinding bind;
    private int duration;


    public NavigationPageHandler(NavigationView nv, MediaConn conn) {
        EventBus.getDefault().register(this);
        View headerView = nv.getHeaderView(0);
        bind = DataBindingUtil.bind(headerView);
        PlayerStatus playerStatus = new PlayerStatus();
        PlayControlEvent playControlEvent = new PlayControlEvent(conn, playerStatus);
        bind.setPlayControl(playControlEvent);
        GlideWrapper.show(bind.bg);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(PlayerEvent event) {
        if (duration==0){
            duration=event.getDuration();
            bind.musicProgress.setMax(duration);
        }
        bind.musicProgress.setProgress(event.getCurrentPosition());

    }


    public void unRegister() {
        EventBus.getDefault().unregister(this);

    }
}
