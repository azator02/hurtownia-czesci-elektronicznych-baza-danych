package bdbt_bada_project.SpringApplication;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

public class Hurtownia {
    private int nrHurtowni;
    private String nazwa;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dataZalozenia;
    private int nrAdresu;

    public int getNrHurtowni() {
        return nrHurtowni;
    }

    public void setNrHurtowni(int nrHurtowni) {
        this.nrHurtowni = nrHurtowni;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public LocalDate getDataZalozenia() {
        return dataZalozenia;
    }

    public void setDataZalozenia(LocalDate dataZalozenia) {
        this.dataZalozenia = dataZalozenia;
    }

    public int getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(int nrAdresu) {
        this.nrAdresu = nrAdresu;
    }

    public Hurtownia() {

    }

    public Hurtownia(int nrHurtowni, String nazwa, LocalDate dataZalozenia, int nrAdresu) {
        super();
        this.nrHurtowni = nrHurtowni;
        this.nazwa = nazwa;
        this.dataZalozenia = dataZalozenia;
        this.nrAdresu = nrAdresu;
    }

    @Override
    public String toString() {
        return "Hurtownia{" +
                "nrHurtowni=" + nrHurtowni +
                ", nazwa='" + nazwa + '\'' +
                ", dataZalozenia=" + dataZalozenia +
                ", nrAdresu=" + nrAdresu +
                '}';
    }
}
