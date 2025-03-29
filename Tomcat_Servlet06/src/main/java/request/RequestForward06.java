package request;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestForward06")
public class RequestForward06 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }

    /*
    *
    * area obj: an obj has limited influence scope, but this type of obj can be shared between this scope
    * by setAttribute(), getAttribute(), removeAttribute()
    * */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("msg","hello there...");


        /*
        *
        * dispatcher features:
        *   1.browser url path stays the same.
        *   2.only forward within the server's internal resources.
        *   3.forward is one request.(request obj is the same)
        * */
        req.getRequestDispatcher("/requestForward07").forward(req, resp);

        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);

        System.out.println("----------");


    }
}
