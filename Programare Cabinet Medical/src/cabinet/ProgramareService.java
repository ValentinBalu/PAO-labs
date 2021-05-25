package cabinet;

import cabinet.readwriteservice.WriteService;
import cabinet.repository.OftalmologRepository;
import cabinet.repository.ProgramareRepository;

import javax.sound.midi.Soundbank;
import javax.sound.sampled.Port;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProgramareService {

    public static void afisareMeniu(){
        System.out.println("Lista serviciilor pentru categoria programari : ");
        System.out.println("1.Afisare tuturor programarilor");
        System.out.println("2.Adaugare Programare");
        System.out.println("3.Editare Data&Ora Programare");
        System.out.println("4.Anulare Programare");
    }

    public static void afisareListaProgramari(Map<Integer,Programare> programariHashMap){
        System.out.println("Lista tuturor Programarilor este :\n");

        for(Map.Entry<Integer,Programare> pair : programariHashMap.entrySet())
            System.out.println("programarea "+pair.getKey() + " : "+pair.getValue());

        //afisez in istoric
        WriteService.writeIstoric("afisareListaProgramari",true);
    }

    public static Map<Integer, Programare> adaugareProgramare(Map<Integer,Programare> programariHashMap){
        System.out.println("Adaugare Programare :");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Intrduceti numele clientului :");
        String nume = scanner.nextLine();
        System.out.println("Introduceti data programarii :");
        String data = scanner.next();
        System.out.println("Introduceti ora programarii : ");
        String ora = scanner.next();
        System.out.println("Introduceti specialitate :");
        String specialitate = scanner.next();
        System.out.println("Introduceti prenumele medicului :");
        String prenumeMedic = scanner.next();
        System.out.println("Introduceti numele medicului :");
        String numeMedic = scanner.next();
        String numeleMedicului = prenumeMedic + " " + numeMedic;
        System.out.println("Introduceti costul consultatiei :");
        double cost = scanner.nextDouble();
        System.out.println("Introduceti id-ul medicului :");
        int id_medic = scanner.nextInt();
        System.out.println("Introduceti id-ul clientului :");
        int id_client = scanner.nextInt();
        Programare programare = new Programare(nume,data,ora,specialitate,numeleMedicului,cost,id_medic,id_client);
        System.out.println(programare.toString());
        //adaug programarea
        Integer k =0;
        for(Map.Entry<Integer,Programare> pair : programariHashMap.entrySet())
            k = pair.getKey();

        programariHashMap.put(k+1,programare);

        ProgramareRepository programareRepository = new ProgramareRepository();
        programareRepository.insertProgramare(programare);

        //afisez in istoric
        WriteService.writeIstoric("adaugareProgramare",true);

        return programariHashMap;
    }

    public static void editareProgramare(){
        System.out.println("Introduceti id-ul programarii pe care doriti sa o modificati :");
        Scanner scanner =  new Scanner(System.in);
        int id = scanner.nextInt();
//        Integer key = scanner.nextInt();
//        int ok = 1;
//        for(Map.Entry<Integer,Programare> pair : programariHashMap.entrySet()){
//            if(key == pair.getKey()) {
//                System.out.println("Introduceti noua data :");
//                String data = scanner.next();
//                pair.getValue().setDataProgramare(data);
//                System.out.println("Introduceti noua ora :");
//                String ora = scanner.next();
//                pair.getValue().setOraProgramare(ora);
//                ok =0;
//                break;
//            }
//        }
//        if(ok == 1 ){
//            System.out.println("Nu s-a gasit nicio programare cu acest numar!");
//        }

        System.out.println("Introduceti noua data :");
        String data = scanner.next();
        System.out.println("Introduceti noua ora :");
        String ora = scanner.next();

        ProgramareRepository programareRepository = new ProgramareRepository();
        programareRepository.updateDataOraProgramare(data,ora,id);

        //afisez in istoric
        WriteService.writeIstoric("editareProgramare",true);
//
//        return programariHashMap;
    }
//
//    public static Map<Integer, Programare> eliminareProgramare(Map<Integer,Programare> programariHashMap){
//        Scanner scanner1 = new Scanner(System.in);
//        System.out.println("Introduceti numarul programarii pe care doriti sa o anulati :");
//        Integer key = scanner1.nextInt();
//        if (programariHashMap.containsKey(key)){
//            programariHashMap.remove(key);
//        }
//        else {
//            System.out.println("Nu s-a gasit nicio programare pe numele acestei persoane!");
//        }
//
//        //afisez in istoric
//        WriteService.writeIstoric("eliminareProgramare",true);
//
//        return programariHashMap;
//    }
    public static void  anulareProgramare(){

        System.out.println("Introdceti id-ul programarii pe care doriti sa o anulati :");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        ProgramareRepository programareRepository = new ProgramareRepository();
        programareRepository.deleteProgramare(id);

        //afisez in istoric
        WriteService.writeIstoric("anulareProgramare",true);

    }
}
