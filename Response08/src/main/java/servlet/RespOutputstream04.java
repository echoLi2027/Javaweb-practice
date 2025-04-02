package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ ")
public class RespOutputstream04 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        easier way
        resp.setContentType("text/html;charset=utf-8");

//        1. get character output stream
        ServletOutputStream outputStream = resp.getOutputStream();
//        2.write data
        outputStream.write("<h1>hello output stream...</h1>".getBytes("UTF-8"));
        outputStream.write("<h1>goodbye output stream...</h1>".getBytes("utf-8"));

    }
}
