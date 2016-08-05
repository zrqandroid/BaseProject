package com.maowubian.baseproject.component.home.events;


import android.view.View;
import android.widget.ImageButton;

import com.google.common.eventbus.EventBus;
import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.music.data.PlayerStatus;
import com.maowubian.baseproject.component.music.media.MediaConn;
import com.orhanobut.logger.Logger;

/**
 * Created by zhuruqiao on 16/8/5.
 */
public class PlayControlEvent {
    private final PlayerStatus playerStatus;
    private MediaConn conn;
    private boolean flag=true;



    public PlayControlEvent(MediaConn conn, PlayerStatus playerStatus) {
        this.conn=conn;
        this.playerStatus=playerStatus;
    }

    public  void start(View view){
        ImageButton button = (ImageButton) view;
        if (flag){
            conn.control.play("");
            button.setImageResource(R.drawable.pause);
            flag=false;
            Logger.i("play");
        }else {
            conn.control.pause();
            button.setImageResource(R.drawable.play);
            flag=true;
            Logger.i("pause");
        }


    }
}
