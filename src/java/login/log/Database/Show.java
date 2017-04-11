package login.log.Database;

/**
 * Created by Sakshi Agarwal on 04-01-2017.
 */
public class Show {
    private int pr_no;
    private String specification_name;
    private String specs_values;

    public int getPr_no() { return pr_no; }

    public void setPr_no(int pr_no) {
        this.pr_no = pr_no;
    }

    public String getSpecification_name() {
        return specification_name;
    }

    public void setSpecification_name(String specification_name) {
        this.specification_name = specification_name;
    }

    public String getSpecs_values() {
        return specs_values;
    }

    public void setSpecs_values(String specs_values) {
        this.specs_values = specs_values;
    }
}
