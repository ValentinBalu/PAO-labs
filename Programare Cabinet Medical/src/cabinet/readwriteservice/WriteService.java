package cabinet.readwriteservice;
import cabinet.Client;
import cabinet.Medic;
import cabinet.Oftalmolog;
import cabinet.Programare;
import cabinet.exceptions.FileReadingException;
import cabinet.exceptions.FileWritingException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class WriteService {
    //functie pentru a afisa datele unui client
    public static void writeClient(Client[] listaClienti,boolean append) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/ClientIesire.txt",append))) {
            for (Client client : listaClienti) {
                String text = client.toString() + '\n';
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingBufferedWriter method", e);
        }
    }
    //functie pentru a afisa datele unui medic
    public static void writeMedic(ArrayList<Medic> medicArrayList, boolean append) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/MedicIesire.txt",append))) {
            for (Medic medic : medicArrayList) {
                String text = medic.toString() + '\n';
                buffer.write(text);
            }
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingBufferedWriter method", e);
        }
    }

    //functie pentru a afisa datele unui oftalmolog
    public static void writeMedicOftalmolog(ArrayList<Medic> medicArrayList, boolean append) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/OftalmologIesire.txt",append))) {
            for (Medic medic : medicArrayList) {
                if(medic.getClass() == Oftalmolog.class) {
                    String text = medic.toString() + '\n';
                    buffer.write(text);
                }
            }
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingBufferedWriter method", e);
        }
    }

    //functie pentru a afisa datele unei programari
    public static void writeProgramare(Map<Integer, Programare>programareMap, boolean append) throws FileWritingException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/ProgramareIesire.txt",append))) {
            for(Map.Entry<Integer,Programare> pair : programareMap.entrySet()){

                    String text = "programarea "+ pair.getKey() + " : " + pair.getValue().toString() + '\n';
                    buffer.write(text);
                }
        } catch (IOException e) {
            throw new FileWritingException("Something went wrong in writeUsingBufferedWriter method", e);
        }
    }

    //functie pentru a scrie in fisierul Istoric.txt de fiecare data cand se executa o comanda din etapa 1
    public static void writeIstoric(String text, boolean append) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter("src/cabinet/files/Istoric.txt",append))) {
            //iau timestamp-ul curent

            //initializez obiect de tip Date
            Date data = new Date();
            //iau timpul in milisecunde
            long time = data.getTime();
            //creez timestamp-ul
            Timestamp ts = new Timestamp(time);

            String timestamp = ts.toString();

            String mesaj = text + "," + timestamp + '\n';
            buffer.write(mesaj);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
