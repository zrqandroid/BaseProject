package com.maowubian.baseproject.component.music.media.data;

/**
 * Created by zhuruqiao on 16/8/8.
 */
public class MusicInfo  {

    public String id;
    public String path;
    public String name;
    public String artist;
    public String album;
    public String size;
    public String date_added;
    public int duration;

    public enum Column {
        ID("_id", 0),
        PATH("_data", 1),
        NAME("_display_name", 2),
        ARTIST("artist", 3),
        ALBUM("album", 4),
        SIZE("_size", 5),
        DATE_ADDED("date_added", 6),
        DURATION("duration", 7),
        IS_MUSIC("is_music", 8);

        private String column;
        private int id;

        Column(String column, int id) {
            this.column = column;
            this.id = id;
        }
    }

    public static String[] getProjection() {
        MusicInfo.Column[] values = MusicInfo.Column.values();
        String[] projection = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            projection[i] = values[i].column;
        }
        return projection;
    }


    @Override
    public String toString() {
        return "MusicInfo{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", size='" + size + '\'' +
                ", date_added='" + date_added + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    public  String getDurationTime(){
        return duration/60000+":"+duration%60000/1000;
    }
//
//    public String _id;
//    public String _data;// /storage/emulated/0/Download/music.mp3
//    public String _display_name;
//    public String _size;
//    public String mime_type;
//    public String date_added;
//    public String is_drm;
//    public String date_modified;
//    public String title;
//    public String title_key;
//    public String duration;
//    public String composer;
//    public String track;
//    public String year;
//    public String is_ringtone;
//    public String is_music;
//    public String is_alarm;
//    public String is_notification;
//    public String is_podcast;
//    public String bookmark;
//    public String album_artist;
//    public String artist_id;
//    public String artist_key;
//    public String artist;
//    public String album_id;
//    public String album_key;
//    public String album; 专辑


}
