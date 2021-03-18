package cabinet;

import java.util.Objects;

public class Cardiolog extends Medic{
    private String organVizat;

    private int durataConsultatie;

    private short operatiiReusite;

    public Cardiolog() {
    }

    public Cardiolog(String nume, int varsta, String specialitate, int tura, String organVizat,int durataConsultatie,short operatiiReusite) {
        super(nume, varsta, specialitate, tura);
        this.organVizat = organVizat;
        this.durataConsultatie = durataConsultatie;
        this.operatiiReusite = operatiiReusite;
    }

    public String getOrganVizat() {
        return organVizat;
    }

    public void setOrganVizat(String organVizat) {
        this.organVizat = organVizat;
    }

    public int getDurataConsultatie() {
        return durataConsultatie;
    }

    public void setDurataConsultatie(int durataConsultatie) {
        this.durataConsultatie = durataConsultatie;
    }

    public short getOperatiiReusite() {
        return operatiiReusite;
    }

    public void setOperatiiReusite(short operatiiReusite) {
        this.operatiiReusite = operatiiReusite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cardiolog)) return false;
        if (!super.equals(o)) return false;
        Cardiolog cardiolog = (Cardiolog) o;
        return getOperatiiReusite() == cardiolog.getOperatiiReusite() && Objects.equals(getOrganVizat(), cardiolog.getOrganVizat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOrganVizat(), getOperatiiReusite());
    }

    @Override
    public String toString() {
        return super.toString()+" Acest medic cardiolog se ocupa de " + organVizat  +
                ", durata onsultatiei este de " + durataConsultatie +
                " minute. Are un numar de "+ operatiiReusite + " de operatii reusite.";
    }
}
