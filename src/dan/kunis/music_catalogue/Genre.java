package dan.kunis.music_catalogue;

import java.util.ArrayList;

public class Genre {

    private String name;
    private ArrayList<Genre> subGenres;

    public Genre(String name) {
        this.name = name;
        subGenres = new ArrayList<Genre>();
    }

    public Genre(String name, ArrayList<Genre> subgenres) {
        this.name = name;
        this.subGenres = subgenres;
    }

    public void addSubgenre(Genre subgenre) {
        subGenres.add(subgenre);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Genre> getSubGenres() {
        return subGenres;
    }
}
