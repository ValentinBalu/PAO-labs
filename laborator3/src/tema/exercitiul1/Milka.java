package tema.exercitiul1;
//b
public class Milka extends CandyBox{
    private double radius;

    private double height;

    public Milka() {
    }

    public Milka(String flavour, String origin, double radius,double height) {
        super(flavour, origin);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return 2*this.getRadius()*this.getRadius()*3.14;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public String toString(){
        return "The "+origin+" "+flavour+" has volume of "+getVolume();
    }
    public static void main(String[] args){
        Milka mi = new Milka("banane","frantuzesc",4.6,8.12);
        System.out.println(mi.toString());
    }
}
