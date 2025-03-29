package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getRequestLineMethod01")
public class GetRequestLineMethod01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.get request method
        String method = req.getMethod();
        System.out.println("method is : "+method);

//        2. get virtual catalog
        String contextPath = req.getContextPath();
        System.out.println("contextPath is : "+contextPath);

//        3. get servlet path
        String servletPath = req.getServletPath();
        System.out.println("servletPath is : "+servletPath);

//        4. get "get" method request parameter
        String queryString = req.getQueryString();
        System.out.println("queryString is : "+queryString);

//        5. get uri and url
        String requestURI = req.getRequestURI();
        System.out.println("requestURI is : "+requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL is : "+requestURL);

//        6.get protocol and version
        String protocol = req.getProtocol();
        System.out.println("protocol is : "+protocol);

//        7.get client ip address
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr is : "+remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
