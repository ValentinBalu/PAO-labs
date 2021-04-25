package cabinet;

import java.util.Objects;

public class Oftalmolog extends Medic{
    private String organVizat;

    private int durataConsultatie;

    private Boolean chirurgie;

    public Oftalmolog() {
    }

    public Oftalmolog(String nume, int varsta, String specialitate, int tura, String organVizat,int durataConsultatie,Boolean chirurgie) {
        super(nume, varsta, specialitate, tura);
        this.organVizat = organVizat;
        this.durataConsultatie = durataConsultatie;
        this.chirurgie = chirurgie;
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

    public Boolean getChirurgie() {
        return chirurgie;
    }

    public void setChirurgie(Boolean chirurgie) {
        this.chirurgie = chirurgie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Oftalmolog)) return false;
        if (!super.equals(o)) return false;
        Oftalmolog that = (Oftalmolog) o;
        return Objects.equals(getOrganVizat(), that.getOrganVizat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOrganVizat());
    }
    private String eChirurg(){
        if(this.chirurgie == true)
            return " Acest medic se ocupa si de partea de chirurgie.";
        return "";
    }

    @Override
    public String toString() {
        return super.toString()+" Acest medic oftalmolog se ocupa de " + organVizat  +
                ", durata consultatiei este de " + durataConsultatie +
                " minute." + eChirurg();
    }
}
