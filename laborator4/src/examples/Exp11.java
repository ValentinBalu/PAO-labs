package examples;

public class Exp11 {
}
class Base11
{
    public static String s = " Super Class ";
    public Base11()
    {
        System.out.printf("1");
    }
}
class Derived11 extends Base11
{
    public Derived11()
    {
        System.out.printf("2");
        //nu pot sa apelez super a doua oara
        //super();
    }

    public static void main(String[] args)
    {
        Derived11 obj = new Derived11();
        System.out.printf(s);
    }
}