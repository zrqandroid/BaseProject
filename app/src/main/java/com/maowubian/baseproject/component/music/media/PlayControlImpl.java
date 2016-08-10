package com.maowubian.baseproject.component.music.media;

import android.media.MediaPlayer;
import android.os.Binder;

import com.maowubian.baseproject.component.music.media.inter.PlayControl;
import com.maowubian.baseproject.factory.StoreConfigFactory;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by zhuruqiao on 16/8/5.
 */
public class PlayControlImpl extends Binder implements PlayControl, MediaPlayer.OnPreparedListener {

    private  Timer timer;
    private MediaPlayer mediaPlayer;
    private boolean isPause=false;
    private EventBus eventBus;
    private PlayerEvent playerEvent;

    public PlayControlImpl(MediaPlayer mediaPlayer) {
        this.mediaPlayer=mediaPlayer;
        mediaPlayer.setOnPreparedListener(this);
         eventBus = EventBus.getDefault();



    }

    @Override
    public void play(String path) {
          timer = new Timer(true);
        if (isPause){
            mediaPlayer.start();
            startSchedule();
        }else {
            mediaPlayer.reset();
            try {
                mediaPlayer.setDataSource(path);
                mediaPlayer.prepare();
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
        },0,50);
    }

    @Override
    public void stop() {
        mediaPlayer.stop();
    }

    @Override
    public void pause() {
        mediaPlayer.pause();
        isPause=true;
        timer.cancel();

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        int duration = mediaPlayer.getDuration();
        playerEvent = new PlayerEvent(duration,0);
        eventBus.post(playerEvent);
        mediaPlayer.start();
        startSchedule();
    }
}
