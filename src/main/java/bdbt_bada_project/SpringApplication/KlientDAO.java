package bdbt_bada_project.SpringApplication;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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
    public void saveKlienci(Klient klient) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("KLIENCI").usingColumns("NR_KLIENTA", "IMIE", "NAZWISKO", "PESEL", "DATA_URODZENIA", "PLEC", "EMAIL", "NR_TELEFONU", "NR_ADRESU", "NR_HURTOWNI");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        System.out.println(klient);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Klient getKlienci(int nrKlienta) {
        Object[] args = {nrKlienta};
        String sql = "SELECT * FROM KLIENCI WHERE NR_KLIENTA = " + args[0];
        Klient klient = jdbcTemplate. queryForObject(sql, BeanPropertyRowMapper.newInstance(Klient.class));
        return klient;
    }
    /* Update – aktualizacja danych */
    public void updateKlienci(Klient klient) {
        String sql = "UPDATE KLIENCI SET imie=:imie, nazwisko=:nazwisko, pesel=:pesel, data_urodzenia=:dataUrodzenia, plec=:plec, email=:email, nr_telefonu=:nrTelefonu, nr_adresu=:nrAdresu, nr_hurtowni=:nrHurtowni WHERE nr_klienta=:nrKlienta";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(klient);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void deleteKlienci(int nrKlienta) {
        String sql = "DELETE FROM KLIENCI WHERE NR_KLIENTA = ?";
        jdbcTemplate.update(sql, nrKlienta);
    }

}