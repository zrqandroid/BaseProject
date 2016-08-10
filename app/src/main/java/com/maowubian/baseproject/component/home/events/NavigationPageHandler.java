package com.maowubian.baseproject.component.home.events;

import android.support.design.widget.NavigationView;

import com.maowubian.baseproject.component.music.media.MediaConn;
import com.maowubian.baseproject.component.music.media.PlayerEvent;
import com.maowubian.baseproject.databinding.HeaderBinding;

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
