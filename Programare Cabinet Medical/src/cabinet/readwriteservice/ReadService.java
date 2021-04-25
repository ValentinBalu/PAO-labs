package cabinet.readwriteservice;
import cabinet.*;
import cabinet.exceptions.FileWritingException;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;


public class ReadService {

    //functie pentru a citi datele unui client din fisier
    public static Client[] readClient(Client[] listaClienti) throws FileWritingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/ClientIntrare.txt"))) {
            String line = buffer.readLine();
            ArrayList<Client> clienti = new ArrayList<>();
            while (line != null) {
                String[] lines = line.split(",");
                Client client = new Client();
                client.setNume(lines[0]);
                client.setCnp(lines[1]);
                client.setVarsta(Integer.parseInt(lines[2]));
                client.setSex(lines[3].toCharArray()[0]);

                String[] simptome = new String[lines.length - 4];
                int x = 0;
                for (int j = 4; j < lines.length; j++) {
                    simptome[x] = lines[j];
                    x += 1;
                }

                client.setSimptome(simptome);

                //dupa ce ii setez atributele, il adaug in lista
                clienti.add(client);

                // go to next line
                line = buffer.readLine();
            }
            for (Client client : clienti) {
                listaClienti = ClientService.addClient(listaClienti, client);
            }
            return listaClienti;
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingBufferedWriter method", e);
        }
    }

    //functie pentru a citi datele unui medic din fisier
    public static ArrayList<Medic> readMedic(ArrayList<Medic> medicArrayList) throws FileWritingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/MedicIntrare.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                String[] lines = line.split(",");
                Medic medic = new Medic();
                medic.setNume(lines[0]);
                medic.setVarsta(Integer.parseInt(lines[1]));
                medic.setSpecialitate(lines[2]);
                medic.setTura(Integer.parseInt(lines[3]));

                //dupa ce ii setez atributele, il adaug in lista
                medicArrayList.add(medic);

                // go to next line
                line = buffer.readLine();
            }
            return medicArrayList;
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingBufferedWriter method", e);
        }
    }

    //functie pentru a citi datele unui oftalmolog din fisier
    public static ArrayList<Medic> readMedicOftalmolog(ArrayList<Medic> medicArrayList) throws FileWritingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/OftalmologIntrare.txt"))) {
            String line = buffer.readLine();
            while (line != null) {
                String[] lines = line.split(",");
                Oftalmolog oftalmolog = new Oftalmolog();
                oftalmolog.setNume(lines[0]);
                oftalmolog.setVarsta(Integer.parseInt(lines[1]));
                oftalmolog.setSpecialitate(lines[2]);
                oftalmolog.setTura(Integer.parseInt(lines[3]));
                oftalmolog.setOrganVizat(lines[4]);
                oftalmolog.setDurataConsultatie(Integer.parseInt(lines[5]));
                oftalmolog.setChirurgie(Boolean.parseBoolean(lines[6]));

                //dupa ce ii setez atributele, il adaug in lista
                medicArrayList.add(oftalmolog);

                // go to next line
                line = buffer.readLine();
            }
            return medicArrayList;
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingBufferedWriter method", e);
        }
    }

    //functie pentru a citi datele unei programari din fisier
    public static Map<Integer, Programare> readProgramare(Map<Integer, Programare> programariHashMap) throws FileWritingException {
        try (BufferedReader buffer = new BufferedReader(new FileReader("src/cabinet/files/ProgramareIntrare.txt"))) {
            String line = buffer.readLine();

            //iau ultima cheie
            Integer k = 0;
            for (Map.Entry<Integer, Programare> pair : programariHashMap.entrySet())
                k = pair.getKey();

            while (line != null) {
                String[] lines = line.split(",");
                Programare programare = new Programare();
                programare.setNumeClient(lines[0]);
                programare.setDataProgramare(lines[1]);
                programare.setOraProgramare(lines[2]);
                programare.setSpecialitatea(lines[3]);
                programare.setNumeMedic(lines[4]);
                programare.setCost(Double.parseDouble(lines[5]));

                //dupa ce ii setez atributele, il adaug in hashmap crescand de fiecare data cheia
                k += 1;
                programariHashMap.put(k, programare);

                // go to next line
                line = buffer.readLine();
            }
            return programariHashMap;
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingBufferedWriter method", e);
        }
    }
}



