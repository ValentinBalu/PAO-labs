package tema.exercitiul4;

import java.util.Random;

import jdk.swing.interop.DropTargetContextWrapper;

import java.util.Random;

public class PasswordMaker {
    //a
    private static final int MAGIC_NUMBER = 13;

    //b
    private static final String MAGIC_WORD = generateString(20);

    public static String generateString(int n){

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder tmp = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(alphabet.length() * Math.random());

            tmp.append(alphabet.charAt(index));
        }

        return tmp.toString();
    }
    //c
    private String name;

    public PasswordMaker(){}

    public PasswordMaker(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //d
    public String getPassword(){

        String p1 = generateString(MAGIC_NUMBER);
        String p2 = MAGIC_WORD.substring(0,10);
        String p3 = String.valueOf(this.getName().length());
        Random rand = new Random();
        int rand1 = rand.nextInt(101);
        String p4 = String.valueOf(rand1);
        String password = new String(p1+p2+p3+p4);
        return password;
    }
    public static void main(String[] args) {
        PasswordMaker p = new PasswordMaker("Stanciulescu");
        System.out.println(p.getPassword());
    }
}
