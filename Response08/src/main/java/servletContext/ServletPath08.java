package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletPath08")
public class ServletPath08 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext servletContext = this.getServletContext();

//        all under : Response08-1.0-SNAPSHOT/


        String pathB = servletContext.getRealPath("/servletPathB.txt");

        System.out.println(pathB);

        String pathC = servletContext.getRealPath("/WEB-INF/servletPathC.txt");

        System.out.println(pathC);

        String pathA = servletContext.getRealPath("/WEB-INF/classes/servletPathA.txt");
        System.out.println(pathA);


    }
}
