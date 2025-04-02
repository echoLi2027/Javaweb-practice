package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieLifetime03")
public class CookieLifetime03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//         you can add up to 20 cookies to a webpage
        Cookie msg = new Cookie("msg", "helloThere...");
        Cookie msg2 = new Cookie("msg2", "helloWorld...");

        resp.addCookie(msg);
        resp.addCookie(msg2);

//        1. delete cookie info immediately even in this webpage now
//        msg.setMaxAge(0);
//        2. delete cookie after close the browser
//        msg2.setMaxAge(-1);
//        3. serialize the cookie into disk, assigned the living time (below is 1 week),
//        after time out cookie will be deleted automatically
        msg2.setMaxAge(60*60*24*7);






    }
}
