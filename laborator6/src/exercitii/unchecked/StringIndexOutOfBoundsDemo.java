package exercitii.unchecked;

public class StringIndexOutOfBoundsDemo {
    //incerc sa accesez ceva din afara stringului
    public static void main(String[] args) {
        String a = "ana are mere";
        char c  = a.charAt(25);

        System.out.println(c);
    }
}
