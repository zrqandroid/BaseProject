package com.maowubian.baseproject.component.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.maowubian.baseproject.api.AppContext;

/**
 * Created by zhuruqiao on 16/8/12.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "app.db";

    private static final int VERSION = 1;

    private static SQLiteOpenHelper instance;

    public static SQLiteOpenHelper getInstance() {
        if (instance == null) {
            synchronized (DbHelper.class) {
                if (instance == null) {
                    instance = new DbHelper(AppContext.mContext, DB_NAME, null, VERSION);
                }
            }
        }
        return instance;

    }

    private DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
