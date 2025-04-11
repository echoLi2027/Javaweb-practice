package servlet;

import domain.PageBean;
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

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
//        1.get these parameter from js

        String currentPageStr = req.getParameter("currentPage");
        String rowsStr = req.getParameter("rows");

//        1.1 get the select values for complex selection
        Map<String, String[]> condition = req.getParameterMap();

        System.out.println("===========");
        for (String s : condition.keySet()) {
            System.out.println(s+":"+condition.get(s)[0]);
        }
        System.out.println("===========");

//        in case forward from index.jsp page
        if (currentPageStr == null || currentPageStr.equals("")) {
            currentPageStr = "1";
        }
//        in case forward from index.jsp page
        if (rowsStr == null || rowsStr.equals("")) {
            rowsStr = "5";
        }

        int currentPage = Integer.parseInt(currentPageStr);
        int rows = Integer.parseInt(rowsStr);
//        in case when current page == 1, but user press previous page button
        if (currentPage <= 0) {
            currentPage = 1;
        }

        UserService service = new UserServiceImpl();
//        2. call service to get pageBean
        PageBean<User> pageBean = service.findUserByPage(currentPage, rows, condition);

        System.out.println("after dao query...........");

        System.out.println("currentPage:"+pageBean.getCurrentPage());

        System.out.println("----------------------");
//        3. set attr to request
        req.setAttribute("pageBean", pageBean);

        if (pageBean.getCurrentPage() > pageBean.getTotalPage()) {
            pageBean.setCurrentPage(pageBean.getTotalPage());
        }
//        4. dispatcher to list to show this info
//        Warning: dispatcher is forward within the request area so the path already contain the context path.
//        req.getRequestDispatcher(req.getContextPatPath() + "/list.jsp").forward(req, resp);
        req.getRequestDispatcher( "/list.jsp").forward(req, resp);
    }
}
