package cabinet;
import cabinet.readwriteservice.WriteService;
import cabinet.repository.MedicRepository;
import cabinet.repository.OftalmologRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;


public class OftalmologService {

    public static void afisareMeniu(){
        System.out.println("Lista serviciilor pentru categoria oftalmolog : ");
        System.out.println("1.Afisare Lista tuturor Oftalmologilor");
        System.out.println("2.Adaugare Oftalmolog");
        System.out.println("3.Editare durata consultatie");
        System.out.println("4.Eliminare Oftalomolog");
    }


    public static void adaugareOftalmolog(){
        System.out.println("Adaugare Oftalmolog :");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Intrduceti numele :");
        String nume = scanner.nextLine();
        System.out.println("Introduceti varsta : ");
        int varsta = scanner.nextInt();
        System.out.println("Introduceti specialitatea :");
        String specialitate = scanner.next();
        System.out.println("Introduceti tura :");
        int tura = scanner.nextInt();
        System.out.println("Introduceti durata consultatiei :");
        int durata = scanner.nextInt();
        System.out.println("Este chirurg ? Introduceti 1 pentru da sau 0 pentru nu!");
        int chirurgie = scanner.nextInt();
        Boolean chirurg = false;
        if(chirurgie==1)
            chirurg = true;
        String organ = "ochi";
        Oftalmolog oftalmolog = new Oftalmolog(nume,varsta,specialitate,tura,organ,durata,chirurg);
        System.out.println(oftalmolog.toString());

        //adaug medicul
        OftalmologRepository oftalmologRepository = new OftalmologRepository();
        oftalmologRepository.insertOftalmolog(oftalmolog);

        //afisez in istoric
        WriteService.writeIstoric("adaugareOftalmolog",true);

    }

    public static void editareDurataConsultatieOft(){

        System.out.println("Introduceti id-ul oftalomologului caruia doriti sa ii modificati durata consultatiei :");
        Scanner scanner =  new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Introduceti noua durata :");
        int durata = scanner.nextInt();

        OftalmologRepository oftalmologRepository = new OftalmologRepository();
        oftalmologRepository.updateDurataConsultatie(durata,id);

        //afisez in istoric
        WriteService.writeIstoric("editareTuraMedic",true);

    }

    public static void  eliminareOftalmolog(){

        System.out.println("Introdceti id-ul oftalmologului pe care doriti sa il eliminati :");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        OftalmologRepository oftalmologRepository = new OftalmologRepository();
        oftalmologRepository.deleteOftalmolog(id);

        //afisez in istoric
        WriteService.writeIstoric("eliminareOftalmolog",true);

    }

}
