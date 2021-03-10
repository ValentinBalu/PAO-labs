package examples;

public class Exp7 {
}
class Complex {
    private double re, im;
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
    Complex(Complex c) {
        re = c.re;
        im = c.im;
    }
    //daca definesc copy constrcutor trebuie si constr neparam
    Complex(){
        this.re=0.0;
        this.im=0.0;
    }
}
class Example7 {
    public static void main(String[] args) {
        Complex c1 = new Complex();
        Complex c2 = new Complex(c1);
        System.out.println(c2);
    }
}
