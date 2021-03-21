package cabinet;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class ProgramareService {
    public static void afisareMeniu(){
        System.out.println("Lista serviciilor pentru categoria programari : ");
        System.out.println("1.Afisare tuturor programarilor");
        System.out.println("2.Adaugare Programare");
        System.out.println("3.Editare Data&Ora Programare");
        System.out.println("4.Anulare Programare");
    }
    public static void afisareListaProgramari(Programare[] ListaProgramari){
        System.out.println("Lista tuturor Programarilor este :");
        for (Programare programare : ListaProgramari){
            System.out.println(programare.toString());
        }
    }
    public static Programare[] addProgramare(Programare[] ListaProgramari,Programare programare){
        Programare[] newListaProgramari = new Programare[ListaProgramari.length+1];
        for(int i =0;i <ListaProgramari.length;i++)
            newListaProgramari[i] = ListaProgramari[i];
        newListaProgramari[ListaProgramari.length] = programare;
        return newListaProgramari;
    }
    public static Programare[] adaugareProgramare(Programare[]ListaProgramari){
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
        Programare programare = new Programare(nume,data,ora,specialitate,numeleMedicului,cost);
        System.out.println(programare.toString());
        //adaug clientul
        Programare[] nouListaProgramare= addProgramare(ListaProgramari,programare);
        return nouListaProgramare;
    }
    public static Programare[] editareProgramare(Programare[]ListaProgramare){
        System.out.println("Introduceti numele persoanei a carei programare doriti sa fie modificata :");
        Scanner scanner =  new Scanner(System.in);
        String nume = scanner.nextLine();
        int ok = 1;
        for(Programare programare : ListaProgramare){
            if(programare.getNumeClient().equals(nume)){
                System.out.println("Introduceti noua data :");
                String data = scanner.next();
                programare.setDataProgramare(data);
                System.out.println("Introduceti noua ora :");
                String ora = scanner.next();
                programare.setOraProgramare(ora);
                break;
            }
            ok =0;
        }
        if(ok == 0 ){
            System.out.println("Nu s-a gasit nicio programare pe numele acestei persoane!");
        }
        return ListaProgramare;
    }
    public static Programare[] eliminareProgramare(Programare[]ListaProgramari){
        Programare[] nouListaProgramari = new Programare[ListaProgramari.length-1];
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti numele clientului a carui programare doriti sa o anulati :");
        String nume = scanner1.nextLine();
        System.out.println(nume);
        int index = 0;
        int ok = 1;
        for(int i=0 ;i < ListaProgramari.length;i++){
            if(ListaProgramari[i].getNumeClient().equals(nume)){
                index = i;
                break;
            }
            ok = 0;
        }
        if(ok == 0){
            System.out.println("Nu s-a gasit nicio programare pe numele acestei persoane!");
            return ListaProgramari;
        }else {
            for (int i = 0, j = 0; i < ListaProgramari.length; i++) {
                if (i != index) {
                    nouListaProgramari[j++] = ListaProgramari[i];
                }
            }
            System.out.println(nume);
            return nouListaProgramari;
        }
    }
}
