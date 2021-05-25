package com.company;

import cabinet.*;
import cabinet.config.DatabaseConfiguration;
import cabinet.exceptions.FileWritingException;
import cabinet.readwriteservice.ReadService;
import cabinet.readwriteservice.WriteService;
import cabinet.repository.ClientRepository;
import cabinet.repository.MedicRepository;
import cabinet.repository.OftalmologRepository;
import cabinet.repository.ProgramareRepository;

import javax.sound.sampled.Port;
import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;
import java.lang.ref.Cleaner;
import java.util.*;

public class Main {

    public static void medicService(ArrayList<Medic> medicArrayList){
        MedicService.afisareMeniu();
        Scanner scannerul = new Scanner(System.in);
        System.out.println();
        MedicRepository medicRepository = new MedicRepository();

        System.out.println("Alegeti o optiune :");
        int op = scannerul.nextInt();
        if(op==1){
            //MedicService.afisareListMedici(medicArrayList);

            ArrayList<Medic> medics = medicRepository.getAllMedics();
            for (Medic medic : medics) {
                System.out.println(medic.toString());
            }
        }else if(op==2){
            System.out.println("Introduceti denumirea specialitatii : ");
            String specialitatea = scannerul.next();
            MedicService.afisareListaMediciSpecialitate(medicArrayList,specialitatea);
        }else if (op == 3){
            medicArrayList = MedicService.adaugareMedic(medicArrayList);
            MedicService.afisareListMedici(medicArrayList);
        }else if(op == 4) {
//            medicArrayList = MedicService.eliminareMedic(medicArrayList);
//            MedicService.afisareListMedici(medicArrayList);
            MedicService.eliminareMedic();
        }else if (op==5) {
            MedicService.editareTuraMedic();
        }else {
            System.out.println("Introduceti o optiune valida!");
            medicService(medicArrayList);
        }
        System.out.println();

    }

    public static void oftalmologService(){
        OftalmologService.afisareMeniu();
        Scanner scannerul = new Scanner(System.in);
        System.out.println();
        System.out.println("Alegeti o optiune :");

        int op = scannerul.nextInt();
        OftalmologRepository oftalmologRepository = new OftalmologRepository();

        if(op==1){
           ArrayList<Oftalmolog> oftalmologs = oftalmologRepository.getAllOfts();
            for (Oftalmolog oftalmolog : oftalmologs) {
                System.out.println(oftalmolog.toString());
            }
        }else if(op==2){
            OftalmologService.adaugareOftalmolog();
        }else if (op == 3){
            OftalmologService.editareDurataConsultatieOft();
        }else if(op == 4) {
            OftalmologService.eliminareOftalmolog();
        } else{
            System.out.println("Introduceti o optiune valida!");
        }
        System.out.println();

    }

    public static void clientService(Client[] listaClienti){
        ClientService.afisareMeniu();
        Scanner scannerul = new Scanner(System.in);
        System.out.println();
        System.out.println("Alegeti o optiune :");
        int op = scannerul.nextInt();
        ClientRepository clientRepository = new ClientRepository();
        if(op==1){
            //ClientService.afisareListaClienti(listaClienti);
            ArrayList<Client> clients = clientRepository.getAllClients();
            for (Client client : clients) {
                System.out.println(client.toString());
            }

        }else if(op==2){
            ClientService.afisareListaCopii(listaClienti);
        }else if (op == 3){
            ClientService.afisareListaAdulti(listaClienti);
        }else if(op == 4) {
            listaClienti = ClientService.adaugareClient(listaClienti);
            //ClientService.afisareListaClienti(listaClienti);
        }else if(op == 5) {
            //listaClienti = ClientService.editareVarstaClient(listaClienti);
            //ClientService.afisareListaClienti(listaClienti);
            ClientService.editareVarstaClient();
        }else if (op==6) {
            ClientService.eliminareClient();
        }else
        {
            System.out.println("Introduceti o optiune valida!");
            clientService(listaClienti);
        }
        System.out.println();

    }

    public static void programareService(Map<Integer, Programare>programariHashMap){
        ProgramareService.afisareMeniu();
        Scanner scannerul = new Scanner(System.in);
        System.out.println();
        ProgramareRepository programareRepository = new ProgramareRepository();

        System.out.println("Alegeti o optiune :");
        int op = scannerul.nextInt();
        if(op==1){
            //ProgramareService.afisareListaProgramari(programariHashMap);

            ArrayList<Programare> programares = programareRepository.getAllProgs();
            for (Programare programare : programares) {
                System.out.println(programare);
            }

        }else if(op==2){
            programariHashMap = ProgramareService.adaugareProgramare(programariHashMap);
            ProgramareService.afisareListaProgramari(programariHashMap);
        }else if (op == 3){
//            programariHashMap = ProgramareService.editareProgramare(programariHashMap);
//            ProgramareService.afisareListaProgramari(programariHashMap);
            ProgramareService.editareProgramare();
        }else if(op == 4) {
//            programariHashMap = ProgramareService.eliminareProgramare(programariHashMap);
//            ProgramareService.afisareListaProgramari(programariHashMap);
            ProgramareService.anulareProgramare();
        } else{
            System.out.println("Introduceti o optiune valida!");
            programareService(programariHashMap);
        }
        System.out.println();
    }

    public static int optiune(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ce servicii doriti sa utilizati?");
        System.out.println("1.Servicii pentru Medici");
        System.out.println("2.Servicii pentru Clienti");
        System.out.println("3.Servicii pentru Programari");
        System.out.println("4.Servicii pentru Oftalmologi");
        System.out.println("Selectati optiunea :");
        int op = scanner.nextInt();
        return op;
    }

