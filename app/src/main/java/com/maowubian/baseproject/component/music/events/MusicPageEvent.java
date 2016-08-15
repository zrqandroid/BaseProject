package com.maowubian.baseproject.component.music.events;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.maowubian.baseproject.R;
import com.maowubian.baseproject.api.AppContext;
import com.maowubian.baseproject.component.music.media.MediaUtils;
import com.maowubian.baseproject.component.music.ui.MusicListActivity;
import com.maowubian.commonutils.SpUtils;

/**
 * Created by zhuruqiao on 2016/8/7.
 */
public final class MusicPageEvent {


    public static void toLocalList(View view) {

        startActivity(view, R.string.local_list);
        SpUtils.saveData(AppContext.mContext, MediaUtils.CURRENT_PLAY_LIST, MediaUtils.LOCAL_LIST);

    }

    public static void toLocalDownlaodList(View view) {

        startActivity(view, R.string.local_download);
        SpUtils.saveData(AppContext.mContext, MediaUtils.CURRENT_PLAY_LIST, MediaUtils.LOCAL_LIST);
    }

    public static void toRecentPlayList(View view) {

        startActivity(view, R.string.recent_play);
        SpUtils.saveData(AppContext.mContext, MediaUtils.CURRENT_PLAY_LIST, MediaUtils.LOCAL_LIST);
    }

    public static void toFavouriteList(View view) {

        startActivity(view, R.string.favourite);
        SpUtils.saveData(AppContext.mContext, MediaUtils.CURRENT_PLAY_LIST, MediaUtils.LOCAL_LIST);

    }

    public static void back(View view) {


    }

    private static void startActivity(View view, int titleId) {

        Context context = view.getContext();
        MusicListActivity.start(context, context.getString(titleId));
    }
}
