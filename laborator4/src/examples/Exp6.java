package examples;

public class Exp6 {
}
class Base6
{
    private int data;
    public Base6()
    {
        data = 5;
    }
    public int getData()
    {
        return this.data;
    }
}
class Derived6 extends Base6
{
    private int data;
    public Derived6()
    {
        data = 6;
    }
    //nu putem sa o facem private din public
//    private int getData()
//    {
//        return data;
//    }
    public static void main(String[] args)
    {
        Derived6 myData = new Derived6();
        System.out.println(myData.getData());
    }
}