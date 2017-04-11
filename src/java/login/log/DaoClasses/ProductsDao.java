package login.log.DaoClasses;

import login.log.Database.Employee;
import login.log.Database.Products;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sakshi Agarwal on 19-12-2016.
 */
@Component
public class ProductsDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Products> getAllProducts(){
        return jdbcTemplate.query("select * from products",new ResultSetExtractor<List<Products>>(){
            @Override
            public List<Products> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {

                List<Products> list=new ArrayList<Products>();
                while(rs.next()){
                    Products p=new Products();
                    p.setPid(rs.getInt(1));
                    p.setName(rs.getString(2));
                    p.setCategory(rs.getString(3));
                    // e.setSalary(rs.getInt(3));
                    list.add(p);
                }
                return list;
            }
        });
    }
    public Products findByProductId(int pid){

        String sql = "SELECT * FROM PRODUCTS WHERE PID = ?";

        Products products = (Products)getJdbcTemplate().queryForObject(
                sql, new Object[] { pid },
                new BeanPropertyRowMapper(Products.class));

        return products;
    }
}
