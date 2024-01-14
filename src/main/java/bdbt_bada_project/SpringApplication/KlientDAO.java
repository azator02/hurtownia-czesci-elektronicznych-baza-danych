package bdbt_bada_project.SpringApplication;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class KlientDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /* Import java.util.List */

    public KlientDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klient> list(){
        String sql = "SELECT * FROM KLIENCI";
        List<Klient> listKlient = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));
        return listKlient;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Klient klient) {
    }
    /* Read – odczytywanie danych z bazy */
    public Klient get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Klient klient) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}