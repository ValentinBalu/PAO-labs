package tema.exercitiul1;

public class CandyBag {
    private Merci[] mercis;

    private Lindt[] lindts;

    private Milka[] milkas;

    public Merci[] getMercis() {
        return mercis;
    }

    public CandyBag() {
    }

    public CandyBag(Merci[] mercis,Lindt[] lindts,Milka[] milkas) {
        this.mercis = mercis;
        this.lindts=lindts;
        this.milkas=milkas;
    }

    public void setMercis(Merci[] mercis) {
        this.mercis = mercis;
    }

    public Lindt[] getLindts() {
        return lindts;
    }

    public void setLindts(Lindt[] lindts) {
        this.lindts = lindts;
    }

    public Milka[] getMilkas() {
        return milkas;
    }

    public void setMilkas(Milka[] milkas) {
        this.milkas = milkas;
    }
}
