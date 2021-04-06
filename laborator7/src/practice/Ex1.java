package practice;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.security.SecureRandom;

/**
 * Cititi de la stdin o linie de text si scrieti o in fisier.
 * Nu uitati sa afisati un mesaj sugestiv in cazul aparitiei unei exceptii si sa inchideti resursa dupa terminarea folosirii acesteia.
 */
public class Ex1 {
    public static void writeUsingFileWriter(String text,File file)  {

        try (FileWriter fileWriter = new FileWriter(file,true)) {
            fileWriter.append(text);
            fileWriter.append('\n');
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti linia de text: ");
        String line = scanner.next();

        // TODO scrie in fisier

        File file = new File("ex1.txt");

        if(file.exists()){
            file.delete();
        }else{
            try{
                file.createNewFile();

            }catch (IOException e){
                e.printStackTrace();            }
        }
        writeUsingFileWriter(line,file);
    }

}