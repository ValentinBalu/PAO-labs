package examples;

public class Exp4 {
}
class Test4 {
    public static void main(String args[]) {
        System.out.println(fun());
    }
    static int fun() {
        //Modifier 'static' not allowed here
        //static int x= 0;
        //return ++x;
        return 1; //ca sa nu aiba eroare
    }
}