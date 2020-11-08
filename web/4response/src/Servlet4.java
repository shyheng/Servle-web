import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet4 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rue = "http://www.baidu.com";
//        通过响应对象，将地址赋给响应头中location属性
        response.sendRedirect(rue);
    }
    /*
    * 浏览器收到响应后
    * 向请求行为   请求地址，请求方式，请求参数
    * */
}
