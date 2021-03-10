package singletons;

public class Singleton1 {
    // static variable
    private static Singleton1 instance = null;

    // private constructor restricted to this class itself
    private Singleton1() {
    }

    // static method to create instance of Singleton class
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }

        return instance;
    }
}
class Main {
    public static void main(String[] args) {
        Singleton1 x = Singleton1.getInstance();
        Singleton1 y = Singleton1.getInstance();

        System.out.println(x == y);
    }
}


