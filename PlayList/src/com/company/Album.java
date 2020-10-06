package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

// I created Album class whith fields name, artist and songs
public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    // This is the Album constructor
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    // This function allows us to add a song if it is not allready inserted in our ArrayList songs
    public boolean addSong(String title, double duration) {
        // Checking by title if the song is not allready in songs, using function findSong
        if (findSong(title) == null) {
            // If not, add the new song
            this.songs.add(new Song(title, duration));
            return true;
        }
        // Else print this informative message
        System.out.println("Song allready in album");
        return false;
    }

    // This function goes through songs and return the song if the title exists in our ArrayList songs
    // Else, return null
    private Song findSong(String title) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    // This function allow us to insert a specific song from albums into our playList, by trackNumber
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }
        // If the album doesn't have the trackNumber that we want to add in our playList, display this message
        System.out.println("This album dos not have a track " + trackNumber);
        return false;
    }

    // This function allow us to insert a specific song from albums into our playList, by title
    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        // If the album doesn't have the title that we want to add in our playList, display this message
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
}
