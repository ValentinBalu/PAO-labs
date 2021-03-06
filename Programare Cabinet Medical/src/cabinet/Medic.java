package cabinet;

import java.util.Objects;

public class Medic implements Comparable<Medic> {
    private  int idMedic;

    private String nume;

    private int varsta;

    private String specialitate;

    private int tura;

    public Medic() {
    }

    public Medic(String nume,int varsta, String specialitate,int tura) {
        this.idMedic = 0;
        this.nume = nume;
        this.varsta = varsta;
        this.specialitate = specialitate;
        this.tura = tura;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getSpecialitate() {
        return specialitate;
    }

    public void setSpecialitate(String specialitate) {
        this.specialitate = specialitate;
    }

    public int getTura() {
        return tura;
    }

    public void setTura(int tura) {
        this.tura = tura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medic)) return false;
        Medic medic = (Medic) o;
        return Objects.equals(getNume(), medic.getNume()) && Objects.equals(getSpecialitate(), medic.getSpecialitate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNume(), getSpecialitate());
    }

    @Override
    public String toString() {
        return "Medicul "  + nume +
                ", cu varsta de " + varsta +
                " ani, are specialitatea de " + specialitate  +
                " si lucreaza in tura " + tura  +
                '.';
    }

    @Override
    public int compareTo(Medic medic) {
        /*
        * Returns:
        * - positive integer, if the current object is greater than the
        specified object.
        * - negative integer, if the current object is less than the
        specified object.
        * - zero, if the current object is equal to the specified object.
        */
        return this.varsta - medic.varsta;
    }
}
