package com.maowubian.baseproject.component.music.media;

import android.view.View;

import com.maowubian.baseproject.component.music.media.data.MusicStatus;
import com.maowubian.baseproject.databinding.MusicItemBinding;

/**
 * Created by zhuruqiao on 16/8/11.
 */
public class PlayerControlerWrapper {

    private static PlayerControlerWrapper instance;

    public MusicItemBinding musicItemBinding;

    public PlayControler controler;

    public static PlayerControlerWrapper getInstance(MusicItemBinding musicDataBinding) {

        if (instance == null) {
            synchronized (PlayerControlerWrapper.class) {
                if (instance == null) {
                    instance = new PlayerControlerWrapper();

                }
            }

        }
        instance.musicItemBinding = musicDataBinding;
        instance.controler = PlayControler.getInstance();

        return instance;
    }

    public void start(View view) {
        musicItemBinding.setStatus(new MusicStatus());
        controler.start(musicItemBinding.getRoot());

    }


}
