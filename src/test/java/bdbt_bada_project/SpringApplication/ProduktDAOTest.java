package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProduktDAOTest extends Object {

    private ProduktDAO dao;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@192.168.0.2:1522:xe");
        dataSource.setUsername("AZATOR2");
        dataSource.setPassword("AZATOR2");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        /*Import JdbcTemplate*/
        dao = new ProduktDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        /*Import java.util*/
        List<Produkt> listProdukt = dao.list();
        System.out.println(listProdukt);
        assertFalse(listProdukt.isEmpty());
    }

    @Test
    void save() {
        Produkt produkt = new Produkt(300, "termostat", "urządzenie do definiowania temperatury", 100, "Termox", 50, 121);
        dao.save(produkt);
    }

    @Test
    void get() {
        int nrProduktu = 300;
        Produkt produkt = dao.get(nrProduktu);
        System.out.println(produkt);
        assertNotNull(produkt);
    }

    @Test
    void update() {
        Produkt produkt = new Produkt();
        produkt.setNrProduktu(300);
        produkt.setNazwa("Termostat");
        produkt.setOpis("urządzenie do definiowania temperatury");
        produkt.setIloscProduktow(500);
        produkt.setProducent("Termox");
        produkt.setCena(40);
        produkt.setNrHurtowni(121);

        dao.update(produkt);
    }

    @Test
    void delete() {
        int nrProduktu = 300;
        dao.delete(nrProduktu);
    }
}