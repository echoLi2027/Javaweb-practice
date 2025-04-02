package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serializedSession03")
public class SerializedSession03 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /*

            ***session is relay on cookie*****

            differences between session and cookie:
                1.session stores in server side while cookie stores in client side.
                2. session doesn't have data size limitation, but cookie does.
                3. session is data secured, while cookie not.



    * */


        HttpSession session = req.getSession();

//        even browser is closed, the next time open the browser the session is still the same
        Cookie cookie = new Cookie("JSESSIONID", session.getId());

        cookie.setMaxAge(60 * 60 * 24 * 7);

        resp.addCookie(cookie);

    }
}
