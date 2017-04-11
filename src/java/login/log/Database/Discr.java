package login.log.Database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sakshi Agarwal on 23-12-2016.
 */
public class Discr {
    private int pr_no;
   //  private int price;
    private String colour;
    private String brand;
    private String url;

    public int getPr_no() {
        return pr_no;
    }

    public void setPr_no(int pr_no) {
        this.pr_no = pr_no;
    }

    //public float getPrice() {
        //return price;
    //}

//    public void setPrice(int price) {
  //      this.price = price;}

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Discr(int pr_no, String colour, String brand, String url) {
        this.pr_no = pr_no;
    //    this.price = price;
        this.colour = colour;
        this.brand = brand;
        this.url = url;
    }

    public Discr() {
    }

    public List<Discr> findListp(List<Show> l)
    {

        Iterator<Show> it1=l.iterator();
        List<Discr> res = new ArrayList();
        while (it1.hasNext()) {
            Show s1=it1.next();
            Show s2=it1.next();
            Show s3=it1.next();


            res.add(new Discr(s1.getPr_no(),s2.getSpecs_values(),s1.getSpecs_values(),s3.getSpecs_values()));
        }
        return res;
    }
   /* public List<Discr> findListb(List<CBItems> l)
    {

        Iterator<CBItems> it1=l.iterator();
        List<Discr> res = new ArrayList();
        while (it1.hasNext()) {
            CBItems s1=it1.next();
            CBItems s2=it1.next();
            CBItems s3=it1.next();


            res.add(new Discr(s1.getPr_no(),s2.getSpecs_values(),s1.getSpecs_values(),s3.getSpecs_values()));
        }
        return res;
    }*/
}
