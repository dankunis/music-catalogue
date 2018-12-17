package dan.kunis.music_catalogue;

import java.util.ArrayList;

public class Song {

    private String name;
    private ArrayList<Genre> genre;
    private ArrayList<Artist> artist;
    private Album album;
    private int year;

    public Song(String name, ArrayList<Genre> genre, ArrayList<Artist> artist, Album album, int year) {
        this.name = name;
        this.album = album;
        this.genre = genre;
        this.artist = artist;
        this.year = year;

        album.addSong(this);
    }

    public Song(String name, Genre genre, Artist artist, Album album, int year) {
        this.name = name;
        this.album = album;
        this.genre = new ArrayList<Genre>() {{
            add(genre);
        }};
        this.artist = new ArrayList<Artist>() {{
            add(artist);
        }};
        this.year = year;

        album.addSong(this);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Genre> getGenres() {
        return genre;
    }

    public ArrayList<Artist> getArtists() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }

    public int getYear() {
        return year;
    }
}
