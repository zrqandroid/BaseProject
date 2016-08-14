package com.maowubian.baseproject.component.music.media;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.audiofx.Equalizer;
import android.media.audiofx.Visualizer;
import android.os.Binder;
import android.util.Log;

import com.maowubian.baseproject.component.music.media.inter.PlayControl;
import com.maowubian.baseproject.factory.StoreConfigFactory;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by zhuruqiao on 16/8/5.
 */
public class PlayControlImpl extends Binder implements PlayControl, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private Equalizer mEqualizer;

    private Timer timer;

    private MediaPlayer mediaPlayer;

    private boolean isPause = false;

    private EventBus eventBus;

    private PlayerEvent playerEvent;

    public Visualizer mVisualizer;

    private static PlayControlImpl instance;

    public static final int COMPLETE = 2;


    public static PlayControlImpl getInstance() {
        return instance;
    }

    public PlayControlImpl(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        eventBus = EventBus.getDefault();

    }

    public static void init(MediaPlayer mediaPlayer) {
        instance = new PlayControlImpl(mediaPlayer);
    }

    @Override
    public void play(String path) {
        timer = new Timer(true);
        if (isPause) {
            mediaPlayer.start();
            startSchedule();
        } else {
            mediaPlayer.reset();
            try {
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepareAsync();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void startSchedule() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                playerEvent.setCurrentPosition(mediaPlayer.getCurrentPosition());
                eventBus.post(playerEvent);
            }
        }, 0, 50);
    }

    @Override
    public void stop() {
        mediaPlayer.stop();
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
        isPause = true;
        timer.cancel();

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        int duration = mediaPlayer.getDuration();
        playerEvent = new PlayerEvent(duration, 0);
        eventBus.post(playerEvent);
        mediaPlayer.start();
        initVIsualizer();
        startSchedule();
    }

    private void initVIsualizer() {
        if (mVisualizer == null) {
            int sessionId = mediaPlayer.getAudioSessionId();
            mVisualizer = new Visualizer(sessionId);
            mVisualizer.setCaptureSize(Visualizer.getCaptureSizeRange()[1]);
            mEqualizer = new Equalizer(0, sessionId);
            mEqualizer.setEnabled(true);
            eventBus.post(1);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        eventBus.post(COMPLETE);

    }
}
