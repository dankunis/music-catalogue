package dan.kunis.music_catalogue.search_songs_engine;

import dan.kunis.music_catalogue.Song;

import java.util.ArrayList;

public class SearchEngine {
    private ArrayList<Song> songCollection;

    public SearchEngine(ArrayList<Song> songCollection) {
        this.songCollection = songCollection;
    }

    public SearchQuery find() {
        return new SearchQuery(songCollection);
    }
}
