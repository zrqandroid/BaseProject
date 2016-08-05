package com.maowubian.baseproject.component.music.media;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.maowubian.baseproject.component.music.media.inter.PlayControl;

/**
 * Created by zhuruqiao on 16/8/5.
 */
public class MediaConn implements ServiceConnection {

    public PlayControl control;

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        control= (PlayControl) service;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
