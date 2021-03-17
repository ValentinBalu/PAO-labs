package tema.ex2;

import java.util.Comparator;

public class ArtistComparator implements Comparator<Album>{
    @Override
    public int compare(Album album1, Album album2) {
        return album1.getArtist().compareTo(album2.getArtist());
    }
}
