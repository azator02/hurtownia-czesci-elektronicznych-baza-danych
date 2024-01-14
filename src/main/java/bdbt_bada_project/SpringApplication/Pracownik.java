package bdbt_bada_project.SpringApplication;
import java.sql.Date;
public class Pracownik {
    private int nrPracownika;
    private String imie;
    private String nazwisko;
    private Date dataUrodzenia;
    private String pesel;
    private String plec;
    private Date dataZatrudnienia;
    private String nrKonta;
    private String email;
    private String nrTelefonu;
    private int wynagrodzenie;
    private int nrHurtowni;
    private int nrAdresu;
    private int nrStanowiska;

    public int getNrPracownika() {
        return nrPracownika;
    }

    public void setNrPracownika(int nrPracownika) {
        this.nrPracownika = nrPracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Date getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(Date dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public String getNrKonta() {
        return nrKonta;
    }

    public void setNrKonta(String nrKonta) {
        this.nrKonta = nrKonta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public int getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(int wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
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

    public int getNrStanowiska() {
        return nrStanowiska;
    }

    public void setNrStanowiska(int nrStanowiska) {
        this.nrStanowiska = nrStanowiska;
    }

    public Pracownik(){

    }

    public Pracownik(int nrPracownika, String imie, String nazwisko, Date dataUrodzenia, String pesel, String plec, Date dataZatrudnienia, String nrKonta, String email, String nrTelefonu, int wynagrodzenie, int nrHurtowni, int nrAdresu, int nrStanowiska) {
        super();
        this.nrPracownika = nrPracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.pesel = pesel;
        this.plec = plec;
        this.dataZatrudnienia = dataZatrudnienia;
        this.nrKonta = nrKonta;
        this.email = email;
        this.nrTelefonu = nrTelefonu;
        this.wynagrodzenie = wynagrodzenie;
        this.nrHurtowni = nrHurtowni;
        this.nrAdresu = nrAdresu;
        this.nrStanowiska = nrStanowiska;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "nrPracownika=" + nrPracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", pesel='" + pesel + '\'' +
                ", plec='" + plec + '\'' +
                ", dataZatrudnienia=" + dataZatrudnienia +
                ", nrKonta='" + nrKonta + '\'' +
                ", email='" + email + '\'' +
                ", nrTelefonu='" + nrTelefonu + '\'' +
                ", wynagrodzenie=" + wynagrodzenie +
                ", nrHurtowni=" + nrHurtowni +
                ", nrAdresu=" + nrAdresu +
                ", nrStanowiska=" + nrStanowiska +
                '}';
    }
}
