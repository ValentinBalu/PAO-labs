package examples;

public class Exp5 {
}
class Point {  protected int x, y;
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    //daca ai definit constructor cu param trebuie si cel fara
    public Point(){
        this.x=0;
        this.y=0;
    }
}
class Main5 {
    public static void main(String args[])
    {
        Point p = new Point();
        System.out.println("x = " + p.x + ", y = " + p.y);
    }
}