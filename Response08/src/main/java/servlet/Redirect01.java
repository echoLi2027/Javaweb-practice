package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/redirect01")
public class Redirect01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("redirect01 been visited");

//        2 times request, so this msg cannot be acquired by redirectTest01
        req.setAttribute("msg","hello there...");

//        original theory
//        1. set status code as 302
/*        resp.setStatus(302);
//        2. set header location
        resp.setHeader("location","/response/redirectTest01");*/

//        dynamically get context path
        String contextPath = req.getContextPath();

        resp.sendRedirect(contextPath+"/redirectTest01");

    }
}
