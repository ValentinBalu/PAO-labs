package examples;

public class Exp2 {
}
class Base2 {
    final public void show() {
        System.out.println("Base::show() called"); }
}
class Derived2 extends Base2 {
    //e final in base, nu o pot suprascrie in derivata
//    public void show() {
//        System.out.println("Derived::show() called");
//    }
}
class Main2 {
    public static void main(String[] args) {
        Base2 b = new Derived2();;
        b.show();
    }
}

