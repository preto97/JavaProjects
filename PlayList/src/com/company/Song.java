package com.company;

public class Song {

    private String title;
    private double duration;

    public Song(String title, Double durationSong) {
        this.title = title;
        this.duration = durationSong;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}
