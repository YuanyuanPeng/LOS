import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Created by Phyllis Peng on 5/23/2016.
 */
public class MyUser {
    private String Gmail;
    private String Id;
    private String  Name;

    private String Addr;
    private String Role;

    public MyUser(){

    }
    public MyUser(String gmail, String id, String  name, String addr, String role){
        Gmail=gmail;
        Id=id;
        Name=name;

        Addr=addr;
        Role=role;

    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String addr) {
        Addr = addr;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}