package cabinet;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;


public class MedicService {
    public static void afisareMeniu(){
        System.out.println("Lista serviciilor pentru categoria medic : ");
        System.out.println("1.Afisare Lista tuturor Medicilor");
        System.out.println("2.Afisare Lista Medici cu o anumita specialitate");
        System.out.println("3.Adaugare Medic");
        System.out.println("4.Eliminare Medic");
    }
    public static void afisareListMedici(Medic[] ListaMedici){
        System.out.println("Lista tuturor Medicilor este :");
        for (Medic medic : ListaMedici){
            System.out.println(medic.toString());
        }
    }
    public static void afisareListaMediciSpecialitate(Medic[] ListaMedici, String specialitate){
        System.out.println("Lista Medicilor cu specialitatea "+specialitate +" :");
        for(Medic medic : ListaMedici){
            if(medic.getSpecialitate().equals(specialitate)){
                System.out.println(medic.toString());
            }
        }
    }
    public static Medic[] addMedic(Medic[] ListaMedici,Medic medic){
        Medic[] newListaMedici = new Medic[ListaMedici.length+1];
        for(int i =0;i <ListaMedici.length;i++)
            newListaMedici[i] = ListaMedici[i];
        newListaMedici[ListaMedici.length] = medic;
        return newListaMedici;
    }
    public static Medic[] adaugareMedic(Medic[]ListaMedici){
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
        Medic[] nouListaMedici = addMedic(ListaMedici,medic);
        return nouListaMedici;
    }
    public static Medic[] eliminareMedic(Medic[]ListaMedici){
        Medic[] nouListaMedici = new Medic[ListaMedici.length-1];
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Introduceti numele medicului pe care doriti sa il eliminati :");
        String nume = scanner1.nextLine();
        System.out.println(nume);
        int index = 0;
        int ok = 1;
        for(int i=0 ;i < ListaMedici.length;i++){
            if(ListaMedici[i].getNume().equals(nume)){
                index = i;
                break;
            }
            ok = 0;
        }
        if(ok == 0){
            System.out.println("Nu s-a gasit acest medic!");
            return ListaMedici;
        }else {
            for (int i = 0, j = 0; i < ListaMedici.length; i++) {
                if (i != index) {
                    nouListaMedici[j++] = ListaMedici[i];
                }
            }
            System.out.println(nume);
            return nouListaMedici;
        }
    }
}
