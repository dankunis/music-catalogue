package dan.kunis;

import dan.kunis.music_catalogue.*;
import dan.kunis.music_catalogue.search_songs_engine.SearchEngine;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Initialise genres
        Genre vaporwave = new Genre("vaporwave");
        Genre mallsoft = new Genre("mallsoft");
        Genre hardvapour = new Genre("hardvapour");
        Genre future_funk = new Genre("future_funk");
        Genre vhs_pop = new Genre("vhs_pop");
        vaporwave.addSubgenre(mallsoft);
        Genre rock = new Genre("Rock");

        Artist nekoshi_corp = new Artist("nekoshi corp");
        Album album1 = new Album("NEWS AT 11", nekoshi_corp);
        Song song1 = new Song("Downtown", vaporwave, nekoshi_corp, album1, 2016);
        Song song2 = new Song("Goodmorning America!", vaporwave, nekoshi_corp, album1, 2016);

        Album album2 = new Album("Palm mall", nekoshi_corp);
        Song song3 = new Song("Palm mall", mallsoft, nekoshi_corp, album2, 2014);

        Artist acdc = new Artist("AC/DC");
        Album album3 = new Album("Back in black", acdc);
        Song song4 = new Song("Back in black", rock, acdc, album3, 1980);

        ArrayList<Song> songsCollections = new ArrayList<Song>() {{
            add(song1);
            add(song2);
            add(song3);
            add(song4);
        }};

        SearchEngine searchEngine = new SearchEngine(songsCollections);

        searchEngine.find().genre("vaporwave").results().forEach(song -> {
            StringBuilder genresString = new StringBuilder();
            for (Genre genre: song.getGenres()) {
                genresString.append(genre.getName());
                genresString.append(" ");
            }
            StringBuilder artistString = new StringBuilder();
            for (Artist artist: song.getArtists()) {
                artistString.append(artist.getName());
                artistString.append(" ");
            }
            System.out.println("{\n\tname: " + song.getName() +
                    "\n\talbum: " + song.getAlbum().getName() +
                    "\n\tgenre: " + genresString +
                    "\n\tartist: " + artistString +
                    "\n\tyear: " + song.getYear() + "\n}");
        });
    }
}
