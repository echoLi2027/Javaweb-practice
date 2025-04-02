package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        1. set request code
        req.setCharacterEncoding("UTF-8");
//        2. get parameters
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

//        3. get generated code
        HttpSession session = req.getSession();
        String session_code = (String) session.getAttribute("session_checkCode");
//        3.1 in case the user return the webpage and vicious register
        session.removeAttribute("session_checkCode");
//        3.2 verify the check code
        if (checkCode != null && checkCode.equalsIgnoreCase(session_code)) {
            if (username.equals("admin") && password.equals("123")) {
//                all set
                session.setAttribute("username", username);
                resp.sendRedirect(req.getContextPath() + "/success.jsp");
            }else{
//                username or password wrong
                req.setAttribute("login_error","username or password error.");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        }else{
//            if the check code is wrong
            req.setAttribute("cc_error","check code error.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }


    }
}
