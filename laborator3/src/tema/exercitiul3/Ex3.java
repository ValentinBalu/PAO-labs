package tema.exercitiul3;
import java.util.Arrays;
import java.util.Scanner;
public class Ex3 {
    public static String stringSort(String txt){
        char[] tmp = txt.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }
    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.println("Read the first string for ex3 : ");
        String cuvant1 = scanner.nextLine();

        System.out.println("Read the second string for ex3 : ");
        String cuvant2 = scanner.nextLine();

        String c1 = stringSort(cuvant1);
        String c2 = stringSort(cuvant2);

        if(c1.equals(c2)){
            System.out.println("The two words are anagrams!");
        }
        else{
            System.out.println("The two words are not anagrams!");
        }

    }

}
