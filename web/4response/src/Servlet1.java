import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet1 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String result = "hele";//执行结果

//        响应对象写入响应体 start

//        通过响应对象，向Tomcat索要输出流
        PrintWriter out = response.getWriter();
//通过输入流，将执行结果以二进制形式写入到响应体
        out.write(result);

//        将响应对象写入响应体中
    }//doget执行完
//    Tomcat将响应包推送给浏览器
}
