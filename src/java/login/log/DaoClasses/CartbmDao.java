/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.log.DaoClasses;

import java.util.Iterator;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;
import login.log.Database.Show;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Sakshi Agarwal
 */
@Component
public class CartbmDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
     public void saveEntry(String user,int pr_no,int status){
        String query="insert into cartbm values('"+user+"', '"+pr_no+"', '"+status+"')";
        jdbcTemplate.update(query);
    }
     public boolean check(String user,int pr_no)
     {
         Object[] params = new Object[] {
              user,
        pr_no
        };
         int rowcount=jdbcTemplate.queryForObject("select count(*) from cartbm "+
                " where username= ? and pr_no= ?",params,Integer.class);
         if(rowcount==0)
                 return true;
         return false;
     }
     public int getStatus(String user,int pr_no)
     {
         Object[] params = new Object[] {
              user,
        pr_no
        };
          int status=jdbcTemplate.queryForObject("select status from cartbm "+
                " where username= ? and pr_no= ?",params,Integer.class);
          return status;
     }
     public void updateEntry(String user,int pr_no,int status)
     {
         
        String query="update cartbm set status='"+status+"' where username='"+user+"' and pr_no='"+pr_no+"' ";
         jdbcTemplate.update(query);
     }
     public List<Show> getBookmarkItems(String user)
     {
         
       String sql = "SELECT a.PR_NO,c.SPECIFICATION_NAME,b.SPECS_VALUES FROM CARTBM a,SPECSV b,SPECS c where a.PR_NO=b.PR_NO AND b.SID=c.SID AND a.USERNAME=? AND (a.STATUS=0 OR a.STATUS=2) AND (b.SID=1 OR b.SID=2 OR b.SID=16)";
        List<Show> show  = getJdbcTemplate().query(sql, new Object[] {user},
                new BeanPropertyRowMapper(Show.class));
        return show;
     }
 
     public List<Show> getCartItems(String user)
     {
         
       String sql = "SELECT a.PR_NO,c.SPECIFICATION_NAME,b.SPECS_VALUES FROM CARTBM a,SPECSV b,SPECS c where a.PR_NO=b.PR_NO AND b.SID=c.SID AND a.USERNAME=? AND (a.STATUS=1 OR a.STATUS=2) AND (b.SID=1 OR b.SID=2 OR b.SID=16)";
        List<Show> show  = getJdbcTemplate().query(sql, new Object[] {user},
                new BeanPropertyRowMapper(Show.class));
        return show;
     }
     public int deleteBookmark(int pr_no,String user){
         int status=getStatus(user,pr_no);
         if(status==0){
        String query="delete from cartbm where pr_no='"+pr_no+"' and username='"+user+"' ";
        return jdbcTemplate.update(query);
         }
         else
         {
             String query="update cartbm set status=1 where pr_no='"+pr_no+"' ";
        return jdbcTemplate.update(query);
         }
    }
public int deleteCartItem(int pr_no,String user){
    int status=getStatus(user,pr_no);
    if(status==1){
        String query="delete from cartbm where pr_no='"+pr_no+"' and username='"+user+"' ";
        return jdbcTemplate.update(query);
    }
    else
    {
        String query="update cartbm set status=0 where pr_no='"+pr_no+"' ";
        return jdbcTemplate.update(query);
    }
}
}
