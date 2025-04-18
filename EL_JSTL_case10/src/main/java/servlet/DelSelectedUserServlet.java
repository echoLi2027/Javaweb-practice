package servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectedUserServlet")
public class DelSelectedUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] uids = req.getParameterValues("uid");

        System.out.println(uids);

        if (uids != null || uids.length >= 0) {
            UserService service = new UserServiceImpl();

            for (String uid : uids) {
                service.deleteUser(Integer.parseInt(uid));
            }

            resp.sendRedirect(req.getContextPath() + "/userListServlet");

        }
    }
}
