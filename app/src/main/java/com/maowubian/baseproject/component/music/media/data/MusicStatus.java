package com.maowubian.baseproject.component.music.media.data;


import android.databinding.ObservableInt;
import android.databinding.tool.util.L;

import com.maowubian.baseproject.component.music.media.PlayerEvent;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Observable;

/**
 * Created by zhuruqiao on 16/8/10.
 */
public class MusicStatus extends Observable {

    private int duration = 0;

    public final ObservableInt progress = new ObservableInt(0);

    public final ObservableInt maxLength = new ObservableInt(0);

    public MusicStatus() {
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(PlayerEvent event) {
        if (duration == 0) {
            duration = event.getDuration();
            maxLength.set(duration);
        }
        progress.set(event.getCurrentPosition());

    }
}
