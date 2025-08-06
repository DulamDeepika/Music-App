import java.util.ArrayList;
import java.util.LinkedList;

class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration + " mins";
    }
}

class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Album album = new Album("Hits", "Various Artists");

        album.addSong("Shape of You", 4.24);
        album.addSong("Blinding Lights", 3.22);
        album.addSong("Perfect", 4.40);

        LinkedList<Song> playlist = new LinkedList<>();

        album.addToPlaylist("Shape of You", playlist);
        album.addToPlaylist("Blinding Lights", playlist);

        System.out.println("🎶 Playlist Songs:");
        for (Song song : playlist) {
            System.out.println(song);
        }
    }
}
