package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/serializedSessionTest04")
public class SerializedSessionTest04 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        /*
        * JSESSIONIDD27DFC241B7435D3630D49BE72441482
          JSESSIONID1648F0071D6D6D271F81C6D2E3999B11
        * */
        System.out.println(session.getId());

    }
}
