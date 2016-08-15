package com.maowubian.baseproject.component.music.media;

import android.content.ContentResolver;
import android.database.Cursor;
import android.widget.Switch;

import com.maowubian.baseproject.api.AppContext;
import com.maowubian.baseproject.component.music.media.data.MusicInfo;
import com.maowubian.commonutils.SpUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

/**
 * Created by zhuruqiao on 16/8/8.
 */
public class MediaUtils {

    public static final String LOOP_TYPE = "loop_type";

    public static final String CURRENT_PLAY_LIST = "current_play_list";
    public static final int LOCAL_LIST = 0;
    public static final int RECENT_PLAY = 1;
    public static final int FAVOURITE = 2;

    private static final int LOOP_LOOP = 0;

    private static final int LOOP_ORDER = 1;

    private static final int LOOP_ONE = 2;

    private static final int LOOP_SHUFFLE = 3;

    public static List<MusicInfo> getLocalMusicList() {
        ContentResolver contentResolver = AppContext.mContext.getContentResolver();

        Cursor cursor = contentResolver.query(EXTERNAL_CONTENT_URI, MusicInfo.getProjection(), MusicInfo.Column.IS_MUSIC.name() + "=?", new String[]{"1"}, null);
        ArrayList<MusicInfo> list = new ArrayList<>();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                MusicInfo musicInfo = new MusicInfo();
                musicInfo.id = cursor.getInt(MusicInfo.Column.ID.ordinal());
                musicInfo.album = cursor.getString(MusicInfo.Column.ALBUM.ordinal());
                musicInfo.name = cursor.getString(MusicInfo.Column.NAME.ordinal());
                musicInfo.artist = cursor.getString(MusicInfo.Column.ARTIST.ordinal());
                musicInfo.date_added = cursor.getString(MusicInfo.Column.DATE_ADDED.ordinal());
                musicInfo.duration = cursor.getInt(MusicInfo.Column.DURATION.ordinal());
                musicInfo.size = cursor.getString(MusicInfo.Column.SIZE.ordinal());
                musicInfo.path = cursor.getString(MusicInfo.Column.PATH.ordinal());
                list.add(musicInfo);
            }
            cursor.close();
        }
        return list;

    }

    public static String getLocalMusicCount() {

        return "(" + getLocalMusicList().size() + ")";
    }

    public static String getRecentMusicCount() {

        return "(" + getLocalMusicList().size() + ")";
    }

    public static String getFavouriteMusicCount() {

        return "(" + getLocalMusicList().size() + ")";
    }

    public static String getDownloadMusicCount() {

        return "(" + getLocalMusicList().size() + ")";
    }

    public static MusicInfo getMusicByLoopType(String path) {

        MusicInfo info = null;
        int current = 0;
        //获取当前播放列表
        List<MusicInfo> currentPlayList = getCurrentPlayList();
        for (int i = 0; i < currentPlayList.size(); i++) {
            if (currentPlayList.get(i).path.equals(path)) {
                info = currentPlayList.get(i);
                current = i;
                break;
            }
        }

        int type = SpUtils.getInt(AppContext.mContext, LOOP_TYPE);

        switch (type) {
            case LOOP_ONE:
                return info;
            case LOOP_LOOP:
                if (current == currentPlayList.size() - 1) {
                    return currentPlayList.get(0);
                } else {
                    return currentPlayList.get(current + 1);
                }
            case LOOP_ORDER:
                if (current == currentPlayList.size() - 1) {
                    return null;
                } else {
                    return currentPlayList.get(current + 1);
                }
            case LOOP_SHUFFLE:
                Random random = new Random();
                while (true) {
                    int i = random.nextInt(currentPlayList.size());
                    if (current != i) {
                        return currentPlayList.get(i);
                    }
                }

        }

        return null;
    }

    public static List<MusicInfo> getCurrentPlayList() {
        int anInt = SpUtils.getInt(AppContext.mContext, CURRENT_PLAY_LIST);
        switch (anInt) {
            case LOCAL_LIST:
                break;
            case RECENT_PLAY:
                break;
            case FAVOURITE:
                break;
        }

        return getLocalMusicList();
    }
}
