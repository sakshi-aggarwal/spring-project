package login.log.Database;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by naman on 16-12-2016.
 */
public class Customer {

    @NotNull
    @Size(min=5,message = "/*already registered username or size less than 5*/" )
    public String Username;
    @NotNull
    @Size(min=6,message="/*min  6 characters*/")
    public String password;
    @NotNull
    @Size(min=10,message="/*size should be 10*/")
    @Digits(fraction = 0, integer = 10,message = "/*no character*/")
    public String  number;

//no-arg and parameterized constructors



    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
