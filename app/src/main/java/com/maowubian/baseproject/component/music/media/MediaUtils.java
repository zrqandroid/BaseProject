package com.maowubian.baseproject.component.music.media;

import android.content.ContentResolver;
import android.database.Cursor;

import com.maowubian.baseproject.api.AppContext;
import com.maowubian.baseproject.component.music.media.data.MusicInfo;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import static android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

/**
 * Created by zhuruqiao on 16/8/8.
 */
public class MediaUtils {

    public static List<MusicInfo> getLocalMusicList() {
        ContentResolver contentResolver = AppContext.mContext.getContentResolver();

        Cursor cursor = contentResolver.query(EXTERNAL_CONTENT_URI, MusicInfo.getProjection(), MusicInfo.Column.IS_MUSIC.name() + "=?", new String[]{"1"}, null);
        ArrayList<MusicInfo> list = new ArrayList<>();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                MusicInfo musicInfo = new MusicInfo();
                musicInfo.id = cursor.getString(MusicInfo.Column.ID.ordinal());
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
}
