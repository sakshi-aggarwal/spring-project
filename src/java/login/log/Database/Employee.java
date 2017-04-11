package login.log.Database;

/**
 * Created by Sakshi Agarwal on 11-12-2016.
 */
public class Employee {
   private int id;
    private String name;

//no-arg and parameterized constructors

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

public String toString() {
    return id+" "+name;
}
}