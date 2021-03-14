package tema.exercitiul1;

import java.util.Objects;

//c
public class Merci extends CandyBox{
    private double length;

    public Merci(){
    }
    public Merci(String flavour, String origin,double length){
        super(flavour,origin);
        this.length=length;
    }

    @Override
    public double getVolume() {
        return this.getLength()*this.getLength()*this.getLength();
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public String toString(){
        return "This is a box of Merci. Its origin is "+origin+" with the flavour of "+flavour+" and it has a volume of "+getVolume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Merci)) return false;
        Merci merci = (Merci) o;
        return Double.compare(merci.getLength(), getLength()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLength());
    }

    public static void main(String[] args){
        Merci m = new Merci("cicolata","italic",21);
        System.out.println(m.toString());

        Merci mTest = new Merci("capsuni","frantuzesc",21);
        System.out.println(m.equals(mTest));
    }
}
