package cabinet;

import java.util.Date;
import java.util.Objects;

public class Programare {
    private String numeClient;

    private String dataProgramare;

    private String oraProgramare;

    private String specialitatea;

    private String numeMedic;

    private double cost;

    public Programare() {
    }

    public Programare(String numeClient,String dataProgramare,String oraProgramare,String specialitatea,String numeMedic,double cost) {
        this.dataProgramare = dataProgramare;
        this.oraProgramare = oraProgramare;
        this.specialitatea = specialitatea;
        this.cost = cost;
        this.numeClient = numeClient;
        this.numeMedic = numeMedic;
    }

    public String getDataProgramare() {
        return dataProgramare;
    }

    public void setDataProgramare(String dataProgramare) {
        this.dataProgramare = dataProgramare;
    }

    public String getOraProgramare() {
        return oraProgramare;
    }

    public void setOraProgramare(String oraProgramare) {
        this.oraProgramare = oraProgramare;
    }

    public String getSpecialitatea() {
        return specialitatea;
    }

    public void setSpecialitatea(String specialitatea) {
        this.specialitatea = specialitatea;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public String getNumeMedic() {
        return numeMedic;
    }

    public void setNumeMedic(String numeMedic) {
        this.numeMedic = numeMedic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Programare)) return false;
        Programare that = (Programare) o;
        return Objects.equals(getDataProgramare(), that.getDataProgramare()) && Objects.equals(getOraProgramare(), that.getOraProgramare()) && Objects.equals(getSpecialitatea(), that.getSpecialitatea());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDataProgramare(), getOraProgramare(), getSpecialitatea());
    }

    @Override
    public String toString() {
        return "Programarea facuta de " +numeClient +
                ", din data de " + dataProgramare +
                ", la ora " + oraProgramare +
                ", pentru specialitatea " + specialitatea  +
                ", la medicul " + numeMedic +
                ", are costul de " + cost + " de lei.";
    }
}
