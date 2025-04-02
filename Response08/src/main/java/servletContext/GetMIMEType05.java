package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getMIMEType05")
public class GetMIMEType05 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        MIME type: a file type in www communication process.
//        format: bigger type/small type ===> text/html, image/ipeg

//        1.through HttpServlet acquired
        ServletContext servletContext = this.getServletContext();

        String fileName = "a.jpg";

//        3. get MIME type
        String mimeType = servletContext.getMimeType(fileName);
        System.out.println(mimeType);

    }
}
