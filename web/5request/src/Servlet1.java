import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      1  通过    请求对象，读取请求行中URL信息
        String url = request.getRequestURL().toString();
//        2 通过请求对象，读取请求行中method信息
        String method = request.getMethod();
        System.out.println("url "+url);
        System.out.println("method "+method);

/*
* 获取URI，资源精准定位
*    实际从URL中截取的字符串，这个字符串格式“/网站名/资源文件名”
* */

        String uri = request.getRequestURI();
        System.out.println("uri "+uri);
    }
}
