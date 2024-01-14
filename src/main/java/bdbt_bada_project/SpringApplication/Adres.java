package bdbt_bada_project.SpringApplication;

public class Adres {
    private int nrAdresu;
    private String miasto;
    private String ulica;
    private int nrBudynku;
    private String nrLokalu;
    private int nrPoczty;

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNrBudynku() {
        return nrBudynku;
    }

    public void setNrBudynku(int nrBudynku) {
        this.nrBudynku = nrBudynku;
    }

    public String getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public int getNrPoczty() {
        return nrPoczty;
    }

    public void setNrPoczty(int nrPoczty) {
        this.nrPoczty = nrPoczty;
    }

    public Adres(){

    }

    public Adres(int nrAdresu, String miasto, String ulica, int nrBudynku, String nrLokalu, int nrPoczty) {
        super();
        this.nrAdresu = nrAdresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrBudynku = nrBudynku;
        this.nrLokalu = nrLokalu;
        this.nrPoczty = nrPoczty;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "nrAdresu=" + nrAdresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nrBudynku=" + nrBudynku +
                ", nrLokalu=" + nrLokalu +
                ", nrPoczty=" + nrPoczty +
                '}';
    }
}
