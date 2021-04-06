package practice;

import java.awt.desktop.UserSessionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ex3 {
    static User[]  users = new User[4];
    static int counter = 0;

    public static void main(String[] args){
        readUsingBufferedReader();
        System.out.println(Arrays.toString(users));
    }

    public static void readUsingBufferedReader() {
        System.out.println("readUsingBufferedReader");
        try (BufferedReader buffer = new BufferedReader(new FileReader("parole.txt"))) {
            String line = buffer.readLine();

            while (line != null) {
                String[] lines = line.split(" ");
                addUser(new User(lines[0],lines[1]));
                line = buffer.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addUser(User user){
        users[counter]=user;
        counter+=1;

    }
}
class User{
    String nume;
    String password;

    public User(String nume, String password) {
        this.nume = nume;
        this.password = password;
    }

    public User() {
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "nume='" + nume + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
