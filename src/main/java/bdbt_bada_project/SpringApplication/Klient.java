package bdbt_bada_project.SpringApplication;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

public class Klient {
    private int nrKlienta;
    private String imie;
    private String nazwisko;
    private String pesel;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dataUrodzenia;
    private String plec;
    private String email;
    private String nrTelefonu;
    private String nrAdresu;
    private int nrHurtowni;

    public Klient(int nrKlienta, String imie, String nazwisko, String pesel, LocalDate dataUrodzenia, String plec, String email, String nrTelefonu, String nrAdresu, int nrHurtowni) {
        super();
        this.nrKlienta = nrKlienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dataUrodzenia = dataUrodzenia;
        this.plec = plec;
        this.email = email;
        this.nrTelefonu = nrTelefonu;
        this.nrAdresu = nrAdresu;
        this.nrHurtowni = nrHurtowni;
    }

    public Klient(){

    }

    public int getNrKlienta() {
        return nrKlienta;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public String getEmail() {
        return email;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public String getNrAdresu() {
        return nrAdresu;
    }

    public int getNrHurtowni() {
        return nrHurtowni;
    }

    public void setNrKlienta(int nrKlienta) {
        this.nrKlienta = nrKlienta;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public void setNrAdresu(String nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    public void setNrHurtowni(int nrHurtowni) {
        this.nrHurtowni = nrHurtowni;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "nrKlienta=" + nrKlienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel=" + pesel +
                ", dataUrodzenia=" + dataUrodzenia +
                ", plec=" + plec +
                ", email='" + email + '\'' +
                ", nrTelefonu=" + nrTelefonu +
                ", nrAdresu=" + nrAdresu +
                ", nrHurtowni=" + nrHurtowni +
                '}';
    }
}
