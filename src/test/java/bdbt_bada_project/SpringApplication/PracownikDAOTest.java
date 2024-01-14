package bdbt_bada_project.SpringApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PracownikDAOTest extends Object {

    private PracownikDAO dao;
    @BeforeEach
    void setUp() throws Exception{
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@192.168.0.2:1522:xe");
        dataSource.setUsername("AZATOR2");
        dataSource.setPassword("AZATOR2");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        /*Import JdbcTemplate*/
        dao = new PracownikDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        /*Import java.util*/
        List<Pracownik> listPracownik = dao.list();
        System.out.println(listPracownik);
        assertFalse(listPracownik.isEmpty());
    }

    @Test
    void save() {
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}