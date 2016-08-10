package com.maowubian.baseproject.component.music.media;


import android.view.View;
import android.widget.ProgressBar;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.music.media.data.MusicInfo;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by zhuruqiao on 16/8/5.
 */
public class PlayControler {

    private static PlayControler instance;

    private MediaConn conn;

    private MusicInfo info;


    private PlayControler(MediaConn conn) {
        this.conn = conn;
    }

    public void start(View view) {

        info = (MusicInfo) view.getTag();
        Logger.i("播放歌曲:%s", info.name);
        conn.control.play(info.path);

    }

    public static void init(MediaConn conn) {
        if (instance == null) {
            synchronized (PlayControler.class) {
                if (instance == null) {
                    instance = new PlayControler(conn);
                }
            }
        }

    }

    public static PlayControler getInstance() {
        if (instance == null) {
            Logger.e("PlayControler must be init");
        }
        return instance;
    }

    public MusicInfo getCurrentPlayMusic() {
        return info;
    }


}
