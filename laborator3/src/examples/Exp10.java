package examples;

public class Exp10 {
}
class Gfg
{
    static int num;
    static String mystr;
    // constructor
    Gfg()
    {  num = 100;
        mystr = "Constructor";
    }
    // First Static block
    static
    {
        System.out.println("Static Block 1");
        num = 68;
        mystr = "Block1";
    }
    // Second static block
    static
    {
        System.out.println("Static Block 2");
        num = 98;
        mystr = "Block2";
    }
    public static void main(String args[])
    {
        Gfg a = new Gfg();
        System.out.println("Value of num = " + a.num);
        System.out.println("Value of mystr = " + a.mystr);
    }
}
//se executa mai intai blocurile statice apoi constructorul
//Static Block 1
//Static Block 2
//Value of num = 100
//Value of mystr = Constructor