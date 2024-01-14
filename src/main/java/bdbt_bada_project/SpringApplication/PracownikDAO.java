package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PracownikDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /* Import java.util.List */

    public PracownikDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownik> list(){
        String sql = "SELECT * FROM PRACOWNICY";
        List<Pracownik> listPracownik = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return listPracownik;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownik pracownik) {
    }
    /* Read – odczytywanie danych z bazy */
    public Pracownik get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Pracownik pracownik) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}
