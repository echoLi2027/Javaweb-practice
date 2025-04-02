package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*

   Task description: set a cookie named lastTime, every time when login the webpage
    1. if there is no lastTime cookie:
        1. create it and response : hello, it's your first time of visiting...
        2. write the visiting time to lastTime cookie

    2. if already existed:
        1. response : welcome back, last time of visiting is xxxx
        2. write this time's visiting time as lastTime for the next time visiting.

* */

@WebServlet("/cookieTest05")
public class CookieTest05 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {

                String name = cookie.getName();

                // debug info
                System.out.println("Cookie name: [" + name + "], length: " + name.length());
                System.out.println("Equal check: " + name.equals("lastTime"));

                if ("lastTime".equals(name)) {
                    cookie.setMaxAge(24 * 60 * 60);
                    String value = cookie.getValue();
                    String decode = URLDecoder.decode(value, "UTF-8");
                    resp.getWriter().write("welcome back, last time of visiting is "+decode);
                    Date date = new Date();
                    String str_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
                    String encode_date = URLEncoder.encode(str_date);
                    cookie.setValue(encode_date);
//                    after setting the value, must add the cookie back again....
                    resp.addCookie(cookie);
                    flag = true;
                    break;
                }
            }
        }

        if (cookies == null || cookies.length == 0 || flag==false) {
            Cookie lastTimeCookie = createLastTimeCookie();
            resp.addCookie(lastTimeCookie);
            resp.getWriter().write("hello, it's your first time of visiting...");
        }

    }

    protected Cookie createLastTimeCookie() {
        Date date = new Date();
        String str_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        String encode_date = URLEncoder.encode(str_date);
        Cookie lastTime = new Cookie("lastTime", encode_date);
        lastTime.setMaxAge(24 * 60 * 60);
        return lastTime;
    }
}
