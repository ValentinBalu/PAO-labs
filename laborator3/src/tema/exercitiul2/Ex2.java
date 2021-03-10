package tema.exercitiul2;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args){

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.println("Read the string for ex2 : ");

        String text = scanner.nextLine();

        StringBuilder textNou = new StringBuilder(text);

        String textInvers = textNou.reverse().toString();

        //System.out.println(textInvers);

        System.out.println(text.equals(textInvers));
    }
}
