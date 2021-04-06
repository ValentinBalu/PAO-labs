package practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Definiti o clasa care implementeaza operatii pe numere double, in care primul trebuie sa fie mai mic decat al doilea.
 * Operatiile vor arunca si exceptii.
 * In cazul in care nu apare vreo exceptie, scrieti intr-un fisier operatia executata, inputurile si rezultatul final.
 * Ex:
 * [ADD] 2.0 3.0 5.0
 * [DIVIDE] 5.0 2.0 2.5
 */
public class Ex2 {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti primul nr: ");
        double nr1 = scanner.nextDouble();
        System.out.println("Introduceti al doilea nr: ");
        double nr2 = scanner.nextDouble();

        // TODO: initialize
        Calculator calculator = new CalculatorImpl();

        File file = new File("ex2.txt");

        if(file.exists()){
            file.delete();
        }else{
            try{
                file.createNewFile();

            }catch (IOException e){
                e.printStackTrace();            }
        }

        // TODO: write to file if conditions met
        try{
            Double res = calculator.add(nr1,nr2);

            String text = "[ADD]" + " " +nr1 +" "+nr2+ " " + res;


            writeUsingFileWriter(text,file);

            res = calculator.divide(nr1,nr2);

            text = "[DIVIDE]" + " " +nr1 +" "+nr2+ " " + res;

            writeUsingFileWriter(text,file);


        }catch (Calculator.BadInputException | Calculator.InvalidParameterException e){
            System.out.println(e.getMessage());
        }

    }
    public static void writeUsingFileWriter(String text,File file)  {

        try (FileWriter fileWriter = new FileWriter(file,true)) {
            fileWriter.append(text);
            fileWriter.append('\n');
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}