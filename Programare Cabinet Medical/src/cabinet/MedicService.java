package cabinet;
import cabinet.readwriteservice.WriteService;
import cabinet.repository.ClientRepository;
import cabinet.repository.MedicRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;


public class MedicService {

    public static void afisareMeniu(){
        System.out.println("Lista serviciilor pentru categoria medic : ");
        System.out.println("1.Afisare Lista tuturor Medicilor");
        System.out.println("2.Afisare Lista Medici cu o anumita specialitate");
        System.out.println("3.Adaugare Medic");
        System.out.println("4.Eliminare Medic");
        System.out.println("5.Editare tura Medic");
    }

    public static void afisareListMedici(ArrayList<Medic> medicArrayList){
        System.out.println("Lista tuturor Medicilor este :");
        for (Medic medic : medicArrayList){
            System.out.println(medic.toString());
        }

        //afisez in istoric
        WriteService.writeIstoric("afisareListaMedici",true);

    }

    public static void afisareListaMediciSpecialitate(ArrayList<Medic> medicArrayList, String specialitate){
        System.out.println("Lista Medicilor cu specialitatea "+specialitate +" :");
        int ok=1;
        for(Medic medic : medicArrayList){
            if(medic.getSpecialitate().equals(specialitate)){
                System.out.println(medic.toString());
                ok=0;
            }
        }
        if(ok==1){
            System.out.println("Nu exista niciun medic cu aceasta specialitate!");
        }

        //afisez in istoric
        WriteService.writeIstoric("afisareListaMediciSpecialitate",true);
    }

    public static ArrayList<Medic>  adaugareMedic(ArrayList<Medic> medicArrayList){
        System.out.println("Adaugare Medic :");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Intrduceti numele :");
        String nume = scanner.nextLine();
        System.out.println("Introduceti varsta : ");
        int varsta = scanner.nextInt();
        System.out.println("Introduceti specialitatea :");
        String specialitate = scanner.next();
        System.out.println("Introduceti tura :");
        int tura = scanner.nextInt();
        Medic medic = new Medic(nume,varsta,specialitate,tura);
        System.out.println(medic.toString());

        //adaug medicul
        medicArrayList.add(medic);
        MedicRepository medicRepository = new MedicRepository();
        medicRepository.insertMedic(medic);

        //afisez in istoric
        WriteService.writeIstoric("adaugareMedic",true);

        return medicArrayList;
    }

    public static void  eliminareMedic(){
//
//        Scanner scanner1 = new Scanner(System.in);
//        MedicService.afisareListMedici(medicArrayList);
//        System.out.println();
//        System.out.println("Introduceti numele medicului pe care doriti sa il eliminati :");
//        String nume = scanner1.nextLine();
//        int index = -1;
//        int ok = 1;
//        Iterator<Medic> iterator = medicArrayList.iterator();
//        int indexul = 0;
//        while (iterator.hasNext()) {
//            Medic medic = iterator.next();
//            if(medic.getNume().equals(nume)){
//                medicArrayList.remove(indexul);
//                index = indexul;
//                break;
//            }
//            indexul+=1;
//        }
//        if(index == -1){
//            ok = 0;
//        }
//        if(ok == 0){
//            System.out.println("Nu s-a gasit acest medic!");
//        }

        System.out.println("Introdceti id-ul medicului pe care doriti sa il eliminati :");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        MedicRepository medicRepository = new MedicRepository();
        medicRepository.deleteMedic(id);

        //afisez in istoric
        WriteService.writeIstoric("eliminareMedic",true);

//        return medicArrayList;
    }

    public static void editareTuraMedic(){

        System.out.println("Introduceti id-ul medicului caruia doriti sa ii modificati tura :");
        Scanner scanner =  new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Introduceti noua tura :");
        int tura = scanner.nextInt();

        MedicRepository medicRepository = new MedicRepository();
        medicRepository.updateTuraAge(id,tura);

        //afisez in istoric
        WriteService.writeIstoric("editareTuraMedic",true);

    }
}
