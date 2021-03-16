package examples;

public class Exp10 {
}
class Test10
{
    public Test10()
    {
        System.out.printf("1");
        new Test10(10);
        System.out.printf("5");
    }
    public Test10(int temp)
    {
        System.out.printf("2");
        new Test10(10, 20);
        System.out.printf("4");
    }
    public Test10(int data, int temp)
    {
        System.out.printf("3");

    }

    public static void main(String[] args)
    {
        Test10 obj = new Test10();

    }

}
