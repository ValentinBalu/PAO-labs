package constructors;

class Base{
    Base(){
        System.out.println("base constructor");
    }
}

class Derived extends Base{
    Derived(){
        System.out.println("derived constructor");
    }
}

class Base2 {
    int x;

    Base2() {
        System.out.println("Base2 no params");
    }

    Base2(int x) {
        System.out.println("Base2 with params");
        this.x = x;
    }
}

class Derived2 extends Base2 {
    int y, z;

    Derived2() {
        System.out.println("Derived2 no params");
        display();
    }

    Derived2(int x, int y) {
        super(x);
        System.out.println("Derived2 with 2 params");
        this.y = y;
    }

    Derived2(int x, int y, int z) {
        this(x, y); // constructor chaining
        System.out.println("Derived2 with 3 params");
        this.z = z;
    }

    void display() {
        System.out.println("x = " + x + ", y = " + y);
    }
}

public class PlayWithConstructors {
    public static void main(String[] args)
    {
        Derived d = new Derived();

        new Derived2();

        Derived2 d2 = new Derived2(10, 20);
        d2.display();

        new Derived2(10, 20, 30).display();
    }
}
