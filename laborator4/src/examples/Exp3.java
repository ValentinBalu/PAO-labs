package examples;

public class Exp3 {
}
class Base3 {
    public static void show() {
        System.out.println("Base::show() called");
    }
}

class Derived3 extends Base3 {
    public static void show() {
        System.out.println("Derived::show() called");
    }
}

class Main3 {
    public static void main(String[] args) {
        Base3 b = new Derived3();;
        b.show();

        Derived3 d = new Derived3();
        d.show();
    }
}