package com.maowubian.baseproject.component.music.events;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.component.music.ui.MusicListActivity;

/**
 * Created by zhuruqiao on 2016/8/7.
 */
public final class MusicPageEvent {


    public static void toLocalList(View view) {

        startActivity(view, R.string.local_list);

    }

    public static void toLocalDownlaodList(View view) {

        startActivity(view, R.string.local_download);

    }

    public static void toRecentPlayList(View view) {

        startActivity(view, R.string.recent_play);
    }

    public static void toFavouriteList(View view) {

        startActivity(view, R.string.favourite);

    }

    public static void back(View view) {


    }

    private static void startActivity(View view, int titleId) {

        Context context = view.getContext();
        MusicListActivity.start(context, context.getString(titleId));
    }
}
