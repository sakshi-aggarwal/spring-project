package login.log.DaoClasses;

/**
 * Created by Sakshi Agarwal on 11-12-2016.
 */

        import login.log.Database.Employee;
        import org.springframework.dao.DataAccessException;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;
@Component
public class EmployeeDao {
    private JdbcTemplate jdbcTemplate;
    //NamedParameterJdbcTemplate template;

    //public EmployeeDao(NamedParameterJdbcTemplate template) {
      //  this.template = template;
    //}
    public List<Employee> getAllEmployees(){
        return jdbcTemplate.query("select * from employee",new ResultSetExtractor<List<Employee>>(){
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException,
                    DataAccessException {

                List<Employee> list=new ArrayList<Employee>();
                while(rs.next()){
                    Employee e=new Employee();
                    e.setId(rs.getInt(1));
                    e.setName(rs.getString(2));
                   // e.setSalary(rs.getInt(3));
                    list.add(e);
                }
                return list;
            }
        });
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveEmployee(Employee e){
        String query="insert into employee values('"+e.getId()+"','"+e.getName()+"')";
        jdbcTemplate.update(query);
    }
    public int updateEmployee(Employee e){
        String query="update employee set name='"+e.getName()+"' where id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);
    }
    public int deleteEmployee(Employee e){
        String query="delete from employee where id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);
    }


}

