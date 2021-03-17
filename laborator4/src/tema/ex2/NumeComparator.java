package tema.ex2;
import java.util.Comparator;

public class NumeComparator implements Comparator<Album>{

    @Override
    public int compare(Album album1,Album album2) {
        return album1.getNume().compareTo(album2.getNume());
    }
}
