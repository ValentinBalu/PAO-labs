package com.company;

import cabinet.*;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.lang.ref.Cleaner;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Main {

    public static void medicService(Medic[] listaMedici){
        MedicService.afisareMeniu();
        Scanner scannerul = new Scanner(System.in);
        System.out.println();
        System.out.println("Alegeti o optiune :");
        int op = scannerul.nextInt();
        if(op==1){
            MedicService.afisareListMedici(listaMedici);
        }else if(op==2){
            System.out.println("Introduceti denumirea specialitatii : ");
            String specialitatea = scannerul.next();
            MedicService.afisareListaMediciSpecialitate(listaMedici,specialitatea);
        }else if (op == 3){
            listaMedici = MedicService.adaugareMedic(listaMedici);
            MedicService.afisareListMedici(listaMedici);
        }else if(op == 4) {
            listaMedici = MedicService.eliminareMedic(listaMedici);
            MedicService.afisareListMedici(listaMedici);
        } else{
            System.out.println("Introduceti o optiune valida!");
            medicService(listaMedici);
        }
        System.out.println();

    }

    public static void clientService(Client[] listaClienti){
        ClientService.afisareMeniu();
        Scanner scannerul = new Scanner(System.in);
        System.out.println();
        System.out.println("Alegeti o optiune :");
        int op = scannerul.nextInt();
        if(op==1){
            ClientService.afisareListaClienti(listaClienti);
        }else if(op==2){
            ClientService.afisareListaCopii(listaClienti);
        }else if (op == 3){
            ClientService.afisareListaAdulti(listaClienti);
        }else if(op == 4) {
            listaClienti = ClientService.adaugareClient(listaClienti);
            ClientService.afisareListaClienti(listaClienti);
        }else if(op == 5) {
            listaClienti = ClientService.editareVarstaClient(listaClienti);
            ClientService.afisareListaClienti(listaClienti);
        }else {
            System.out.println("Introduceti o optiune valida!");
            clientService(listaClienti);
        }
        System.out.println();

    }

    public static void programareService(Programare[] listaProgramari){
        ProgramareService.afisareMeniu();
        Scanner scannerul = new Scanner(System.in);
        System.out.println();
        System.out.println("Alegeti o optiune :");
        int op = scannerul.nextInt();
        if(op==1){
            ProgramareService.afisareListaProgramari(listaProgramari);
        }else if(op==2){
            listaProgramari = ProgramareService.adaugareProgramare(listaProgramari);
            ProgramareService.afisareListaProgramari(listaProgramari);
        }else if (op == 3){
            listaProgramari = ProgramareService.editareProgramare(listaProgramari);
            ProgramareService.afisareListaProgramari(listaProgramari);
        }else if(op == 4) {
            listaProgramari = ProgramareService.eliminareProgramare(listaProgramari);
            ProgramareService.afisareListaProgramari(listaProgramari);
        } else{
            System.out.println("Introduceti o optiune valida!");
            programareService(listaProgramari);
        }
        System.out.println();
    }

    public static int optiune(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ce servicii doriti sa utilizati?");
        System.out.println("1.Servicii pentru Medici");
        System.out.println("2.Servicii pentru Clienti");
        System.out.println("3.Servicii pentru Programari");
        System.out.println("Selectati optiunea :");
        int op = scanner.nextInt();
        return op;
    }

    public static void main(String[] args) {
        System.out.println("Hello from proiect, Valentine!");
        Client client1 = new Client("Ion Popescu","5001122345678",34,'M',new String[]{"nas indufndat" , "tuse productiva"});
        //System.out.println(client1.toString());

        Adult adult1 = new Adult("Viorel Georgescu","5123456781345",56,'M',new String[]{"maini reci","nas umed"},new String[]{"diabet","pancreatita"},new String[]{"Xyzal"},Boolean.TRUE);
        //System.out.println(adult1.toString());

        Copil copil1 = new Copil("Ana Balutoiu","6987612786543",9,'F',new String[]{"febra","tuse"},new String[]{"Tetramune"," vaccin antipolio"});
        //System.out.println(copil1.toString());

        Medic medic1 = new Medic("Ioana Manoiu",56,"ORL",2);
        //System.out.println(medic1.toString());

        Oftalmolog oftalmolog1 = new Oftalmolog("Andrei Zuhalcescu", 45 , "oftalmologie",2,"ochi",45,Boolean.TRUE);
        //System.out.println(oftalmolog1.toString());

        Cardiolog cardiolog1 = new Cardiolog("Marius Zaharia",61,"cardiologie",1,"inima",60, (short)198);
        //System.out.println(cardiolog1.toString());

        Cardiolog cardiolog2 = new Cardiolog("Lavinia Bustean",41 , "cardiologie",2,"inima",60,(short)171);
        //System.out.println(cardiolog2.toString());

        Programare programare1 = new Programare("Cristian Popescu","12/3/2021","15:23","cardiologie","Marius Zaharia",150);
        //System.out.println(programare1.toString());

        Programare programare2 = new Programare("Ana Balutoiu","29/04/2021","14:50","oftalmologie","Andrei Zuhalcescu",200);
        //System.out.println(programare2.toString());

        Client[] listaClienti = new Client[]{client1,copil1,adult1};
        //sortare array clienti folosind NumeComparator
        System.out.println("Lista Clientilor inainte de sortare : ");
        for(Client client : listaClienti){
            System.out.println(client.toString());
        }
        System.out.println();
        NumeComparator numeComparator = new NumeComparator();
        Arrays.sort(listaClienti,numeComparator);
        System.out.println("Lista Clientilor dupa sortare : ");
        for(Client client : listaClienti){
            System.out.println(client.toString());
        }
        System.out.println();

        Medic[] listaMedici = new Medic[]{medic1,oftalmolog1,cardiolog1,cardiolog2};

        //sortare array medici folosind comparable
        System.out.println("Lista Medicilor inainte de sortare : ");
        for(Medic medic : listaMedici){
            System.out.println(medic.toString());
        }
        System.out.println();
        Arrays.sort(listaMedici);
        System.out.println("Lista Medicilor dupa sortare : ");
        for(Medic medic : listaMedici){
            System.out.println(medic.toString());
        }
        System.out.println();

        Programare[] listaProgramari = new Programare[]{programare1,programare2};

        //Handling services
        int op = optiune();
        if(op==1){
            medicService(listaMedici);
        }else if(op==2 ){
            clientService(listaClienti);
        }else if(op==3){
            programareService(listaProgramari);
        }else{
            System.out.println("Introduceti o optiune valida");
        }
    }
}
