package singletons;

public class Singleton2 {
    // private instance
    private static Singleton2 instance;

    // private constructor
    private Singleton2() {
    }

    //method to return instance of class
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

class Main2 {
    public static void main(String[] args) {
        Singleton2 x = Singleton2.getInstance();
        Singleton2 y = Singleton2.getInstance();

        System.out.println(x == y);
    }
}