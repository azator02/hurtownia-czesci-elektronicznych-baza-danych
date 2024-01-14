package bdbt_bada_project.SpringApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MagazynDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /* Import java.util.List */

    public MagazynDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Magazyn> list(){
        String sql = "SELECT * FROM MAGAZYNY";
        List<Magazyn> listMagazyn = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Magazyn.class));
        return listMagazyn;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Magazyn magazyn) {
    }
    /* Read – odczytywanie danych z bazy */
    public Magazyn get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Magazyn magazyn) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
