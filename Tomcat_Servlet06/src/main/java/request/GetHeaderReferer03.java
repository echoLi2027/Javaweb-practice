package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/getHeaderReferer03")
public class GetHeaderReferer03 extends HttpServlet {

    /*
    *
    * referer usually been used as accounting or protect external website visited internal resources
    * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String referer = req.getHeader("referer");
        System.out.println(referer);

        if (referer != null){
            if (referer.contains("/requestLearning")){
                resp.getWriter().write("welcome to request learning...");
            }else{
//                if using Chinese
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("please come to the right webpage....");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
