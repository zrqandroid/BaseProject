package com.maowubian.baseproject.component.db;

/**
 * Created by zhuruqiao on 16/8/12.
 */
public class DbSqlManager {

    public static final class MusicInfo {
        public static final String TABLE_NAME = "music_info.db";

        public enum Column {
            ID("_id", 0),
            PATH("_data", 1),
            NAME("_display_name", 2),
            ARTIST("artist", 3),
            ALBUM("album", 4),
            SIZE("_size", 5),
            DATE_ADDED("date_added", 6),
            DURATION("duration", 7),
            IS_MUSIC("is_music", 8),
            IS_FAVOURITE("is_favourite", 9),
            IS_RECENT("is_recent", 10);

            private String name;
            private int index;

            Column(String name, int index) {
                this.name = name;
                this.index = index;
            }

        }

        public static String getCreateSQL(){

            StringBuilder sb = new StringBuilder();

            sb.append("CREATE TABLE IF NOT EXISTS ")
                    .append(TABLE_NAME).append("( ")
                    .append(Column.ID.name).append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                    .append(Column.PATH.name).append(" TEXT UNIQUE, ")//
                    .append(Column.NAME.name).append(" TEXT, ")
                    .append(Column.ARTIST.name).append(" TEXT, ")
                    .append(Column.ALBUM.name).append(" TEXT, ")
                    .append(Column.SIZE.name).append(" INTEGER, ")
                    .append(Column.DATE_ADDED.name).append(" TEXT, ")
                    .append(Column.DURATION.name).append(" INTEGER, ")
                    .append(Column.IS_MUSIC.name).append(" INTEGER, ")
                    .append(Column.IS_FAVOURITE.name).append(" INTEGER, ")
                    .append(Column.IS_RECENT.name).append(" INTEGER")
                    .append(");");
            return sb.toString();
        }


        public static String getDropSQL(){

            return "DROP TABLE IF EXISTS "+TABLE_NAME;
        }

    }


}
