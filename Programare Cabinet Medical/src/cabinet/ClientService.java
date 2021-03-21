package cabinet;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class ClientService {
    public static void afisareMeniu(){
        System.out.println("Lista serviciilor pentru categoria client : ");
        System.out.println("1.Afisare Lista tuturor Clientilor");
        System.out.println("2.Afisare Lista Clienti Copii");
        System.out.println("3.Afisare Lista Clienti Adulti");
        System.out.println("4.Adaugare Client");
        System.out.println("5.Editare varsta Client");
    }
    public static void afisareListaClienti(Client[] ListaClienti){
        System.out.println("Lista tuturor Clientilor este :");
        for (Client client : ListaClienti){
            System.out.println(client.toString());
        }
    }
    public static void afisareListaCopii(Client[] ListaClienti){
            System.out.println("Lista Clientilor Copii : ");
        for (Client client : ListaClienti){
            if(client.getClass().equals(Copil.class)){
                System.out.println(client.toString());
            }
        }
    }
    public static void afisareListaAdulti(Client[] ListaClienti){
        System.out.println("Lista Clientilor Adulti : ");
        for (Client client : ListaClienti){
            if(client.getClass().equals(Adult.class)){
                System.out.println(client.toString());
            }
        }
    }
    public static Client[] addClient(Client[] ListaClienti,Client client){
        Client[] newListaClienti = new Client[ListaClienti.length+1];
        for(int i =0;i <ListaClienti.length;i++)
            newListaClienti[i] = ListaClienti[i];
        newListaClienti[ListaClienti.length] = client;
        return newListaClienti;
    }
    public static Client[] adaugareClient(Client[]ListClienti){
        System.out.println("Adaugare Client :");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Intrduceti numele :");
        String nume = scanner.nextLine();
        System.out.println("Introduceti CNP :");
        String cnp = scanner.next();
        System.out.println("Introduceti varsta : ");
        int varsta = scanner.nextInt();
        System.out.println("Introduceti sex :");
        String sex = scanner.next();
        char sex1 = sex.charAt(0);
        System.out.println("Introduceti numarul de simptome :");
        int nrSimptome = scanner.nextInt();
        System.out.println("Introduceti simptome :");
        String[] simptome = new String[nrSimptome];
        for(int i =0 ;i<nrSimptome;i++){
            String simptom = scanner.next();
            simptome[i] = simptom;
        }
        Client client = new Client(nume,cnp,varsta,sex1,simptome);
        System.out.println(client.toString());
        //adaug clientul
        Client[] nouListaCleinti= addClient(ListClienti,client);
        return nouListaCleinti;
    }
    public static Client[] editareVarstaClient(Client[]ListaClienti){
        System.out.println("Introduceti CNP-ul persoanei careia doriti sa ii modificati varsta :");
        Scanner scanner =  new Scanner(System.in);
        String cnp = scanner.nextLine();
        for(Client client : ListaClienti){
            if(client.getCnp().equals(cnp)){
                System.out.println("Introduceti noua varsta :");
                int varsta = scanner.nextInt();
                client.setVarsta(varsta);
                break;
            }
        }
        return ListaClienti;
    }
}