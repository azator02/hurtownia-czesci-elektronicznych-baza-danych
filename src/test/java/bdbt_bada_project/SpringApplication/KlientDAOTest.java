package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KlientDAOTest extends Object {

    private KlientDAO dao;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1522:xe");
        dataSource.setUsername("AZATOR2HOME");
        dataSource.setPassword("AZATOR2HOME");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        /*Import JdbcTemplate*/
        dao = new KlientDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        /*Import java.util*/
        List<Klient> listKlient = dao.list();
        System.out.println(listKlient);
        assertFalse(listKlient.isEmpty());
    }

    @Test
    void save() {
        Klient klient = new Klient(400, "Maria", "Szczypa", "25412536985", LocalDate.of(1994,7,5), "M", "kshdfbjkdsf", "777444111", "119", 121, "Szczypa", "Szczypa");
        dao.saveKlienci(klient);
    }

    @Test
    void get() {
        int nrKlienta = 400;
        Klient klient = dao.getKlienci(nrKlienta);
        System.out.println(klient);
        assertNotNull(klient);
    }

    @Test
    void update() {
        Klient klient = new Klient();
        klient.setNrKlienta(400);
        klient.setImie("Kamil");
        klient.setNazwisko("Sztos");
        klient.setPesel("55555555555");
        klient.setDataUrodzenia(LocalDate.of(2011,8,13));
        klient.setPlec("K");
        klient.setEmail("jhsdjksfdl");
        klient.setNrTelefonu("555555554");
        klient.setNrAdresu("120");
        klient.setNrHurtowni(121);

        dao.updateKlienci(klient);
    }

    @Test
    void delete() {
        int nrKlienta = 400;
        dao.deleteKlienci(nrKlienta);
    }

    @Test
    void listWithLogin() {
        String login = "Pi";
        System.out.println(dao.listWithLogin(login));
    }
}