package examples;

public class Bird extends Animal{
    public int noOfLegs = 2;
    public Bird(String sound){
        super(sound);
    }
    @Override
    public void printName() {
        System.out.println("Birds have no name!");
    }

    @Override
    public void move() {
        System.out.println("I can fly!");
    }

    @Override
    public int getNoOfLegs() {
        return noOfLegs;
    }

    @Override
    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    public int getNoOfLegsFromParent() {
        return super.getNoOfLegs();
    }
}
