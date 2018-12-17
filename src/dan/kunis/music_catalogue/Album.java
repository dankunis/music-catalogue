package dan.kunis.music_catalogue;

import java.util.ArrayList;

public class Album {

    private String name;
    private ArrayList<Artist> artists;
    private ArrayList<Song> songs;

    public Album(String name, ArrayList<Artist> artists, ArrayList<Song> songs) {
        this.name = name;
        this.artists = artists;
        this.songs = songs;

        artists.forEach(artist -> artist.addAlbum(this));
    }

    public Album(String name, Artist artist) {
        this.name = name;
        this.artists = new ArrayList<Artist>() {{add(artist);}};
        this.songs = new ArrayList<Song>();

        artist.addAlbum(this);
    }

    void addSong(Song song) {
        this.songs.add(song);
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }
}
