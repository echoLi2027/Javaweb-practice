package filter;

import domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //1. convert request into HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;

//        2. get request path which conduct to visit targeted resources
        String uri = req.getRequestURI();

        System.out.println("uri:"+uri);

        System.out.println("url:"+req.getRequestURL());

//        3. if already plan to visit login part then let it access to the resources
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCode")){

            chain.doFilter(request, response);
        }else{

//            4. if not, check if there is a attribute called "user".
            HttpSession session = req.getSession();
            User user = (User)session.getAttribute("user");

            if (user != null){
                chain.doFilter(request, response);
            }else{
                request.setAttribute("login_msg","you are not logged in, please login first.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
