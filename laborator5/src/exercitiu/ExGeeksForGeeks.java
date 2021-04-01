package exercitiu;

public class ExGeeksForGeeks {
}
abstract class demo
{
    public int a;
    demo()
    {
        a = 10;
    }

    abstract public void set();
    //illegal combinations of modifiers
    //abstract final public void get();

}

class Test extends demo
{

    public void set(int a)
    {
        this.a = a;
    }

    final public void get()
    {
        System.out.println("a = " + a);
    }

    public static void main(String[] args)
    {
        Test obj = new Test();
        obj.set(20);
        obj.get();
    }

    @Override
    public void set() {
        System.out.println("Trebuie rescrisa");
    }
}