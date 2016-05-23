import com.google.appengine.api.datastore.*;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Phyllis Peng on 5/23/2016.
 */
public class loanServlet extends HttpServlet{




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Key userKey = KeyFactory.createKey("UserPrefs", user.getUserId());
        Entity userPrefs = new Entity(userKey);
        MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
        String cacheKey = "UserPrefs:" + user.getUserId();

        try {

            userPrefs.setProperty("email", user.getEmail());
            userPrefs.setProperty("user", user);
            ds.put(userPrefs);
            memcache.delete(cacheKey);

        } catch (NumberFormatException nfe) {
            // User entered a value that wasn't an integer. Ignore for now.
        }

        response.sendRedirect("/");
    }


}
