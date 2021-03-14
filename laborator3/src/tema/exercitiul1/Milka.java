package tema.exercitiul1;

import java.util.Objects;

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
        return "This is a box of Milka. Its origin is "+origin+" with the flavour of "+flavour+" and it has a volume of "+getVolume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Milka)) return false;
        Milka milka = (Milka) o;
        return Double.compare(milka.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }

    public static void main(String[] args){
        Milka mi = new Milka("banane","frantuzesc",4.6,8.12);
        System.out.println(mi.toString());

        Milka miTest = new Milka("zmeura","bulgaresc",4.6,14.67);
        System.out.println(mi.equals(miTest));
    }
}
