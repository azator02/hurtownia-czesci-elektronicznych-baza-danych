package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProduktDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /* Import java.util.List */

    public ProduktDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Produkt> list(){
        String sql = "SELECT * FROM PRODUKTY";
        List<Produkt> listProdukt = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Produkt.class));
        return listProdukt;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Produkt produkt) {
    }
    /* Read – odczytywanie danych z bazy */
    public Produkt get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Produkt produkt) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }
}
