package test;

import java.util.Locale;

public class test {
    public static void afisare(){
        System.out.println("hello Vale from test!");
    }

    public static void main(String[] args){
        System.out.println("am nevoie de mancare!");
        String a = "nobody cares";
        System.out.println(a.toUpperCase(Locale.ROOT));
        System.out.println(a.equals("somebody cares"));
        System.out.println(a.charAt(2));
    }
}
