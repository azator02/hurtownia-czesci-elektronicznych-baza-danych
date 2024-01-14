package bdbt_bada_project.SpringApplication;

public class Produkt {
    private int nrProduktu;
    private String nazwa;
    private String opis;
    private int iloscProduktow;
    private String producent;
    private int cena;
    private int nrHurtowni;

    public int getNrProduktu() {
        return nrProduktu;
    }

    public void setNrProduktu(int nrProduktu) {
        this.nrProduktu = nrProduktu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getIloscProduktow() {
        return iloscProduktow;
    }

    public void setIloscProduktow(int iloscProduktow) {
        this.iloscProduktow = iloscProduktow;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getNrHurtowni() {
        return nrHurtowni;
    }

    public void setNrHurtowni(int nrHurtowni) {
        this.nrHurtowni = nrHurtowni;
    }

    public Produkt(){

    }

    public Produkt(int nrProduktu, String nazwa, String opis, int iloscProduktow, String producent, int cena, int nrHurtowni) {
        super();
        this.nrProduktu = nrProduktu;
        this.nazwa = nazwa;
        this.opis = opis;
        this.iloscProduktow = iloscProduktow;
        this.producent = producent;
        this.cena = cena;
        this.nrHurtowni = nrHurtowni;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "nrProduktu=" + nrProduktu +
                ", nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                ", iloscProduktow=" + iloscProduktow +
                ", producent='" + producent + '\'' +
                ", cena=" + cena +
                ", nrHurtowni=" + nrHurtowni +
                '}';
    }
}
