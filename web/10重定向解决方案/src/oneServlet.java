import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class oneServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        System.out.println("oneServlet 负责第一件事");
//        重定向解决方法
        response.sendRedirect("/myweb/tow");
//        response.sendRedirect("http://www.baidu.ccom");
    }
}
