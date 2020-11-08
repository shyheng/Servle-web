import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class oneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1将数据添加到请求作用域中的attribute属性
        request.setAttribute("key1","hellword");
//        2向Tomcat申请调用twoservlet
        request.getRequestDispatcher("/two").forward(request,response);

    }
}
