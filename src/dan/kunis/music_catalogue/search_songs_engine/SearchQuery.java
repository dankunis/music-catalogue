package dan.kunis.music_catalogue.search_songs_engine;

import dan.kunis.music_catalogue.Artist;
import dan.kunis.music_catalogue.Genre;
import dan.kunis.music_catalogue.Song;

import java.util.ArrayList;

public class SearchQuery {
    private ArrayList<Song> currentQuery;

    SearchQuery(ArrayList<Song> currentQuery) {
        this.currentQuery = currentQuery;
    }

    public SearchQuery all() {
        return new SearchQuery(currentQuery);
    }

    public SearchQuery song(String title) {
        ArrayList<Song> newQuery = new ArrayList<Song>();
        for (Song song: currentQuery) {
            if (song.getName().contains(title)) {
                newQuery.add(song);
            }
        }
        return new SearchQuery(newQuery);
    }

    public SearchQuery album(String title) {
        ArrayList<Song> newQuery = new ArrayList<Song>();
        for (Song song: currentQuery) {
            if (song.getAlbum().getName().contains(title)) {
                newQuery.add(song);
            }
        }
        return new SearchQuery(newQuery);
    }

    public SearchQuery year(int wantedYear) {
        ArrayList<Song> newQuery = new ArrayList<Song>();
        for (Song song: currentQuery) {
            if (song.getYear() == wantedYear) {
                newQuery.add(song);
            }
        }
        return new SearchQuery(newQuery);
    }

    public SearchQuery artist(String name) {
        ArrayList<Song> newQuery = new ArrayList<Song>();
        for (Song song: currentQuery) {
            for (Artist artist: song.getArtists()) {
                if (artist.getName().contains(name)) {
                    newQuery.add(song);
                }
            }
        }
        return new SearchQuery(newQuery);
    }

     public SearchQuery genre(String genreName) {
        ArrayList<Song> newQuery = new ArrayList<Song>();
        for (Song song: currentQuery) {
            for (Genre genre: song.getGenres()) {
                if (genre.getName().contains(genreName) && !newQuery.contains(song)) {
                    newQuery.add(song);
                    searchSubGenres(genre, newQuery);
                }
            }
        }
        return new SearchQuery(newQuery);
    }

    private void searchSubGenres(Genre parentGenre, ArrayList<Song> newQuery) {
        for (Genre subGenre: parentGenre.getSubGenres()) {
            searchSubGenres(subGenre, newQuery);
            for (Song song: currentQuery) {
                if (song.getGenres().contains(subGenre) && !newQuery.contains(song)) {
                    newQuery.add(song);
                }
            }
        }
    }

    public ArrayList<Song> results() {
        return currentQuery;
    }
}
