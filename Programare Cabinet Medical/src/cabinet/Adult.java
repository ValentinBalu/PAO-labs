package cabinet;

import java.util.Arrays;

public class Adult extends Client{
    private String[] afectiuniCunoscute;

    private String[] medReactiiAdverse;

    private boolean vaccinatCovid;

    public Adult() {
    }

    public Adult(String nume, String cnp, int varsta, char sex, String[] simptome, String[] afectiuniCunoscute,String[] medReactiiAdverse,boolean vaccinatCovid) {
        super(nume, cnp, varsta, sex, simptome);
        this.afectiuniCunoscute = afectiuniCunoscute;
        this.medReactiiAdverse = medReactiiAdverse;
        this.vaccinatCovid = vaccinatCovid;
    }

    public String[] getAfectiuniCunoscute() {
        return afectiuniCunoscute;
    }

    public void setAfectiuniCunoscute(String[] afectiuniCunoscute) {
        this.afectiuniCunoscute = afectiuniCunoscute;
    }

    public String[] getMedReactiiAdverse() {
        return medReactiiAdverse;
    }

    public void setMedReactiiAdverse(String[] medReactiiAdverse) {
        this.medReactiiAdverse = medReactiiAdverse;
    }

    public Boolean getVaccinatCovid() {
        return vaccinatCovid;
    }

    public void setVaccinatCovid(Boolean vaccinatCovid) {
        this.vaccinatCovid = vaccinatCovid;
    }

    private String afisareVaccinCovid(){
        String s = " Mentionam ca acest pacient a fost vaccinat importiva Covid19.";
        if(this.vaccinatCovid == Boolean.TRUE)
            return s;
        return "";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adult)) return false;
        if (!super.equals(o)) return false;
        Adult adult = (Adult) o;
        return Arrays.equals(getAfectiuniCunoscute(), adult.getAfectiuniCunoscute());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(getAfectiuniCunoscute());
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +"Pacientul este un adult si are urmatoarele afectiuni cunoscute : " + Arrays.toString(afectiuniCunoscute) +
                ". Totodata, acesta a avut reactii adverse la urmatoarele medicamente : " + Arrays.toString(medReactiiAdverse) +
                '.'+afisareVaccinCovid();
    }
}
