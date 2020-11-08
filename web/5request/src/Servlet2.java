import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Servlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        通过请求对象获得请求头中的请求参数名
        Enumeration paramNae =  request.getParameterNames();
        while (paramNae.hasMoreElements()){
//            获取参数名
            String pas = (String)paramNae.nextElement();
//            通过请求对象读取指定参数值
//            获取参数值
            String value = request.getParameter(pas);
            System.out.println("请求参数名 "+pas+"参数值 "+value);
        }
    }
}
