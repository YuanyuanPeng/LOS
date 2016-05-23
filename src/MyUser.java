import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Created by Phyllis Peng on 5/23/2016.
 */
public class MyUser {
    private String Gmail;
    private String Id;
    private String FirstName;
    private String LastName;
    private String Addr;
    private String Role;

    public MyUser(){
        
    }
    public MyUser(String gmail, String id, String fistName, String lastName, String addr, String role){
        Gmail=gmail;
        Id=id;
        FirstName=fistName;
        LastName=lastName;
        Addr=addr;
        Role=role;

    }



}