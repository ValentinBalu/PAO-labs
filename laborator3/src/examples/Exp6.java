package examples;

public class Exp6 {
}
class Base {
    protected void foo() {}
}
class Derived extends Base {
    //'foo()' in 'examples.Derived' clashes with 'foo()' in 'examples.Base';
    // attempting to assign weaker access privileges ('package-private'); was 'protected'
    //void foo() {}
}
class Example6 {
    public static void main(String args[]) {
        Derived d = new Derived();
        d.foo();
    }
}
