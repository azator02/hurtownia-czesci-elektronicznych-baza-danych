package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HurtowniaDAOTest extends Object {

    private HurtowniaDAO dao;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@192.168.0.2:1522:xe");
        dataSource.setUsername("AZATOR2");
        dataSource.setPassword("AZATOR2");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        /*Import JdbcTemplate*/
        dao = new HurtowniaDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        /*Import java.util*/
        List<Hurtownia> listHurtownia = dao.list();
        System.out.println(listHurtownia);
        assertFalse(listHurtownia.isEmpty());
    }

    @Test
    void save() {
        //Date data = new Date(27, 0, 20);
        Hurtownia hurtownia = new Hurtownia(200, "Grzybki", LocalDate.of(1927,7,16), 119);
        dao.saveHurtownie(hurtownia);
    }

    @Test
    void get() {
        int nrHurtowni = 121;
        Hurtownia hurtownia = dao.getHurtownie(nrHurtowni);
        System.out.println(hurtownia);
        assertNotNull(hurtownia);
    }

    @Test
    void update() {
        Hurtownia hurtownia = new Hurtownia();
        hurtownia.setNrHurtowni(200);
        hurtownia.setNazwa("Dobra pizza");
        hurtownia.setDataZalozenia(LocalDate.of(1927,7,20));
        hurtownia.setNrAdresu(119);

        dao.updateHurtownie(hurtownia);
    }

    @Test
    void delete() {
        int nrHurtowni = 200;
        dao.deleteHurtownie(nrHurtowni);
    }
}