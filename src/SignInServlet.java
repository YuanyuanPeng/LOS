import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Phyllis Peng on 5/23/2016.
 */
public class SignInServlet extends HttpServlet{
    private static final Logger log = Logger.getLogger(SignInServlet.class.getName());



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        MyUser user1;
        if(user != null){
            user1=new MyUser(user.getNickname(),user.getUserId(),"","","");
           System.out.print(user1);
        }else{
            user1=new MyUser();
        }
    }


    private JsonObject makeMyUserJson(MyUser mu) {
        return Json.createObjectBuilder()
                .add("user",mu.getGmail())
                .add("id",mu.getId())
                .add("name", mu.getName())
                .add("addr",mu.getAddr())
                .add("role",mu.getRole()).build();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        String loginUrl = userService.createLoginURL("/");
        String logoutUrl = userService.createLogoutURL("/");
        JsonObject jsonO;

        Entity UserInfo = null;

        if (user != null){
            DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
            MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();

            jsonO = Json.createObjectBuilder()
                    .add("user",user.getNickname())
                    .add("loginUrl", loginUrl)
                    .add("logoutUrl",logoutUrl).build();
           /* MyUser user1 = ObjectifyService.ofy().load().type(MyUser.class).id(user.getNickname()).now();


            if(user1 == null){
                user1 = new MyUser(user.getNickname(),user.getUserId(),"","","","");
                ObjectifyService.ofy().save().entity(user1).now();
            }else{
                jsonO = Json.createObjectBuilder()
                        .add("loginUrl",loginUrl)
                        .add("logoutUrl",logoutUrl).build();
            }*/

            String userid = user.getUserId();
            String nickname = user.getNickname();
            UserInfo = (Entity) memcache.get(userid);

            if(UserInfo == null){
                log.warning("No user found");
                Key userkey = KeyFactory.createKey("UserInfo",user.getUserId());
                try{
                    UserInfo = ds.get(userkey);
                    memcache.put(userid,UserInfo);

                }catch(EntityNotFoundException e){

                }
            }else{
                log.warning("found user");
            }

        }

        request.setAttribute("user",user);
        request.setAttribute("loginUrl",loginUrl);
        request.setAttribute("logoutUrl",logoutUrl);

        response.setContentType("text/html");

       RequestDispatcher jsp = request.getRequestDispatcher("index.jsp");

   jsp.forward(request,response);



    }



}
