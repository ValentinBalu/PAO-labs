package examples;

public class Exp5 {
}
class Base5 {
    public void foo() { System.out.println("Base"); }
}
class Derived5 extends Base5 {
    //nu putem modifica din public in private
    //private void foo() { System.out.println("Derived"); }
}
class Main5 {
    public static void main(String args[]) {
        Base5 b = new Derived5();
        b.foo();
    }
}
