package com.company;

import java.util.*;

public class Main {

    // I created the albums object which is an ArrayList of Album
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        // I created the first album object and I inserted to it songs
        Album album = new Album ("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        // I added to albums the first album ("Stormbringer")
        albums.add(album);

        // I created the second album object and I inserted to it songs
        album = new Album ("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Let's go", 3.45);
        album.addSong("Inject de venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        // I added to albums the second album ("For those about to rock")
        albums.add(album);

        // I created the playList object which is a LinkedList of Song and added to it a few songs
        // from the albums "Stormbringer" and "For those about to rock"
        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList); // does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList); // there is no track 24

        // Starts the application
        play(playList);
    }

    // This function starts the application
    private static void play(LinkedList<Song> playList){
        // scanner is used to introduce datas from System.in (in our case, keyboard)
        Scanner scanner = new Scanner(System.in);
        // The condition to stop application
        boolean quit = false;
        // The condition to verify the direction of listIterator
        boolean forward = true;
        /**I used a ListIterator
         * to traverse the list in either direction, modify
         * the list during iteration, and obtain the iterator's
         * current position in the list.**/
        ListIterator<Song> listIterator = playList.listIterator();
        // Check if exists songs in playlist
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing: " + listIterator.next().toString());
        }

        // Starts te menu
        while (!quit) {
            System.out.println("Choose one: (6 -> to print menu)");

            // Scans the data typed from keyboard
            int choice = scanner.nextInt();
            scanner.nextLine();

            // According to data store in var choice you can execute the next actions:
            switch (choice){

                // To exit from playlist
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;

                // To play next song, if exists
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing: " + listIterator.next().toString());
                    } else {
                        // If not, display this message
                        System.out.println("You have reached the END of the playlist");
                        forward = false;
                    }
                    break;

                // To play previous song, if exists
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    } else {
                        // If not, display this message
                        System.out.println("You have reached the TOP of the playlist");
                        forward = true;
                    }
                    break;

                // To replay the current song if you are not at the TOP or at the END of the playlist
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("You are at the TOP of the list");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing: " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("You have reached the END of the playlist");
                        }
                    }
                    break;

                // To print all songs from the playList
                case 4:
                    printList(playList);
                    break;

                // To delete the current song from playlist
                case 5:
                    if (playList.size() > 0){
                        listIterator.remove();
                        // After remove current song, play next song, if exists
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()){
                            // Else play previous song, if exists
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;

                // To print the menu of actions you can execute
                case 6:
                    printMenu();
                    break;
            }
        }
    }

    // This function print all songs from the playList
    public static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("====================================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("====================================");
    }


    // This function display all actions you can execute by typing a specific number
    public static void printMenu(){
        System.out.println("\nChoose one action:\npress:\n" +
                            "0 -> to quit\n"+
                            "1 -> to play next song\n"+
                            "2 -> to to play previous song\n"+
                            "3 -> to replay the current song\n"+
                            "4 -> to print playlist\n" +
                            "5 -> to delete current song from playlist\n"+
                            "6 -> to print menu\n");
    }
}