    public static void main(String[] args) throws FileWritingException {
        System.out.println("Hello from proiect, Valentine!");
        Client client1 = new Client("Ion Popescu","5001122345678",34,'M',new String[]{"nas indufndat" , "tuse productiva"});
        //System.out.println(client1.toString());

        Adult adult1 = new Adult("Viorel Georgescu","5123456781345",56,'M',new String[]{"maini reci","nas umed"},new String[]{"diabet","pancreatita"},new String[]{"Xyzal"},Boolean.TRUE);
        //System.out.println(adult1.toString());

        Copil copil1 = new Copil("Ana Balutoiu","6987612786543",9,'F',new String[]{"febra","tuse"},new String[]{"Tetramune"," vaccin antipolio"});
        //System.out.println(copil1.toString());

        Medic medic1 = new Medic("Ioana Manoiu",56,"ORL",2);
        //System.out.println(medic1.toString());

        Oftalmolog oftalmolog1 = new Oftalmolog("Andrei Zuhalcescu", 45 , "oftalmologie",2,"ochi",45,true);
        //System.out.println(oftalmolog1.toString());

        Cardiolog cardiolog1 = new Cardiolog("Marius Zaharia",61,"cardiologie",1,"inima",60, (short)198);
        //System.out.println(cardiolog1.toString());

        Cardiolog cardiolog2 = new Cardiolog("Lavinia Bustean",41 , "cardiologie",2,"inima",60,(short)171);
        //System.out.println(cardiolog2.toString());

        Programare programare1 = new Programare("Cristian Popescu","12/3/2021","15:23","cardiologie","Marius Zaharia",150,1,1);
        //System.out.println(programare1.toString());

        Programare programare2 = new Programare("Ana Balutoiu","29/04/2021","14:50","oftalmologie","Andrei Zuhalcescu",200,1,1);
        //System.out.println(programare2.toString());

        //CLIENT

        //dupa ce formez lista de clienti intializati in main, ii adauga si pe cei din fisier
        Client[] listaClienti = new Client[]{client1,copil1,adult1};
        listaClienti = ReadService.readClient(listaClienti);


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

        //scriu datele clientilor in fisier
        WriteService.writeClient(listaClienti,false);

        //MEDIC

        ArrayList<Medic> medicArrayList = new ArrayList<>();
        medicArrayList.add(medic1);
        medicArrayList.add(oftalmolog1);
        medicArrayList.add(cardiolog1);
        medicArrayList.add(cardiolog2);

        //dupa ce aduag medicii initializati in main, ii adaug si pe cei din fisier
        medicArrayList = ReadService.readMedic(medicArrayList);

        //ulterior adaug si oftalmologii cititi din fisier in arraylist ul de medici
        medicArrayList = ReadService.readMedicOftalmolog(medicArrayList);


        //sortare array medici folosind collections sort
        System.out.println("Lista Medicilor inainte de sortare : ");
        for (Medic medic : medicArrayList) {
            System.out.println(medic);
        }

        System.out.println();
        Collections.sort(medicArrayList, new Comparator<Medic>() {
            @Override
            public int compare(Medic o1, Medic o2) {
                return o1.getVarsta()-o2.getVarsta();
            }
        });

        System.out.println("Lista Medicilor dupa sortare : ");
        for(Medic medic : medicArrayList){
            System.out.println(medic.toString());
        }
        System.out.println();

        //scriu datele medicilor in fisier
        WriteService.writeMedic(medicArrayList,false);

        //scriu datele oftalmologilor in fisier
        WriteService.writeMedicOftalmolog(medicArrayList,false);

        //PROGRAMARE

        Map<Integer,Programare> programariHashMap = new HashMap<>();

        programariHashMap.put(1,programare1);
        programariHashMap.put(2,programare2);

        //dupa ce adaug programarile initializate in main, le adaug si pe cele citite din fisier
        programariHashMap = ReadService.readProgramare(programariHashMap);

        //scriu datele programarilor in fisier
        WriteService.writeProgramare(programariHashMap,false);

        //Database handling

        //creating tables
        ProgramareRepository programareRepository = new ProgramareRepository();
        programareRepository.createTable();

        ClientRepository clientRepository = new ClientRepository();
        clientRepository.createTable();

        MedicRepository medicRepository = new MedicRepository();
        medicRepository.createTable();

        OftalmologRepository oftalmologRepository = new OftalmologRepository();
        oftalmologRepository.createTable();

//        clientRepository.insertClient(client1);
//        Client insertedClient = clientRepository.getClientById(1);
//        System.out.println(insertedClient.toString());

//        medicRepository.insertMedic(medic1);
//        Medic insertedMedic = medicRepository.getMedicById(1);
//        System.out.println(insertedMedic.toString());

//        oftalmologRepository.insertOftalmolog(oftalmolog1);
//        Oftalmolog insertedOftalmolog = oftalmologRepository.getOftalmologById(1);
//        System.out.println(insertedOftalmolog.toString());
//

//        programareRepository.insertProgramare(programare1);
//        Programare insertedProg1 = programareRepository.getProgramareById(1);
//        System.out.println(insertedProg1.toString());
//
//        programareRepository.insertProgramare(programare2);
//        Programare insertedProg2 = programareRepository.getProgramareById(2);
//        System.out.println(insertedProg2.toString());


        //Handling services
        int op = optiune();
        if(op==1){
            medicService(medicArrayList);
        }else if(op==2 ){
            clientService(listaClienti);
        }else if(op==3){
            programareService(programariHashMap);
        }else if(op==4){
            oftalmologService();
        }
        else{
            System.out.println("Introduceti o optiune valida");
        }



        DatabaseConfiguration.closeDatabaseConnection();

    }
}
