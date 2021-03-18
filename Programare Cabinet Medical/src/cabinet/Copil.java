package cabinet;

import java.util.Arrays;

public class Copil extends Client{
    private String[] vaccinuri;

    public Copil() {
    }

    public Copil(String nume, String cnp, int varsta, char sex, String[] simptome, String[] vaccinuri) {
        super(nume, cnp, varsta, sex, simptome);
        this.vaccinuri = vaccinuri;
    }

    public String[] getVaccinuri() {
        return vaccinuri;
    }

    public void setVaccinuri(String[] vaccinuri) {
        this.vaccinuri = vaccinuri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Copil)) return false;
        if (!super.equals(o)) return false;
        Copil copil = (Copil) o;
        return Arrays.equals(getVaccinuri(), copil.getVaccinuri());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(getVaccinuri());
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " Pacientul este un copil si are urmatoarele vaccinuri : " + Arrays.toString(vaccinuri) +
                '.';
    }
}
