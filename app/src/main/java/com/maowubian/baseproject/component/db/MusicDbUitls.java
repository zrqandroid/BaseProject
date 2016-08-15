package com.maowubian.baseproject.component.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.maowubian.baseproject.component.music.media.data.MusicInfo;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by zhuruqiao on 16/8/12.
 */
public class MusicDbUitls {
    public static void addFavouriteMusic(MusicInfo info) {

        SQLiteDatabase db = DbHelper.getInstance().getWritableDatabase();
        ContentValues  values = new ContentValues();
        values.put(DbSqlManager.MusicInfo.Column.ID.name(), info.id);
        values.put(DbSqlManager.MusicInfo.Column.PATH.name(), info.path);
        values.put(DbSqlManager.MusicInfo.Column.NAME.name(), info.name);
        values.put(DbSqlManager.MusicInfo.Column.ARTIST.name(), info.artist);
        values.put(DbSqlManager.MusicInfo.Column.ALBUM.name(), info.album);
        values.put(DbSqlManager.MusicInfo.Column.SIZE.name(), info.size);
        values.put(DbSqlManager.MusicInfo.Column.DATE_ADDED.name(), info.date_added);
        values.put(DbSqlManager.MusicInfo.Column.DURATION.name(), info.duration);
        values.put(DbSqlManager.MusicInfo.Column.IS_MUSIC.name(), 1);
        values.put(DbSqlManager.MusicInfo.Column.IS_FAVOURITE.name(), 1);
        values.put(DbSqlManager.MusicInfo.Column.IS_RECENT.name(), 0);
        db.insert(DbSqlManager.MusicInfo.TABLE_NAME, null, values);
        db.close();


    }

    public static void delFavouriteMusic(MusicInfo info) {
        SQLiteDatabase db = DbHelper.getInstance().getWritableDatabase();
        ContentValues  values = new ContentValues();
        values.put(DbSqlManager.MusicInfo.Column.ID.name(), info.id);
        values.put(DbSqlManager.MusicInfo.Column.PATH.name(), info.path);
        values.put(DbSqlManager.MusicInfo.Column.NAME.name(), info.name);
        values.put(DbSqlManager.MusicInfo.Column.ARTIST.name(), info.artist);
        values.put(DbSqlManager.MusicInfo.Column.ALBUM.name(), info.album);
        values.put(DbSqlManager.MusicInfo.Column.SIZE.name(), info.size);
        values.put(DbSqlManager.MusicInfo.Column.DATE_ADDED.name(), info.date_added);
        values.put(DbSqlManager.MusicInfo.Column.DURATION.name(), info.duration);
        values.put(DbSqlManager.MusicInfo.Column.IS_MUSIC.name(), 1);
        values.put(DbSqlManager.MusicInfo.Column.IS_FAVOURITE.name(), 1);
        values.put(DbSqlManager.MusicInfo.Column.IS_RECENT.name(), 0);
        db.insert(DbSqlManager.MusicInfo.TABLE_NAME, null, values);
        db.close();

    }

    public static List<MusicInfo> getFavouriteMusics() {

        return null;
    }

    public static void addRecentPlayMusic(MusicInfo info) {

    }


    public static List<MusicInfo> getRecentPlayMusics() {

        return null;
    }

}
