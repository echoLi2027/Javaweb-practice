package download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet09")
public class DownloadServlet09 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        1. get filename from request
        String fileName = req.getParameter("fileName");

//        2. using input stream loads the file
//        2.1 find file path in the server
        ServletContext servletContext = this.getServletContext();
        String path = servletContext.getRealPath("/img/" + fileName);

        FileInputStream fis = new FileInputStream(path);

//        3 get file MIME type
        String mimeType = servletContext.getMimeType(fileName);
//        3.1 set mime type
        resp.setHeader("Content-Type", mimeType);

//        3.2 set content-disposition
        resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);

//        4. write input stream into output stream
        ServletOutputStream os = resp.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(bytes)) != -1){
            os.write(bytes, 0, len);
        }
        fis.close();


    }
}
