package servlet;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        set character encoding
        req.setCharacterEncoding("UTF-8");

//        get all the data;
        /*Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keys = parameterMap.keySet();*/
        String name = req.getParameter("name");
        String qq = req.getParameter("qq");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");

        System.out.println(name + " " + qq + " " + email + " " + gender + " " + age + " " + address);

        User user = new User(name,gender, age,address,qq,email);

        UserService service = new UserServiceImpl();

        int i = service.addUser(user);

        if (i > 0) {
            resp.sendRedirect("./userListServlet");
        }else{
            resp.sendRedirect("./add.jsp");
        }
    }
}
