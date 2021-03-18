package com.company;

import cabinet.*;

import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from proiect, Valentine!");
        Client client1 = new Client("Ion Popescu","5001122345678",34,'M',new String[]{"nas indufndat" , "tuse productiva"});
        System.out.println(client1.toString());

        Adult adult1 = new Adult("Viorel Georgescu","5123456781345",56,'M',new String[]{"maini reci","nas umed"},new String[]{"diabet","pancreatita"},new String[]{"Xyzal"},Boolean.TRUE);
        System.out.println(adult1.toString());

        Copil copil1 = new Copil("Ana Balutoiu","6987612786543",9,'F',new String[]{"febra","tuse"},new String[]{"Tetramune"," vaccin antipolio"});
        System.out.println(copil1.toString());

        Medic medic1 = new Medic("Ioana Manoiu",38,"ORL",2);
        System.out.println(medic1.toString());

        Oftalmolog oftalmolog1 = new Oftalmolog("Andrei Zuhalcescu", 45 , "oftalmologie",2,"ochi",45,Boolean.TRUE);
        System.out.println(oftalmolog1.toString());

        Cardiolog cardiolog1 = new Cardiolog("Marius Zaharia",61,"cardiologie",1,"inima",60, (short)198);
        System.out.println(cardiolog1.toString());

        Programare programare1 = new Programare("Cristian Popescu","12/3/2021","15:23","cardiologie","Marius Zaharia",150);
        System.out.println(programare1.toString());
    }
}
