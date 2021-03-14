package tema.exercitiul1;

public class Area {
    private CandyBag candybag;

    private int number;

    private String street;

    public Area() {
    }

    public Area(CandyBag candybag,int number,String street) {
        this.candybag = candybag;
        this.number = number;
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void printAddress(){
        System.out.println("The Area nr "+this.getNumber()+" is located on the street "+this.getStreet());
        System.out.println("The variety of boxes is :");

        for(CandyBox c : candybag.getCandyBox()){
            System.out.println(c.toString()+" ");
        }
    }
    public static void main(String[] args){
        Merci m1 = new Merci("ciocolata","englezesc",12);
        Merci m2 = new Merci("banane","arabesc",3.2);
        Merci m3 = new Merci("capsuni","italienesc",5.6);
        Merci[] m = new Merci[]{m1,m2,m3};

        Lindt l1 = new Lindt("afine","romanesti",2.3,5.1,12.7);
        Lindt l2 = new Lindt("zmeura","bulgaresti",7.4,12.6,8.9);
        Lindt[] l = new Lindt[]{l1,l2};

        Milka mi1 = new Milka("cacao" , "danez",9.8,17.1);
        Milka[] mis = new Milka[]{mi1};

        CandyBox[] candyBox = new CandyBox[]{m1,m2,m3,l1,l2,mi1};

        CandyBag candybag = new CandyBag(candyBox);

        Area area = new Area(candybag,78,"Str. Ion Bratianu");

        area.printAddress();

    }
}
