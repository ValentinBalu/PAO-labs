package tema.ex2;

import java.util.Comparator;

public class AnComparator implements Comparator<Album>{
    @Override
    public int compare(Album o1, Album o2) {
        return o1.getAn()-o2.getAn();
    }
}
