package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/respWriter03")
public class RespWriter03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        1.before get stream obj, set default stream coding : iso-8859-1 as utf-8
//        req.setCharacterEncoding("UTF-8");

//        2. tell browser the coding format of msg body by server. suggest browser use this format to decode
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");

//        easier way
        resp.setContentType("text/html;charset=utf-8");

//        1. get character output stream
        PrintWriter writer = resp.getWriter();
//        2.write data
        writer.write("<h1>hello there...</h1>");
        writer.write("<h1>goodbye there...</h1>");

    }
}
