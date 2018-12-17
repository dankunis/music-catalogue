package dan.kunis.music_catalogue;

import java.util.ArrayList;

public class Playlist {

    private String name;
    private ArrayList<Song> songs;
//    private ArrayList<Genre> genres;

    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<Song>();
//        genres = new ArrayList<Genre>();
    }

    public Playlist(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        songs.add(song);
//        song.getGenres().forEach(genre -> {
//            if (!this.genres.contains(genre)) {
//                this.genres.add(genre);
//            }
//        });
    }

    public void addAlbum(Album album) {
        album.getSongs().forEach(this::addSong);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
