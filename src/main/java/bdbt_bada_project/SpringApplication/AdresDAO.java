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
        String sql = "SELECT * FROM ADRESY";
        List<Adres> listAdres = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return listAdres;
    }
    /* Insert – wstawianie nowego wiersza do bazy */
    public void saveAdresy(Adres adres) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("ADRESY").usingColumns("NR_ADRESU", "MIASTO", "ULICA", "NR_BUDYNKU", "NR_LOKALU", "NR_POCZTY");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        System.out.println(adres);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Adres getAdresy(int nrAdresu) {
        Object[] args = {nrAdresu};
        String sql = "SELECT * FROM ADRESY WHERE NR_ADRESU = " + args[0];
        Adres adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;

    }
    /* Update – aktualizacja danych */
    public void updateAdresy(Adres adres) {
        String sql = "UPDATE ADRESY SET miasto=:miasto, ulica=:ulica, nr_budynku=:nrBudynku, nr_lokalu=:nrLokalu, nr_poczty=:nrPoczty WHERE nr_adresu=:nrAdresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void deleteAdresy(int nrAdresu) {
        String sql = "DELETE FROM ADRESY WHERE NR_ADRESU = ?";
        jdbcTemplate.update(sql, nrAdresu);
    }

    public List<Adres> listWithNrAdresu(int nrAdresu) {
        Object[] args = {nrAdresu};
        String sql = "SELECT * FROM ADRESY WHERE NR_ADRESU = " + args[0];
        List<Adres> adres = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }
}
