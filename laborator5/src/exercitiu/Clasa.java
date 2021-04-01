package exercitiu;

public class Clasa <T,S>{
    public void printArray(T[] array1,S[] array2){
        for(T ob : array1){
            System.out.println(ob.toString());
        }
        for (S ob :array2){
            System.out.println(ob.toString());
        }

    }

    public static void main(String[] args){
        Integer[] vct1 = {1,2,3};
        String[] vct2 = {"Hello","World"};
        Clasa<Integer,String> clasa = new Clasa<Integer,String>();
        clasa.printArray(vct1,vct2);
    }

}
