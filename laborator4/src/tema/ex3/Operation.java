package tema.ex3;

public class Operation implements Minus,Plus,Mult,Div{

    private float numar;

    public Operation(){}

    public Operation(float numar){
        this.numar = numar;
    }

    public float getNumar() {
        return numar;
    }

    @Override
    public void impartire(float numar) {
        this.numar /= numar;
    }

    @Override
    public void scadere(float numar) {
        this.numar -= numar;
    }

    @Override
    public void inmultire(float numar) {
        this.numar *= numar;
    }

    @Override
    public void adunare(float numar) {
        this.numar += numar;
    }

    public static void main(String[] args){
        Operation op = new Operation(13.2f);

        op.adunare(45.6f);
        System.out.println("Dupa adunare, numarul este : "+op.getNumar());

        op.scadere(18.5f);
        System.out.println("Dupa scadere, numarul este : "+op.getNumar());

        op.inmultire(3.7f);
        System.out.println("Dupa inmultire, numarul este : "+op.getNumar());

        op.impartire(2.16f);
        System.out.println("Dupa impartire, numarul este : "+op.getNumar());

    }
}
