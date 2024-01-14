package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PocztaDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /* Import java.util.List */

    public PocztaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Poczta> list(){
        String sql = "SELECT * FROM POCZTY";
        List<Poczta> listPoczta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
        return listPoczta;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Poczta poczta) {
    }
    /* Read – odczytywanie danych z bazy */
    public Poczta get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Poczta poczta) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}
