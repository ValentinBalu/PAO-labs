package tema.exercitiul1;
//a
public class Lindt extends CandyBox{

    private double length;

    private double width;

    private double height;

    public Lindt() {
    }

    public Lindt(String flavour, String origin, double length,double width,double height) {
        super(flavour, origin);
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return this.getHeight()*this.getWidth()*this.getLength();
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public String toString(){
        return "The "+origin+" "+flavour+" has volume of "+getVolume();
    }
    public static void main(String[] args){
        Lindt l = new Lindt("capsuni","german",12,5.6,3.1);
        System.out.println(l.toString());
    }
}
