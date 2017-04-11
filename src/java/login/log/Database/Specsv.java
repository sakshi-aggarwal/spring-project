package login.log.Database;

/**
 * Created by Sakshi Agarwal on 20-12-2016.
 */
public class Specsv {
    private int pr_no;
    private int pid;
    private int sid;
    private String specs_values;
    private String status;

    public int getPr_no() {
        return pr_no;
    }

    public void setPr_no(int pr_no) {
        this.pr_no = pr_no;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSpecs_values() {
        return specs_values;
    }

    public void setSpecs_values(String specs_values) {
        this.specs_values = specs_values;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
