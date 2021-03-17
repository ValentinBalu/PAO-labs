package tema.ex2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){

        Album a1 = new Album("Sweetner","Ariana Grande",87.8,2018);
        Album a2 = new Album("The Thrill of it all","Sam Smith",78.12,2016);
        Album a3 = new Album("Love Goes","Sam Smith",79.1,2020);
        Album a4 = new Album("Scorpion","Drake",91.4,2018);
        Album a5 = new Album("Scorpion","The Scorpions Tribute",67.4,1999);

        Album[] albums = new Album[]{a1,a2,a3,a4,a5};

        //before sorting
        System.out.println("The Array before sorting:");
        for(Album album : albums){
            System.out.println(album.toString());
        }
        System.out.println();

        //using comparable (dupa an)
        Arrays.sort(albums);
        System.out.println("The sorted Array using comparable:");
        for(Album album : albums){
            System.out.println(album.toString());
        }
        System.out.println();

        //using AnComparator
        AnComparator anComparator = new AnComparator();
        Arrays.sort(albums,anComparator);
        System.out.println("The sorted Array using AnComparator:");
        for(Album album : albums){
            System.out.println(album.toString());
        }
        System.out.println();

        //using ArtistComparator
        ArtistComparator artistComparator = new ArtistComparator();
        Arrays.sort(albums,artistComparator);
        System.out.println("The sorted Array using ArtistComparator:");
        for(Album album : albums){
            System.out.println(album.toString());
        }
        System.out.println();

        //using NumeComparator
        NumeComparator numeComparator = new NumeComparator();
        Arrays.sort(albums,numeComparator);
        System.out.println("The sorted Array using NumeComparator:");
        for(Album album : albums){
            System.out.println(album.toString());
        }
        System.out.println();

        //using RatingComparator
        RatingComparator ratingComparator = new RatingComparator();
        Arrays.sort(albums,ratingComparator);
        System.out.println("The sorted Array using RatingComparator:");
        for(Album album : albums){
            System.out.println(album.toString());
        }
        System.out.println();
    }
}
