package login.log.DaoClasses;

import login.log.Database.Show;
import login.log.Database.Specsd;
import login.log.Database.Specsv;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Sakshi Agarwal on 20-12-2016.
 */
@Component
public class SpecsvDao {
   
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
 @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Specsv findByProductId(Specsv s){
        String sql = "SELECT * FROM SPECSV WHERE PR_NO = ? AND SID=?";
        Specsv specsv= (Specsv)getJdbcTemplate().queryForObject(
                sql, new Object[] {s.getPr_no(),s.getSid() },
                new BeanPropertyRowMapper(Specsv.class));
        return specsv;
    }

    public List<Specsd> getAll(int prid)
    {
        String sql = "SELECT SPECIFICATION_NAME,SPECS_VALUES FROM SPECSV INNER JOIN SPECS ON SPECSV.SID=SPECS.SID WHERE SPECSV.PR_NO=? AND SPECSV.SID<16 ";
        List<Specsd> specsd  = getJdbcTemplate().query(sql, new Object[] {prid},
                new BeanPropertyRowMapper(Specsd.class));
        return specsd;
    }
    public List<Show> getAllp(int id)
    {
        String sql = "SELECT PR_NO,SPECIFICATION_NAME,SPECS_VALUES FROM SPECSV INNER JOIN SPECS ON SPECSV.SID=SPECS.SID WHERE SPECSV.PID=? AND (SPECS.SID=1 OR SPECS.SID=2 OR SPECS.SID=14 OR SPECS.SID=16)";
        List<Show> show  = getJdbcTemplate().query(sql, new Object[] {id},
                new BeanPropertyRowMapper(Show.class));
        return show;
    }
    public Specsv queryForUrl(int prno){
        String sql = "SELECT * FROM SPECSV WHERE PR_NO = ? AND SID=?";
        Specsv specsv= (Specsv)getJdbcTemplate().queryForObject(
                sql, new Object[] {prno,16 },
                new BeanPropertyRowMapper(Specsv.class));
        return specsv;
    }
}
