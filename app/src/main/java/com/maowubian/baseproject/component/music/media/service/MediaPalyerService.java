package com.maowubian.baseproject.component.music.media.service;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.audiofx.Visualizer;
import android.os.IBinder;

import com.maowubian.baseproject.component.music.media.PlayControlImpl;
import com.maowubian.baseproject.component.music.media.inter.PlayControl;

public class MediaPalyerService extends Service {

    private MediaPlayer mediaPlayer;


    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        PlayControlImpl.init(mediaPlayer);

    }

    @Override
    public IBinder onBind(Intent intent) {

        return PlayControlImpl.getInstance();
    }
}
