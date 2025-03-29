package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestUniMethod05")
public class RequestUniMethod05 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this method can be used by post and get method without any difference

//        1. get value according to parameter name

//        P.S. if there is character encoding problem
//        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        System.out.println(username);

//        2. get an array according to parameter name
        String[] hobbies = req.getParameterValues("hobbies");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

//        3. get all request parameter name
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = req.getParameter(name);
            System.out.println(name+"-----"+value);
        }

        System.out.println("---------------");

        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> ss = parameterMap.keySet();
        for (String name : ss) {
            String[] values = parameterMap.get(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("---------------");
        }


    }
}
