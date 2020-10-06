package com.company;

// I created the Song class with fields title and duration
public class Song {

    private String title;
    private double duration;

    // This is the Song constructor
    public Song(String title, Double durationSong) {
        this.title = title;
        this.duration = durationSong;
    }

    public String getTitle() {
        return title;
    }

    // Override the toString method to display this message
    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}
