package tema.ex1;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
//a

class OutTask implements Task{
    private String mesaj;

    public OutTask(){

    }
    public OutTask(String mesaj){
        this.mesaj = mesaj;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    @Override
    public void execute() {
        System.out.println(this.getMesaj());
    }
}

//b
class RandomTask implements Task{
    private int numar;

    public RandomTask(){
        Random rn = new Random();
        int numar = rn.nextInt();
        this.numar = numar;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    @Override
    public void execute() {
        System.out.println("The random number generated is "+this.getNumar());
    }
}

//c
class CounterOutTask implements Task{
    private static int contor = 0;
    public CounterOutTask(){
        contor+=1;
        this.execute();
    }

    public static int getContor() {
        return contor;
    }

    public static void setContor(int contor) {
        CounterOutTask.contor = contor;
    }

    @Override
    public void execute() {
        System.out.println("The contor is "+this.getContor());
    }
}
public class Container{

    public static void main(String[] args) {
        OutTask t1 = new OutTask("mesajul pentru outTask-ul 1");
        t1.execute();

        RandomTask r1 = new RandomTask();
        r1.execute();

        CounterOutTask c1 = new CounterOutTask();
        CounterOutTask c2 = new CounterOutTask();

        ArrayList<Task> tasks = new ArrayList<Task>();
        tasks.add(t1);
        tasks.add(r1);
        tasks.add(c1);
        tasks.add(c2);

        OutTask t2 = new OutTask("mesajul pentru outTask-ul 2");
        RandomTask r2 = new RandomTask();
        CounterOutTask c3 = new CounterOutTask();

        tasks.add(t2);
        tasks.add(r2);
        tasks.add(c3);

        System.out.println("Elements from Array:");
        for(Task task : tasks){
            task.execute();
        }

        tasks.remove(t1);
        tasks.remove(r1);

        System.out.println("Elements from Array:");
        for(Task task : tasks){
            task.execute();
        }
    }
}