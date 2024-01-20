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
    public void saveProdukty(Produkt produkt) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("PRODUKTY").usingColumns("NR_PRODUKTU", "NAZWA", "OPIS", "ILOSC_PRODUKTOW", "PRODUCENT", "CENA", "NR_HURTOWNI");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(produkt);
        System.out.println(produkt);
        insertActor.execute(param);
    }
    /* Read – odczytywanie danych z bazy */
    public Produkt getProdukty(int nrProduktu) {
        Object[] args = {nrProduktu};
        String sql = "SELECT * FROM PRODUKTY WHERE NR_PRODUKTU = " + args[0];
        Produkt produkt = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Produkt.class));
        return produkt;
    }

    public List<Produkt> listWithHurtownia(int nrHurtowni){
        Object[] args = {nrHurtowni};
        String sql = "SELECT * FROM PRODUKTY WHERE NR_HURTOWNI = " + args[0];
        List<Produkt> listProdukt = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Produkt.class));
        return listProdukt;
    }

    public Produkt getWithHurtownia(int nrHurtowni) {
        Object[] args = {nrHurtowni};
        String sql = "SELECT * FROM PRODUKTY WHERE NR_HURTOWNI = " + args[0];
        Produkt produkt = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Produkt.class));
        return produkt;
    }
    /* Update – aktualizacja danych */
    public void updateProdukty(Produkt produkt) {
        String sql = "UPDATE PRODUKTY SET nazwa=:nazwa, opis=:opis, ilosc_produktow=:iloscProduktow, producent=:producent, cena=:cena, nr_hurtowni=:nrHurtowni WHERE nr_produktu=:nrProduktu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(produkt);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    /* Delete – wybrany rekord z danym id */
    public void deleteProdukty(int nrProduktu) {
        String sql = "DELETE FROM PRODUKTY WHERE NR_PRODUKTU = ?";
        jdbcTemplate.update(sql, nrProduktu);
    }
}
