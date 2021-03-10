package tema.exercitiul1;
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
        return "The "+origin+" "+flavour+" has volume of "+getVolume();
    }
    public static void main(String[] args){
        Merci m = new Merci("cicolata","italic",21);
        System.out.println(m.toString());
    }
}
