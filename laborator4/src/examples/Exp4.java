package examples;

public class Exp4 {
}

class Base4 {
    public void print() {
        System.out.println("Base");
    }
}
class Derived4 extends Base4 {
    public void print() {
        System.out.println("Derived");
    }
}
class Main4{
    public static void doPrint( Base4 o ) {
        o.print();
    }
    public static void main(String[] args) {
        Base4 x = new Base4();
        Base4 y = new Derived4();
        Derived4 z = new Derived4();
        doPrint(x);
        doPrint(y);
        doPrint(z);
    }
}

