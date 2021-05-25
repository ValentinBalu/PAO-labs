package cabinet;

import cabinet.exceptions.FileWritingException;
import cabinet.readwriteservice.WriteService;
import cabinet.repository.ClientRepository;
import com.sun.jdi.event.ClassUnloadEvent;

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
        System.out.println("6.Eliminare Client");
    }

    public static void afisareListaClienti(Client[] listaClienti) {
        System.out.println("Lista tuturor Clientilor este :");
        for (Client client : listaClienti){
            System.out.println(client.toString());
        }

        //afisez in istoric
        WriteService.writeIstoric("afisareListaClienti",true);
    }

    public static void afisareListaCopii(Client[] listaClienti){
            System.out.println("Lista Clientilor Copii : ");
        for (Client client : listaClienti){
            if(client.getClass().equals(Copil.class)){
                System.out.println(client.toString());
            }
        }

        //afisez in istoric
        WriteService.writeIstoric("afisareListaCopii",true);
    }

    public static void afisareListaAdulti(Client[] listaClienti){
        System.out.println("Lista Clientilor Adulti : ");
        for (Client client : listaClienti){
            if(client.getClass().equals(Adult.class)){
                System.out.println(client.toString());
            }
        }

        //afisez in istoric
        WriteService.writeIstoric("afisareListaAdulti",true);
    }

    public static Client[] addClient(Client[] listaClienti,Client client){
        Client[] newListaClienti = new Client[listaClienti.length+1];
        for(int i =0;i <listaClienti.length;i++)
            newListaClienti[i] = listaClienti[i];
        newListaClienti[listaClienti.length] = client;
        return newListaClienti;
    }

    public static Client[] adaugareClient(Client[]listaClienti){
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
        Client[] nouListaCleinti= addClient(listaClienti,client);

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.insertClient(client);

        //afisez in istoric
        WriteService.writeIstoric("adaugareClienti",true);

        return nouListaCleinti;
    }

    public static void editareVarstaClient(){
//        System.out.println("Introduceti CNP-ul persoanei careia doriti sa ii modificati varsta :");
//        Scanner scanner =  new Scanner(System.in);
//        String cnp = scanner.nextLine();
//        for(Client client : listaClienti){
//            if(client.getCnp().equals(cnp)){
//                System.out.println("Introduceti noua varsta :");
//                int varsta = scanner.nextInt();
//                client.setVarsta(varsta);
//                break;
//            }
//        }
        System.out.println("Introduceti id-ul persoanei careia doriti sa ii modificati varsta :");
        Scanner scanner =  new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Introduceti noua varsta :");
        int varsta = scanner.nextInt();

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.updateClientAge(id,varsta);

        //afisez in istoric
        WriteService.writeIstoric("editareVarstaClient",true);

//        return listaClienti;
    }

    public static void eliminareClient(){
        System.out.println("Introdceti id-ul clientului pe care doriti sa il eliminati :");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.deleteClient(id);
    }
}
