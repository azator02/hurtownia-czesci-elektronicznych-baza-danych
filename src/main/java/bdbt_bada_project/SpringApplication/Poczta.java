package bdbt_bada_project.SpringApplication;

public class Poczta {
    private int nrPoczty;
    private String kodPocztowy;
    private String poczta;

    public int getNrPoczty() {
        return nrPoczty;
    }

    public void setNrPoczty(int nrPoczty) {
        this.nrPoczty = nrPoczty;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    public Poczta(){

    }

    public Poczta(int nrPoczty, String kodPocztowy, String poczta) {
        super();
        this.nrPoczty = nrPoczty;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
    }

    @Override
    public String toString() {
        return "Poczta{" +
                "nrPoczty=" + nrPoczty +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                ", poczta='" + poczta + '\'' +
                '}';
    }
}
