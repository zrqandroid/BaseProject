package com.maowubian.baseproject.component.music.media;

/**
 * Created by zhuruqiao on 16/8/5.
 */
public class PlayerEvent {

    private int duration;

    private int currentPosition;

    public PlayerEvent(int duration, int currentPosition) {
        this.duration = duration;
        this.currentPosition = currentPosition;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
