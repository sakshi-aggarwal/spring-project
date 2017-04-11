package login.log.DaoClasses;


import login.log.Database.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class CustomerDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveCustomer(Customer e) {


        String query = "insert  into customer(Username,password,number) "
        +"values(?,?,?)";
        jdbcTemplate.update(query,e.getUsername(),e.getPassword(),e.getNumber());

        //String query = "insert into customer values('"+"','" + e.getUsername() + "','" + e.getPassword() + "','"+e.getNumber()+"')";
        //jdbcTemplate.update(query);
    }


    public int updateCustomer(Customer e) {
        String query = "update customer set Username='" + e.getUsername() + "' where Username='" + e.getUsername() + "' ";
        return jdbcTemplate.update(query);
    }

    public int deleteCustomer(Customer e) {
        String query = "delete from customer where id='" + e.getUsername() + "' ";
        return jdbcTemplate.update(query);
    }
    @SuppressWarnings("deprecation")
    public boolean userauthentication(Customer e)
    {
        boolean userexists=false;
        Object[] params = new Object[] {
                e.getUsername(),
        e.getPassword()
        };
        int rowcount=jdbcTemplate.queryForObject("select count(*) from customer "+
                " where username= ? and password= ?",params,Integer.class);
        if(rowcount==1)
            userexists=true;
        return userexists;



    }
        public List<Customer> getAllCustomers(){
        return jdbcTemplate.query("select * from customer",new ResultSetExtractor<List<Customer>>(){
            @Override
            public List<Customer> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {

                List<Customer> list=new ArrayList<Customer>();
                while(rs.next()){
                    Customer e=new Customer();

                    e.setUsername(rs.getString(2));

                    list.add(e);
                }
                return list;
            }
        });
    }
}

