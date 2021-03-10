package tema.exercitiul1;
//ex1
public abstract class CandyBox {
    protected String flavour;

    protected String origin;

    //a
    public CandyBox(){
    }

    //b
    public CandyBox(String flavour, String origin){
        this.flavour=flavour;
        this.origin=origin;
    }
    //c
    public abstract double getVolume();
    //d
    public String toString(){
        return "CandyBox("+
                "flavour "+flavour+
                ", origin "+ origin +'\''+
                "}";
    }
//
//    public String getOrigin() {
//        return origin;
//    }
//
//    public void setOrigin(String origin) {
//        this.origin = origin;
//    }
//
//    public String getFlavour() {
//        return flavour;
//    }
//
//    public void setFlavour(String flavour) {
//        this.flavour = flavour;
//    }
}
