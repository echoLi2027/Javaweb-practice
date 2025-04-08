package servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        set character encoding
        req.setCharacterEncoding("UTF-8");
//        get all params
        Map<String, String[]> parameterMap = req.getParameterMap();

        for (String s : parameterMap.keySet()) {
            String[] values = parameterMap.get(s);
            System.out.println(s+"-----"+values[0]);
        }
//        encapsulate user
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

//        modify the user by user service
        UserService service = new UserServiceImpl();

//        it's ok to use it, but not efficient
//        User user = service.findUserById(id);

//        modified the updated user info
        service.updateUser(user);


//         after updated back to list page.
        resp.sendRedirect(req.getContextPath()+"/userListServlet");

    }
}
