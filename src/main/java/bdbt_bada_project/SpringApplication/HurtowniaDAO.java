package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.time.LocalDate;

@Repository
public class HurtowniaDAO {
    /* Import org.springframework.jd....Template */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /* Import java.util.List */

    public HurtowniaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Hurtownia> list(){
        String sql = "SELECT * FROM HURTOWNIE";
        List<Hurtownia> listHurtownia = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Hurtownia.class));
        return listHurtownia;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Hurtownia hurtownia) {
//        Date temp = hurtownia.getDataZalozenia();
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("HURTOWNIE").usingColumns("NR_HURTOWNI", "NAZWA", "DATA_ZALOZENIA", "NR_ADRESU");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(hurtownia);
        System.out.println(hurtownia);
        insertActor.execute(param);

    }
    /* Read – odczytywanie danych z bazy */
    public Hurtownia get(int id) {
        return null;
    }
    /* Update – aktualizacja danych */
    public void update(Hurtownia hurtownia) {
    }
    /* Delete – wybrany rekord z danym id */
    public void delete(int id) {
    }

}
