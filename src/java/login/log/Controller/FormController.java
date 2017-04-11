/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.log.Controller;
import java.util.List;
import javax.servlet.http.HttpSession;
import login.log.DaoClasses.CartbmDao;
import login.log.DaoClasses.SpecsvDao;

import login.log.Database.Discr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Sakshi Agarwal
 */
@Controller
public class FormController {
    @Autowired
   private SpecsvDao sdao;
    @Autowired
    private CartbmDao cbdao;
    @RequestMapping("/homepage")
    public String getwelcomeForm(){
        return "homepage";
    }
     @RequestMapping("/home")
    public String gethome(){
        return "home";
    }
    @RequestMapping("/login")
    public String getForm(){
        
        return "login";
    }
 @RequestMapping("/Afterlogin")
    public ModelAndView confirmStudentLogin(@RequestParam("username") String user_name, @RequestParam("password") String password, ModelAndView mav, HttpSession session) {
        
        mav.setViewName("authorisedHome");
        //System.out.println("\nId of student is:"+student_id);
       
        mav.addObject("username", user_name);
        //System.out.println("student city is:"+student.getCity());
        session.setAttribute("user", user_name);
        
        return mav;
    }
 @RequestMapping(value="/logout")
    public String logoutPage (HttpSession session){
   
     session.removeAttribute("user");
      session.invalidate();      
return "login";
    }  
    @RequestMapping(value="/prod/{id}")
    public ModelAndView prodPage(@PathVariable("id") int id)
    {
        ModelAndView mav=new ModelAndView();           
        Discr discr=new Discr();
        mav.addObject("discr",discr.findListp(sdao.getAllp(id)));
        mav.setViewName("product");
        return mav;
    }
    @RequestMapping(value="/prods/{id}")
    public ModelAndView authorisedProductFunction(@PathVariable("id") int id,HttpSession session)
    {
        ModelAndView mav=new ModelAndView();           
        Discr discr=new Discr();
        mav.addObject("discr",discr.findListp(sdao.getAllp(id)));
        mav.setViewName("authorisedProduct");
        return mav;
    }
    
    
    @RequestMapping(value="/items")
public ModelAndView itemPage(@RequestParam("pr_no") String pr_no)
{  
    int pr_id=Integer.parseInt(pr_no);
    ModelAndView mav=new ModelAndView();
    mav.setViewName("items");
    mav.addObject("specsd",sdao.getAll(pr_id));
    mav.addObject("specsv",sdao.queryForUrl(pr_id));
    return mav;
}
@RequestMapping(value="/authorisedItems")
public ModelAndView authorisedItemPage(@RequestParam("pr_no") String pr_no,HttpSession session)
{  
    int pr_id=Integer.parseInt(pr_no);
    ModelAndView mav=new ModelAndView();
    mav.addObject("specsd",sdao.getAll(pr_id));
    mav.addObject("specsv",sdao.queryForUrl(pr_id));
    mav.setViewName("authorisedItems");
    return mav;
}
@RequestMapping(value="/bookmark.htm" ,method=RequestMethod.POST)
public ModelAndView addBookmark(@RequestParam("user") String user,@RequestParam("pr_no") int pr_no,HttpSession session)
{
    ModelAndView mav=new ModelAndView(); 
    if(cbdao.check(user,pr_no))
    {
        cbdao.saveEntry(user,pr_no,0);
    }
    else
    {
        int s=cbdao.getStatus(user,pr_no);
        if(s==1)
            cbdao.updateEntry(user,pr_no,2);
        
    }
   mav.addObject("pn",pr_no);
    mav.setViewName("bookmark");
    return mav;
}
@RequestMapping(value="/addToCart.htm" ,method=RequestMethod.POST)
public ModelAndView addToCart(@RequestParam("user") String user,@RequestParam("pr_no") int pr_no,HttpSession session)
{
    ModelAndView mav=new ModelAndView(); 
    if(cbdao.check(user,pr_no))
    {
        cbdao.saveEntry(user,pr_no,1);
    }
    else
    {
        int s=cbdao.getStatus(user,pr_no);
        if(s==0)
            cbdao.updateEntry(user,pr_no,2);
        
    }
    mav.addObject("pn",pr_no);
    mav.setViewName("bookmark");
    return mav;
}
@RequestMapping(value="/showBookmarks.htm")
public ModelAndView showBookmarkItemsPage(HttpSession session)
{
    ModelAndView mav=new ModelAndView();
    String user=(String)session.getAttribute("user");
    Discr discr=new Discr();
        mav.addObject("discr",discr.findListp(cbdao.getBookmarkItems(user)));
    mav.setViewName("showBookmarks");           
    return mav;
}
@RequestMapping(value="/showCartItems.htm")
public ModelAndView showCartItemsPage(HttpSession session)
{
    ModelAndView mav=new ModelAndView();
    String user=(String)session.getAttribute("user");
    Discr discr=new Discr();
        mav.addObject("discr",discr.findListp(cbdao.getCartItems(user)));
    mav.setViewName("showCartItems");           
    return mav;
}
@RequestMapping(value="removeBookmark.htm")
public ModelAndView removeBookmarkFunction(@RequestParam("pr_no") String pr_no,HttpSession session)
{  
    int pr_id=Integer.parseInt(pr_no);
    ModelAndView mav=new ModelAndView();
   cbdao.deleteBookmark(pr_id,(String)session.getAttribute("user"));
    mav.setViewName("removeBookmark");
    return mav;
}
@RequestMapping(value="removeCartItem.htm")
public ModelAndView removeCartItemFunction(@RequestParam("pr_no") String pr_no,HttpSession session)
{  
    int pr_id=Integer.parseInt(pr_no);
    ModelAndView mav=new ModelAndView();
   cbdao.deleteCartItem(pr_id,(String)session.getAttribute("user"));
    mav.setViewName("removeCartItem");
    return mav;
}
@RequestMapping(value="endPage.htm")
public ModelAndView endPageFunction(HttpSession session)
{ 
    ModelAndView mav=new ModelAndView();
    mav.setViewName("endPage");
    return mav;
}
}
