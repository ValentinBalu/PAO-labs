package tema;

import fisiere.exceptions.FileReadingException;
import fisiere.exceptions.FileWritingException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Scanner;

public class Ex2 {

    //functie pt scriere in fisier
    public static void writer(String text[],int nr) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("ex2.txt"))) {
            for(int i=0;i<nr-1;i=i+2){
                buffer.write(text[i]);
                buffer.write(" ");
                buffer.write(text[i+1]);
                buffer.write('\n');
            }

        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writer method", e);
        }
    }

    public static void main(String[] args) throws FileWritingException, FileReadingException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul de perechi : ");
        int nr = scanner.nextInt();

        String[] numere = new String[nr*2];
        int k = 0;

        System.out.println("Introduceti perechile");
        for(int i = 0 ;i<nr ;i ++){
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();
            try{
                if(p1<p2) {
                    numere[k++] = String.valueOf(p1);
                    numere[k++] = String.valueOf(p2);
                }
                else{
                        throw new GreaterException("Primul element al perechii nu este mai mic decat al doilea!");
                }
            }catch (GreaterException e){
                System.out.println(e.getMessage());
                System.out.println("Introduceti alta pereche : ");
                int p1p = scanner.nextInt();
                int p2p = scanner.nextInt();
                numere[k++] = String.valueOf(p1p);
                numere[k++] = String.valueOf(p2p);
            }
        }

        writer(numere,k);
    }
}
