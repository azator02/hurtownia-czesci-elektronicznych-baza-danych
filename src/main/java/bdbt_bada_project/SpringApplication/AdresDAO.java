package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /* Import java.util.List */

    public AdresDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adres> list(){
        String sql = "SELECT * FROM HURTOWNIE";
        List<Adres> listAdres = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return listAdres;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Adres adres) {
    }
    /* Read – odczytywanie danych z bazy */
    public Adres get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Adres adres) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}