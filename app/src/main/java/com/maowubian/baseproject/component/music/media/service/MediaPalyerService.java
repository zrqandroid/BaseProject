package com.maowubian.baseproject.component.music.media.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.maowubian.baseproject.component.music.media.PlayControlImpl;

public class MediaPalyerService extends Service {

    private MediaPlayer mediaPlayer;

    private PlayControlImpl playerControl;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        playerControl = new PlayControlImpl(mediaPlayer);

    }

    @Override
    public IBinder onBind(Intent intent) {

        return playerControl;
    }
}
