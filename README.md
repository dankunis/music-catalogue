# Music catalogue
Create music playlists and search songs by names, albums, artists, genres and years.

## Features

> See the full [usage example](https://github.com/dankunis/music-catalogue/blob/master/src/dan/kunis/Main.java "example") source code

- Create genres and subgenres
```java
Genre rock = new Genre("Rock");
Genre hardRock = new Genre("Hard Rock");
rock.addSubgenre(hardRock);
```

- Create artists
```java
Artist acdc = new Artist("AC/DC");
```

- Create albums
```java
 Album backInBlack = new Album("Back in black", acdc);
```

- Create songs
```java
 Song song = new Song("Back in black", rock, acdc, backInBlack, 1980);
```

- Create playlists
```java
ArrayList<Song> songsCollections = new ArrayList<Song>() {{
            add(song1);
            add(song2);
            add(song3);
            add(song4);
}};
```

- Search for songs by names, albums, artists, genres and years
```java
searchEngine.find()
	.name("Black")
	.genre("Rock")
	.year(1980)
	.album("Back In Black")
	.artist("AC/DC")
	.results()
```

- Pretty print example
```java
searchEngine.find().genre("Hard Rock").results().forEach(song -> {
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
```
