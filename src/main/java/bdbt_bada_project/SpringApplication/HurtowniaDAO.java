package bdbt_bada_project.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public void saveHurtownie(Hurtownia hurtownia) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("HURTOWNIE").usingColumns("NR_HURTOWNI", "NAZWA", "DATA_ZALOZENIA", "NR_ADRESU");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(hurtownia);
        System.out.println(hurtownia);
        insertActor.execute(param);

    }
    /* Read – odczytywanie danych z bazy */
    public Hurtownia getHurtownie(int nrHurtowni) {
        Object[] args = {nrHurtowni};
        String sql = "SELECT * FROM HURTOWNIE WHERE NR_HURTOWNI = " + args[0];
        Hurtownia hurtownia = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Hurtownia.class));
        return hurtownia;
    }


    /* Update – aktualizacja danych */
    public void updateHurtownie(Hurtownia hurtownia) {
        String sql = "UPDATE HURTOWNIE SET nazwa=:nazwa, data_zalozenia=:dataZalozenia, nr_adresu=:nrAdresu WHERE nr_hurtowni=:nrHurtowni";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(hurtownia);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void deleteHurtownie(int nrHurtowni) {
        String sql = "DELETE FROM HURTOWNIE WHERE NR_HURTOWNI = ?";
        jdbcTemplate.update(sql, nrHurtowni);
    }

}
