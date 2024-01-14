package bdbt_bada_project.SpringApplication;

public class Magazyn {
    private int nrMagazynu;
    private int powierzchnia;
    private String typMagazynu;
    private String nazwa;
    private int pojemnosc;
    private int nrHurtowni;
    private int nrAdresu;

    public int getNrMagazynu() {
        return nrMagazynu;
    }

    public void setNrMagazynu(int nrMagazynu) {
        this.nrMagazynu = nrMagazynu;
    }

    public int getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(int powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public String getTypMagazynu() {
        return typMagazynu;
    }

    public void setTypMagazynu(String typMagazynu) {
        this.typMagazynu = typMagazynu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public int getNrHurtowni() {
        return nrHurtowni;
    }

    public void setNrHurtowni(int nrHurtowni) {
        this.nrHurtowni = nrHurtowni;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    @Override
    public String toString() {
        return "Magazyn{" +
                "nrMagazynu=" + nrMagazynu +
                ", powierzchnia=" + powierzchnia +
                ", typMagazynu='" + typMagazynu + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", pojemnosc=" + pojemnosc +
                ", nrHurtowni=" + nrHurtowni +
                ", nrAdresu=" + nrAdresu +
                '}';
    }

    public Magazyn() {

    }

    public Magazyn(int nrMagazynu, int powierzchnia, String typMagazynu, String nazwa, int pojemnosc, int nrHurtowni, int nrAdresu) {
        super();
        this.nrMagazynu = nrMagazynu;
        this.powierzchnia = powierzchnia;
        this.typMagazynu = typMagazynu;
        this.nazwa = nazwa;
        this.pojemnosc = pojemnosc;
        this.nrHurtowni = nrHurtowni;
        this.nrAdresu = nrAdresu;

    }
}
