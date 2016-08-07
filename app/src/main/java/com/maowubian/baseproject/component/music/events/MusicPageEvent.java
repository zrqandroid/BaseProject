package com.maowubian.baseproject.component.music.events;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.maowubian.baseproject.component.music.ui.MusicListActivity;

/**
 * Created by zhuruqiao on 2016/8/7.
 */
public final class MusicPageEvent {

    public static void toLocalList(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), MusicListActivity.class));
    }

    public static void toLocalDownlaodList(View view){


    }public static void toRecentPlayList(View view){


    }public static void toFavouriteList(View view){

    }
}
