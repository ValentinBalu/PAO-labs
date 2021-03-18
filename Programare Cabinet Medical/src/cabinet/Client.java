package cabinet;

import java.util.Arrays;
import java.util.Objects;

public class Client {
    private String nume;

    private String cnp;

    private int varsta;

    private char sex;

    private String[] simptome;

    public Client() {
    }

    public Client(String nume , String cnp, int varsta, char sex, String[] simptome) {
        this.nume = nume;
        this.cnp = cnp;
        this.varsta = varsta;
        this.sex = sex;
        this.simptome = simptome;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String[] getSimptome() {
        return simptome;
    }
    public void setSimptome(String[] simptome) {
        this.simptome = simptome;
    }

    @Override
    public String toString() {
        return "Clientul " + nume +
                ", cu CNP-ul : " + cnp +
                ", cu varsta de " + varsta +
                " ani, sex : " + sex +
                ", are urmatoarele simptome : " + Arrays.toString(simptome) + "."  ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getCnp() == client.getCnp() && getSex() == client.getSex() && Arrays.equals(getSimptome(), client.getSimptome());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getCnp(), getSex());
        result = 31 * result + Arrays.hashCode(getSimptome());
        return result;
    }
}
