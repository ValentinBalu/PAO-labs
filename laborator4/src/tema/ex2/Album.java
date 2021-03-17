package tema.ex2;

import java.lang.reflect.AnnotatedArrayType;
import java.util.Arrays;

public class Album implements Comparable<Album> {

    private String nume;

    private String artist;

    private double rating;

    private int an;

    public Album(){}

    public Album(String nume,String artist,double rating,int an){
        this.nume = nume;
        this.artist = artist;
        this.rating = rating;
        this.an = an;
    }

    public double getRating() {
        return rating;
    }

    public String getNume() {
        return nume;
    }

    public String getArtist() {
        return artist;
    }

    public int getAn() {
        return an;
    }

    @Override
    public int compareTo(Album album) {
        /*
        * Returns:
        * - positive integer, if the current object is greater than the
        specified object.
        * - negative integer, if the current object is less than the
        specified object.
        * - zero, if the current object is equal to the specified object.
        */
        return this.an - album.an;
    }

    @Override
    public String toString() {
        return "The album '" + nume + '\'' +
                " by " + artist +
                " with a rating of " + rating +
                " was released in " + an +
                '.';
    }

}
